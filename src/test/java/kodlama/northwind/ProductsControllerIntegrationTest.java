package kodlama.northwind;

import kodlamaio.northwind.NorthwindApplication;
import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.entities.concretes.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = NorthwindApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductsControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    @Test
    void testGetAllProducts() {
        productService.add(new Product(1, "Product A", 10.0, (short) 5, "1 unit", null));

        // Act
        ResponseEntity<DataResult<List<Product>>> response = restTemplate.exchange(
                "/api/products/getAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<DataResult<List<Product>>>() {}
        );

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(78, response.getBody().getData().size());
    }
}