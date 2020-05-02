package com.vtex.inventory.web.rest;

import com.vtex.inventory.service.ProductService;
import com.vtex.inventory.service.SaleService;
import com.vtex.inventory.service.dtos.ProductDTO;
import com.vtex.inventory.service.dtos.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleResource {
    @Autowired
    SaleService saleService;

    @PostMapping
    public ResponseEntity<?> insertSale(@RequestBody SaleDTO saleDTO){
        return saleService.insertSale(saleDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSaleById(@PathVariable Long id){
        return saleService.getSaleById(id);
    }

//    @GetMapping
//    public ResponseEntity<?> getAllSales(){
//        return saleService.getAllSales();
//    }
}
