import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Manager.ProductManager;
import ru.netology.Product.Book;
import ru.netology.Product.Product;
import ru.netology.Product.Smartphone;
import ru.netology.Repository.ProductRepository;
import ru.netology.exceptions.NotFoundException;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "Evgeni Onegin", 300, "A.Pushkin");
    Product item2 = new Smartphone(33, "android", 20_000, "samsung company");
    Product item3 = new Book(23, "Anna Karenina", 500, "L.Tolstoy");
    Product item4 = new Smartphone(140, "IPhone", 330_000, "apple company");

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
    }

    @Test
    public void shouldSaveNewProduct() {
        Product item = new Book(24, "Memoirs", 500, "S.Prokofiev");

        repo.save(item);

        Product[] expected = {item1, item2, item3, item4, item};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(33);

        Product[] expected = {item1, item3, item4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNotFoundId() {
        repo.removeById(45);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(45);
        });
    }

    @Test
    public void shouldShowAll() {
        repo.findAll();

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}

