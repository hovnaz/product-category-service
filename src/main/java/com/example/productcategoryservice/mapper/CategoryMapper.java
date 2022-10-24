package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.entity.Category;
import com.example.productcategoryservice.mapper.base.BaseMapper;
import com.example.productcategoryservice.transfer.request.CategoryRequest;
import com.example.productcategoryservice.transfer.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @see org.modelmapper.ModelMapper
 */
@Service
@RequiredArgsConstructor
public class CategoryMapper implements BaseMapper<Category, CategoryRequest, CategoryResponse> {

    private final ModelMapper modelMapper;

    @Override
    public Category toEntity(CategoryRequest categoryRequest) {
        return modelMapper.map(categoryRequest, Category.class);
    }

    @Override
    public CategoryResponse toResponse(Category category) {
        return modelMapper.map(category, CategoryResponse.class);
    }
}