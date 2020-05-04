package com.vtex.inventory.web.rest;

import com.vtex.inventory.service.ConselhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conselho")
public class ConselhoResource {
    @Autowired
    private ConselhoService conselhoService;

    @PostMapping
    ResponseEntity<?> conselhoSms(){
        return conselhoService.conselhoSms();
    }
}