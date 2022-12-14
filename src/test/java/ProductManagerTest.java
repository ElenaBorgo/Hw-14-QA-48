import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Manager.ProductManager;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import ru.netology.Repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "Evgeni Onegin", 300, "A.Pushkin");
    Product item2 = new Smartphone(33, "android", 20_000, "samsung company");
    Product item3 = new Book(23, "Anna Karenina", 500, "L.Tolstoy");
    Product item4 = new Smartphone(140, "android", 330_000, "sony company");

    @Test
    public void shouldShowAll() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = manager.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Onegin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByPhoneName() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {item2, item4};
        Product[] actual = manager.searchBy("android");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ifNoSameName() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Harry Potter");

        Assertions.assertArrayEquals(expected, actual);
    }
}
