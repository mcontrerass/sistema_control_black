package com.crudproductos.crudmongodbback.CRUD.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudproductos.crudmongodbback.CRUD.dto.ProductDto;
import com.crudproductos.crudmongodbback.CRUD.entity.Product;
import com.crudproductos.crudmongodbback.CRUD.global.exceptions.AttributeException;
import com.crudproductos.crudmongodbback.CRUD.global.exceptions.ResourceNotFoundException;
import com.crudproductos.crudmongodbback.CRUD.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }
    
    public Product getOne(int id) throws ResourceNotFoundException {
        return productRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Producto no encontrado"));
    }

    public Product save(ProductDto dto) throws AttributeException {
        if(productRepository.existsByNombre(dto.getNombre()))
            throw new AttributeException("Nombre ya existe");
        int id = autoIncrement();
        Product product = new Product(id, dto.getNombre(), dto.getPrecio());
        return productRepository.save(product);
    }

    public Product update(int id, ProductDto dto) throws ResourceNotFoundException, AttributeException {
        Product product = productRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Producto no encontrado"));
        if(productRepository.existsByNombre(dto.getNombre()) && productRepository.findByNombre(dto.getNombre()).get().getId() != id)
            throw new AttributeException("Nombre ya existe");
        product.setNombre(dto.getNombre());
        product.setPrecio(dto.getPrecio());
        return productRepository.save(product);
    }

    public Product delete(int id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Producto no encontrado"));
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
