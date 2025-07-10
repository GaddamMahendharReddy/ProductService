package com.explore.productservice.controllers;

import com.explore.productservice.dtos.CreateProductRequestDto;
import com.explore.productservice.models.Product;
import com.explore.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
       return productService.getAllProducts();

    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") long id){
        return productService.getProductDetails(id);

    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto){
        return productService.createProduct(
            requestDto.getTitle(),
            requestDto.getDescription(),
            requestDto.getImage(),
            requestDto.getPrice(),
            requestDto.getCategory()
                );

    }
}
