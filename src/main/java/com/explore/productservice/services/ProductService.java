package com.explore.productservice.services;
import com.explore.productservice.exceptions.ProductNotFoundException;
import com.explore.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductDetails(Long id) throws ProductNotFoundException;
    public Product createProduct(String title, String description,String image,double price,String Category);
    public List<Product> getAllProducts();

}
