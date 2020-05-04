package com.vtex.inventory.service;

import com.vtex.inventory.entity.Product;
import com.vtex.inventory.repository.ProductRepository;
import com.vtex.inventory.service.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public static final String ACCOUNT_SID =
            "AC93e5314365b9ed7546dbca31c612c827";
    public static final String AUTH_TOKEN =
            "2a7402aa7927a35d75c1251928eb189d";

    public ResponseEntity<?> insertProduct(ProductDTO productDTO){
        Product product = new Product(productDTO);
        product = repository.save(product);
        if (product == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        else {
            return ResponseEntity.ok().body(new ProductDTO(product));
        }
    }

    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        ProductDTO productDTO = new ProductDTO();
        List<ProductDTO> productDTOS = ProductDTO.productDtoList(repository.findAll());
        return ResponseEntity.ok().body(productDTOS);
    }

    public ResponseEntity<?> getProductById(Long id){
        Product product = repository.findById(id).get();
        if (product == null)
            return ResponseEntity.ok().body("Product not found.");
        else {
            return ResponseEntity.ok().body(new ProductDTO(product));
        }
    }

    public ResponseEntity<?> updateInventory(Long id, ProductDTO productDTO){
        Product product_new = new Product(productDTO);
        Product product = repository.findById(id).get();
        if (product == null)
            return ResponseEntity.ok().body("Product not found.");
        else {
            product.setEmEstoque(product_new.getEmEstoque());
            if(product_new.getMinEstoque() != null){
                 product.setMinEstoque(product_new.getMinEstoque());
            }
            product = repository.save(product);
            
            return ResponseEntity.ok().body(new ProductDTO(product));
        }
    }

    public ResponseEntity<?> saleProduct(Long id, Integer qtd){
        Product product = repository.findById(id).get();
        if (product == null)
            return ResponseEntity.ok().body("Product not found.");
        else {
            product.setEmEstoque(product.getEmEstoque() - qtd);
            product = repository.save(product);

            if(product.getEmEstoque() <= product.getMinEstoque()){
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

                Message message = Message
                        .creator(new PhoneNumber("+5563992448654"), // to
                                new PhoneNumber("+12057518821"), // from
                                "Atenção!!! A quantidade em estoque do produto " + product.getName() + " está abaixo da mínima cadastrada. Lembre-se de de comprar mais para não perder vendas :)")
                        .create();
            }

            return ResponseEntity.ok().body(new ProductDTO(product));
        }
    }

     public ResponseEntity<?> deleteProductById(Long id){
        Product product = repository.findById(id).get();
        if (product == null)
            return ResponseEntity.ok().body("Product not found.");
        else {
            repository.deleteById(id);
            return ResponseEntity.ok().body("Delete Success.");
        }
     }
}
