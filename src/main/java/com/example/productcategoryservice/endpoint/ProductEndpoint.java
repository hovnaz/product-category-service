package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.entity.Product;
import com.example.productcategoryservice.service.ProductService;
import com.example.productcategoryservice.transfer.request.ProductRequest;
import com.example.productcategoryservice.transfer.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductEndpoint {
    private final ProductService productService;

    @GetMapping("/")
    public List<ProductResponse> getAllProducts() {
        return productService.findAll();
    }
    @PostMapping("/")
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.save(productRequest);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable int id) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updateProductById(@PathVariable int id, @RequestBody ProductRequest productRequest){
        productService.update(id, productRequest);
    }
    @GetMapping("/byCategory/{id}")
    public List<Product> findAllByCategoryId(@PathVariable int id){
        return productService.findAllByCategoryId(id);
    }
}
