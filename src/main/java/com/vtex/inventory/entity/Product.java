package com.vtex.inventory.entity;

import com.vtex.inventory.service.dtos.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter

@Entity
public class Product{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    public Product(ProductDTO productDTO){
        this.id = productDTO.getId();
        this.name =  productDTO.getName();
        this.code = productDTO.getCode();
    }

    public Product(){}
}
