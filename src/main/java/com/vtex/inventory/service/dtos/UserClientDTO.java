package com.vtex.inventory.service.dtos;

import com.vtex.inventory.entity.UserClient;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter

public class UserClientDTO {
    private Long id;
    private String name;
    private String number;
    private String cpf;

    public UserClientDTO(UserClient userClient){
        this.id = userClient.getId();
        this.name = userClient.getName();
        this.number = userClient.getNumber();
        this.cpf = userClient.getCpf();
    }

    public UserClientDTO(String name, String number, String cpf){
        this.name = name;
        this.number = number;
        this.cpf = cpf;
    }

    public UserClientDTO(Long id, String name, String number, String cpf){
        this.id = id;
        this.name = name;
        this.number = number;
        this.cpf = cpf;
    }

    public UserClientDTO(){}

    public List<UserClientDTO> userDTOList(List<UserClient> userClients){
        List<UserClientDTO> list = new LinkedList<>();
        for (UserClient userClient : userClients){
            list.add(new UserClientDTO(userClient));
        }
        return list;
    }

}
