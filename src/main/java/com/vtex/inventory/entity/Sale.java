package com.vtex.inventory.entity;

import com.vtex.inventory.service.dtos.SaleDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter

@Entity
public class Sale{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Product> products;

    @OneToOne
    private UserClient userClient;

    public Sale(List<Product> products, UserClient user){
        this.id = id;
        this.products = products;
        this.userClient = user;
    }

//    public Sale(SaleDTO sale){
//        this.products = sale.getProducts();
//        this.userClient = sale.getUserClient();
//    }

    public Sale(){}
}
