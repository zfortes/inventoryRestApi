package com.vtex.inventory.service;

import com.vtex.inventory.entity.Product;
import com.vtex.inventory.repository.ProductRepository;
import com.vtex.inventory.service.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ResponseEntity<?> insertProduct(ProductDTO productDTO){
        Product product = new Product(productDTO);
        product = repository.save(product);
        if (product == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        else {
            return ResponseEntity.ok().body(new ProductDTO(product));
        }
    }

    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        ProductDTO productDTO = new ProductDTO();
        List<ProductDTO> productDTOS = ProductDTO.productDtoList(repository.findAll());
        return ResponseEntity.ok().body(productDTOS);
    }

    public ResponseEntity<?> getProductById(Long id){
        Product product = repository.findById(id).get();
        if (product == null)
            return ResponseEntity.ok().body("Product not found.");
        else {
            return ResponseEntity.ok().body(new ProductDTO(product));
        }
    }
}
