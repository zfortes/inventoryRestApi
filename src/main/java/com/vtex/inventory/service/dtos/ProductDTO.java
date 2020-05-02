package com.vtex.inventory.service.dtos;

import com.vtex.inventory.entity.Product;
import com.vtex.inventory.entity.UserClient;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter


public class ProductDTO {
    private Long id;
    private String name;
    private String code;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.code = product.getCode();
    }

    public ProductDTO(){}

    public static  List<ProductDTO> productDtoList(List<Product> products){
        List<ProductDTO> list = new LinkedList<>();
        for (Product product : products){
            list.add(new ProductDTO(product));
        }
        return list;
    }
}
