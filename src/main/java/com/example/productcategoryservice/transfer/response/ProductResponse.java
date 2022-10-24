package com.example.productcategoryservice.transfer.response;

import com.example.productcategoryservice.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponse {
    private long id;
    private String title;
    private int count;
    private double price;
    private CategoryResponse category;
}
