package com.github.niyaz000.taas.controller;

import com.github.niyaz000.taas.constant.Routes;
import com.github.niyaz000.taas.dto.ProductDto;
import com.github.niyaz000.taas.model.Product;
import com.github.niyaz000.taas.service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping(path = Routes.ACCOUNTS_PATH)
  public Product addProduct(@Validated @RequestBody ProductDto productDto) {
    return productService.addProduct(productDto);
  }

}
