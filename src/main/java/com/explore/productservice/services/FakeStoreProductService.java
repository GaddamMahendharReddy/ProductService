package com.explore.productservice.services;

import com.explore.productservice.dtos.CreateProductRequestDto;
import com.explore.productservice.dtos.FakeStoreCreateProductDto;
import com.explore.productservice.dtos.FakeStoreProductDto;
import com.explore.productservice.exceptions.ProductNotFoundException;
import com.explore.productservice.models.Category;
import com.explore.productservice.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProductDetails(Long id) throws ProductNotFoundException {
//       FakeStoreProductDto responseDto=
//               restTemplate.getForObject(
//                       "https://fakestoreapi.com/products"+id,
//                       FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate
                .getForEntity("https://fakestoreapi.com/products"+id,FakeStoreProductDto.class);

       if(responseEntity.getStatusCode()== HttpStatusCode.valueOf(404)){
           //show some error to fe
       }
       else if(responseEntity.getStatusCode()== HttpStatus.valueOf(500)){
           //tell fe that be is not  working currently
       }

       FakeStoreProductDto responseBody=responseEntity.getBody();
       if(responseBody==null){
           throw new ProductNotFoundException("Product not found");
       }



       return responseEntity.getBody().toProduct();


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


    public List<Product> getAllProducts(){
        FakeStoreProductDto[] responseDto=restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> products=new ArrayList<>();
        for(FakeStoreProductDto Dto:responseDto){
            products.add(Dto.toProduct());
        }
        return products;

    }


}
