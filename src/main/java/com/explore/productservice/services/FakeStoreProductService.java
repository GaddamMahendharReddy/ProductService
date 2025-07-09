package com.explore.productservice.services;

import com.explore.productservice.dtos.CreateProductRequestDto;
import com.explore.productservice.dtos.FakeStoreCreateProductDto;
import com.explore.productservice.dtos.FakeStoreProductDto;
import com.explore.productservice.models.Category;
import com.explore.productservice.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProductDetails(Long id){
       FakeStoreProductDto responseDto=
               restTemplate.getForObject(
                       "https://fakestoreapi.com/products"+id,
                       FakeStoreProductDto.class);

       return responseDto.toProduct();


    }

    public Product createProduct(String title, String description,String image,double price,String Category){
        FakeStoreCreateProductDto requestDto=new FakeStoreCreateProductDto();
        requestDto.setTitle(title);
        requestDto.setDescription(description);
        requestDto.setImage(image);
        requestDto.setPrice(price);
        requestDto.setCategory(Category);

        FakeStoreProductDto responseDto=restTemplate.postForObject("https://fakestoreapi.com/products",requestDto, FakeStoreProductDto.class);

       return responseDto.toProduct();
    };


}
