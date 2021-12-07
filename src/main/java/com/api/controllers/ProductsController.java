package com.api.controllers;

import com.business.abstracts.ProductService;
import com.core.DataResult;
import com.core.Result;
import com.entities.concretes.Product;
import com.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {


    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getAllPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return productService.getAll(pageNo, pageSize);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory_CategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategory_CategoryId")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("/getByCategory_CategoryIdIn")
    public DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam List<Integer> categories) {
        return productService.getByCategory_CategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByProductNameEndsWith")
    public DataResult<List<Product>> getByProductNameEndsWith(@RequestParam String productName) {
        return productService.getByProductNameEndsWith(productName);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted() {
        return productService.getAllSorted();
    }

    @GetMapping("/getProductWithCategoryDtoDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDtoDetails() {
        return productService.getProductsWithCategoryDetails();
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int category) {
        return productService.getByNameAndCategory(productName, category);
    }

}
