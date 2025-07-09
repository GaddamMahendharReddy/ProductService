package com.explore.productservice.dtos;

import com.explore.productservice.models.Category;
import com.explore.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class FakeStoreCreateProductDto {
    String title;
    String description;
    String image;
    double price;
    String category;



}
