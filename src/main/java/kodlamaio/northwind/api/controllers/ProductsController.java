package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.entities.concretes.Category;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }
    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }
    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam List<Integer> categories){
        return this.productService.getByCategory_CategoryIdIn(categories);
    }
    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }
    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }
    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();
    }
}
