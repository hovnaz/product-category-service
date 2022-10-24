package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.service.CategoryService;
import com.example.productcategoryservice.transfer.request.CategoryRequest;
import com.example.productcategoryservice.transfer.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryEndpoint {
    private final CategoryService categoryService;

    @GetMapping(name = "/")
    public ResponseEntity<?> getAllCategories(){
        List<CategoryResponse> all = categoryService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable int id){
        CategoryResponse byId = categoryService.findById(id);
        return ResponseEntity.ok(byId);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest categoryRequest){
        categoryService.save(categoryRequest);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id,@RequestBody CategoryRequest categoryRequest){
        categoryService.update(id, categoryRequest);
    }
}
