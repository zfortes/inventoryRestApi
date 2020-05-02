package com.vtex.inventory.service;

import com.vtex.inventory.entity.Product;
import com.vtex.inventory.entity.Sale;
import com.vtex.inventory.entity.UserClient;
import com.vtex.inventory.repository.ProductRepository;
import com.vtex.inventory.repository.SaleRepository;
import com.vtex.inventory.repository.UserClientRepository;
import com.vtex.inventory.service.dtos.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserClientRepository userClientRepository;

    public ResponseEntity<SaleDTO> insertSale(SaleDTO saleDTO) {
        List<Product> products = getProductsWithIds(saleDTO.getProducts());
        UserClient userClient = userClientRepository.findById(saleDTO.getUserClient()).get();
        Sale sale = new Sale(products, userClient);
        sale = repository.save(sale);
        if (sale == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        else {
            List<Long> productsDto = getProductsIds(sale.getProducts());
            SaleDTO saleDTO1 = new SaleDTO(sale.getId(), productsDto, sale.getUserClient().getId());
            return ResponseEntity.ok().body(saleDTO1);
        }
    }

//    public ResponseEntity<List<SaleDTO>> getAllSales(){
//        List<SaleDTO> listSaleDTO = SaleDTO.saleDtoList(repository.findAll());
//        return ResponseEntity.ok().body(listSaleDTO);
//    }

    public ResponseEntity<?> getSaleById(Long id){
        Sale sale = repository.findById(id).get();
        if (sale == null)
            return ResponseEntity.ok().body("Sale not found.");
        else {
            List<Long> productsDto = getProductsIds(sale.getProducts());
            SaleDTO saleDTO1 = new SaleDTO(sale.getId(), productsDto, sale.getUserClient().getId());
            return ResponseEntity.ok().body(saleDTO1);
        }
    }

    //TODO reimplementar no repository
    private List<Product> getProductsWithIds(List<Long> ids){
        List<Product> products = new LinkedList<>();
        for (Long id : ids){
            products.add(productRepository.findById(id).get());
        }
        return products;
    }

    private List<Long> getProductsIds(List<Product>  list){
        List<Long> products = new LinkedList<>();
        for (Product p : list){
            products.add(p.getId());
        }
        return products;
    }
}
