package com.vtex.inventory.service;

import com.vtex.inventory.entity.UserClient;
import com.vtex.inventory.repository.UserClientRepository;
import com.vtex.inventory.service.dtos.UserClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserClientRepository repository;

    public ResponseEntity<UserClientDTO> insertUser(UserClientDTO userClientDTO) {
        UserClient userClient = new UserClient(userClientDTO);
        userClient = repository.save(userClient);
        if (userClient == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        else {
            return ResponseEntity.ok().body(new UserClientDTO(userClient));
        }
    }

    public ResponseEntity<List<UserClientDTO>> getAllUsers(){
        UserClientDTO userClientDto = new UserClientDTO();
        List<UserClientDTO> listUserClientDto = userClientDto.userDTOList(repository.findAll());
        return ResponseEntity.ok().body(listUserClientDto);
    }

    public ResponseEntity<?> getUserById(Long id){
        UserClient userClient = repository.findById(id).get();
        if (userClient == null)
            return ResponseEntity.ok().body("User not found.");
        else {
            return ResponseEntity.ok().body(new UserClientDTO(userClient));
        }
    }
}
