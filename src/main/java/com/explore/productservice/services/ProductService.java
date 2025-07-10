package com.explore.productservice.services;
import com.explore.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductDetails(Long id);
    public Product createProduct(String title, String description,String image,double price,String Category);
    public List<Product> getAllProducts();

}
