package com.example.productcategoryservice.service;

import com.example.productcategoryservice.transfer.request.ProductRequest;
import com.example.productcategoryservice.transfer.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse findById(long id);

    List<ProductResponse> findAll();

    void deleteById(long id);

    void save(ProductRequest productRequest);

    void update(int id, ProductRequest productRequest);
}
