package com.explore.productservice.controllers;

import com.explore.productservice.dtos.CreateProductRequestDto;
import com.explore.productservice.dtos.ErrorDto;
import com.explore.productservice.exceptions.ProductNotFoundException;
import com.explore.productservice.models.Product;
import com.explore.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public Product getProductDetails(@PathVariable("id") long id) throws ProductNotFoundException {
        return productService.getProductDetails(id);

    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto){
        Product product=productService.createProduct(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getImage(),
                requestDto.getPrice(),
                requestDto.getCategory()
        );


        ResponseEntity<Product> responseEntity=new ResponseEntity<>(product, HttpStatusCode.valueOf(201));
        return responseEntity;




    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorDto> handleNPEEception(){
//        ErrorDto errorDto=new ErrorDto();
//        errorDto.setMessage("something went wrong");
//        ResponseEntity<ErrorDto> responseEntity=
//                new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(501));
//        return responseEntity;
//
//    }
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handlePNEException(){
//        ErrorDto errorDto=new ErrorDto();
//        errorDto.setMessage("Product not found.please try again");
//        ResponseEntity<ErrorDto> responseEntity=
//                new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));
//        return responseEntity;
//    }
}
