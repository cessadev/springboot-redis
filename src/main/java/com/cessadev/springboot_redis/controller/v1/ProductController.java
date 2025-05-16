package com.cessadev.springboot_redis.controller.v1;

import com.cessadev.springboot_redis.model.Product;
import com.cessadev.springboot_redis.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping()
  public ResponseEntity<?> getAllProducts() {
    try {
      return ResponseEntity.ok(productService.getAllProducts());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @GetMapping("{productId}")
  public ResponseEntity<?> getProductById(
          @Valid @PathVariable Long productId) {
    try {
      return ResponseEntity.ok(productService.getProductById(productId));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @PostMapping("/create")
  public ResponseEntity<?> createProduct(
          @Valid @RequestBody Product product) {
    try {
      Product productSaved = productService.createProduct(product);
      return ResponseEntity
              .created(URI.create("/api/v1/products/create"))
              .body(productSaved);
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
  }

}
