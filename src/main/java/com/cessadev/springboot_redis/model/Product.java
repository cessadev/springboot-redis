package com.cessadev.springboot_redis.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
  @SequenceGenerator(name = "products_seq", sequenceName = "products_seq", allocationSize = 1)
  private Long id;

  private String code;
  private String name;
  private double price;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id) && Objects.equals(code, product.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code);
  }
}
