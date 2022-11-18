package com.crudproductos.crudmongodbback.CRUD.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudproductos.crudmongodbback.CRUD.dto.ProductDto;
import com.crudproductos.crudmongodbback.CRUD.entity.Product;
import com.crudproductos.crudmongodbback.CRUD.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }
    
    public Product getOne(int id) {
        return productRepository.findById(id).get();
    }

    public Product save(ProductDto dto) {
        int id = autoIncrement();
        Product product = new Product(id, dto.getNombre(), dto.getPrecio());
        return productRepository.save(product);
    }

    public Product update(int id, ProductDto dto) {
        Product product = productRepository.findById(id).get();
        product.setNombre(dto.getNombre());
        product.setPrecio(dto.getPrecio());
        return productRepository.save(product);
    }

    public Product delete(int id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return product;
    }

    //private methods
    private int autoIncrement() {
        List<Product> products = productRepository.findAll();
        return products.isEmpty()? 1 :
                products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }
}
