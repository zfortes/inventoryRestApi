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
    private String nomeFornecedor;
    private Double peso;
    private Double preco;
    private Integer emEstoque;
    private Integer minEstoque;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.code = product.getCode();
        this.nomeFornecedor = product.getNomeFornecedor();
        this.peso = product.getPeso();
        this.preco = product.getPreco();
        this.emEstoque = product.getEmEstoque();
        this.minEstoque = product.getMinEstoque();
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
