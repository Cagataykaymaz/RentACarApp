package kodlama.northwind;

import kodlamaio.northwind.api.controllers.ProductsController;
import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.mock;

public class ProductsPerformanceTest {

    private final ProductService productService = mock(ProductService.class);
    private final ProductsController productsController = new ProductsController(productService);

    @Test
    void testPerformanceUnderLoad() throws InterruptedException {
        // Arrange
        int threadCount = 100;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // Act
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                // Get all products
                long startTimeGetAll = System.nanoTime();
                productsController.getAll();
                long endTimeGetAll = System.nanoTime();
                System.out.println("getAll took: " + (endTimeGetAll - startTimeGetAll) + " nanoseconds");

                // Add a new product
                long startTimeAdd = System.nanoTime();
                productsController.add(new Product());
                long endTimeAdd = System.nanoTime();
                System.out.println("add took: " + (endTimeAdd - startTimeAdd) + " nanoseconds");
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // Assert
        // Eğer bir performans ölçümü yapılacaksa burada sistem metrikleri eklenebilir.
    }
}
