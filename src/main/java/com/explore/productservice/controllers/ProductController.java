package com.explore.productservice.controllers;

import com.explore.productservice.models.Product;
import com.explore.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public void getallProducts(){

    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") long id){
        return productService.getProductDetails(id);

    }

    public void createProduct(){

    }
}
