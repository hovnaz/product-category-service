package com.example.productcategoryservice.service.impl;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.exception.NotFoundException;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.repository.CategoryRepository;
import com.example.productcategoryservice.service.CategoryService;
import com.example.productcategoryservice.transfer.request.CategoryRequest;
import com.example.productcategoryservice.transfer.request.ProductRequest;
import com.example.productcategoryservice.transfer.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Category findByIdCategory(long id) {
        return findByIdCategoryOrElseThrow(id);
    }

    @Override
    public CategoryResponse findById(long id) {
        Category category = findByIdCategoryOrElseThrow(id);
        return categoryMapper.toResponse(category);
    }

    @Override
    public List<CategoryResponse> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(categoryMapper::toResponse)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void save(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toEntity(categoryRequest);
        categoryRepository.save(category);
    }

    @Override
    public void update(int id, CategoryRequest categoryRequest) {
        Category category = findByIdCategoryOrElseThrow(id);
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
    }

    private Category findByIdCategoryOrElseThrow(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "category with id: " + id + " NOT FOUND"
        ));
    }
}
