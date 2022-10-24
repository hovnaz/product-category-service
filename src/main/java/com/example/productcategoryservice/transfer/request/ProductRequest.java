package com.example.productcategoryservice.transfer.request;

import com.example.productcategoryservice.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequest {
    private String title;
    private int count;
    private double price;
    private long category;
}
