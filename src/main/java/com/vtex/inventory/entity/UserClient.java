package com.vtex.inventory.entity;

import com.vtex.inventory.service.dtos.UserClientDTO;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter

@Entity
public class UserClient{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String number;

    public UserClient(UserClientDTO userClientDTO){
        this.name = userClientDTO.getName();
        this.number =  userClientDTO.getNumber();
        this.cpf = userClientDTO.getCpf();
    }

    public UserClient(){}
}
