package com.vtex.inventory.web.rest;

import com.vtex.inventory.service.ProductService;
import com.vtex.inventory.service.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductResource {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> insertProduct(@RequestBody ProductDTO  productDTO){
        return productService.insertProduct(productDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable  Long id){
        return productService.getProductById(id);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateInventory(@PathVariable  Long id, @RequestBody ProductDTO  productDTO){
        return productService.updateInventory(id, productDTO);
    }

    @PutMapping("/sale/{id}/{qtd}")
    public ResponseEntity<?> saleProduct(@PathVariable  Long id, @PathVariable  Integer qtd){
        if(qtd == null){
            qtd = 1;
        }
        return productService.saleProduct(id, qtd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable  Long id){
        return productService.deleteProductById(id);
    }
}
