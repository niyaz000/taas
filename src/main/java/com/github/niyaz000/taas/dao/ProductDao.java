package com.github.niyaz000.taas.dao;

import com.github.niyaz000.taas.model.Product;
import com.github.niyaz000.taas.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {

  private final ProductRepository repository;

  public ProductDao(ProductRepository repository) {
    this.repository = repository;
  }

  public Product save(Product service) {
    return repository.save(service);
  }
}
