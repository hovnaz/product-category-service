package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.mapper.base.BaseMapper;
import com.example.productcategoryservice.transfer.request.ProductRequest;
import com.example.productcategoryservice.transfer.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @see org.modelmapper.ModelMapper
 */
@Service
@RequiredArgsConstructor
public class ProductMapper implements BaseMapper<Product, ProductRequest, ProductResponse> {

    private final ModelMapper modelMapper;

    @Override
    public Product toEntity(ProductRequest productRequest) {
        return modelMapper.map(productRequest, Product.class);
    }

    @Override
    public ProductResponse toResponse(Product product) {
        return modelMapper.map(product, ProductResponse.class);
    }
}