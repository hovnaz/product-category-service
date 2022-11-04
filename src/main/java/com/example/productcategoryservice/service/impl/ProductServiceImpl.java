package com.example.productcategoryservice.service.impl;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.exception.NotFoundException;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.mapper.ProductMapper;
import com.example.productcategoryservice.repository.ProductRepository;
import com.example.productcategoryservice.service.CategoryService;
import com.example.productcategoryservice.service.ProductService;
import com.example.productcategoryservice.transfer.request.ProductRequest;
import com.example.productcategoryservice.transfer.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public ProductResponse findById(long id) {
        Product product = findByIdOrElseThrow(id);
        return productMapper.toResponse(product);
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void save(ProductRequest productRequest) {
        long categoryId = productRequest.getCategory();
        Product product = productMapper.toEntity(productRequest);
        Category category = categoryService.findByIdCategory(categoryId);
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public void update(int id, ProductRequest productRequest) {
        Product product = findByIdOrElseThrow(id);
        product.setCount(productRequest.getCount());
        product.setTitle(productRequest.getTitle());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllByCategoryId(long id) {
        return productRepository.findAllByCategory_Id(id);
    }

    private Product findByIdOrElseThrow(long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "product with id: " + id + " NOT FOUND"
        ));
    }
}
