package com.cessadev.springboot_redis.service.impl;

import com.cessadev.springboot_redis.model.Product;
import com.cessadev.springboot_redis.persistence.repository.ProductRepository;
import com.cessadev.springboot_redis.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  @Cacheable(value = "products", key = "'all'")
  public List<Product> getAllProducts() {
    System.out.println(">>> Querying the DB <<<");
    return productRepository.findAll();
  }

  @Override
  @Cacheable(value = "products", key = "#id")
  public Product getProductById(Long id) {
    System.out.println(">>> Querying the DB <<<");
    return productRepository.findById(id).orElseThrow();
  }

  @Override
  @CacheEvict(value = "products", key = "'all'")
  public Product createProduct(Product product) {
    System.out.println(">>> Cache cleared <<<");
    return productRepository.save(product);
  }

  @Override
  @CacheEvict(value = "products", allEntries = true)
  public void clearCache() {
    System.out.println(">>> Cache cleared <<<");
  }
}
