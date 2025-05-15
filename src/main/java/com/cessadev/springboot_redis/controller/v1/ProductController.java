package com.cessadev.springboot_redis.controller.v1;

import com.cessadev.springboot_redis.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
