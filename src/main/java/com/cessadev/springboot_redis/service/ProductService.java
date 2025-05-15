package com.cessadev.springboot_redis.service;

import com.cessadev.springboot_redis.model.Product;

import java.util.List;

public interface ProductService {

  List<Product> getAllProducts();

  Product getProductById(Long id);

  Product createProduct(Product product);

  void clearCache();
}
