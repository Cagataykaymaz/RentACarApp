package kodlama.northwind;

import kodlamaio.northwind.business.concretes.ProductManager;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;;

public class ProductManagerTest {

    private ProductManager productManager;
    private ProductDao productDao;

    @BeforeEach
    void setUp() {
        productDao = mock(ProductDao.class);
        productManager = new ProductManager(productDao);
    }

    @Test
    void testGetAll() {
        // Arrange
        List<Product> mockProducts = Arrays.asList(
                new Product(1, "Product A", 10.0, (short) 5, "1 unit", null),
                new Product(2, "Product B", 20.0, (short) 10, "2 units", null)
        );
        when(productDao.findAll()).thenReturn(mockProducts);

        // Act
        DataResult<List<Product>> result = productManager.getAll();

        assertEquals(2, result.getData().size());
        verify(productDao, times(1)).findAll();
    }
}
