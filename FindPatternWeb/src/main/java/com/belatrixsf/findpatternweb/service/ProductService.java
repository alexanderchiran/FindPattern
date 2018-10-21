package com.belatrixsf.findpatternweb.service;

import com.belatrixsf.findpatternweb.model.Product;

public interface ProductService {

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

}
