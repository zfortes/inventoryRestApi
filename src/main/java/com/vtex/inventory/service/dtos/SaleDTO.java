package com.vtex.inventory.service.dtos;

import com.vtex.inventory.entity.Product;
import com.vtex.inventory.entity.Sale;
import com.vtex.inventory.entity.UserClient;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter

public class SaleDTO {
    private Long id;

    private List<Long> products;

    private Long userClient;

//    public static  List<SaleDTO> saleDtoList(List<Sale> sales){
//        List<SaleDTO> list = new LinkedList<>();
//        for (Sale sale : sales){
//            list.add(new SaleDTO(sale));
//        }
//        return list;
//    }

    public SaleDTO(Long id, List<Long> products, Long userClient) {
        this.id = id;
        this.products = products;
        this.userClient = userClient;
    }

    public SaleDTO(){}
}
