package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.transfer.request.CategoryRequest;
import com.example.productcategoryservice.transfer.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    Category findByIdCategory(long id);

    CategoryResponse findById(long id);

    List<CategoryResponse> findAll();

    void deleteById(long id);

    void save(CategoryRequest categoryRequest);

    void update(int id, CategoryRequest categoryRequest);
}
