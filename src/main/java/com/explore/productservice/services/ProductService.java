package com.explore.productservice.services;
import com.explore.productservice.models.Product;

public interface ProductService {
    public Product getProductDetails(Long id);
    public Product createProduct(String title, String description,String image,double price,String Category);


}
