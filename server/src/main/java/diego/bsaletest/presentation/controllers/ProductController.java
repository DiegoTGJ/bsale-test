package diego.bsaletest.presentation.controllers;

import diego.bsaletest.domain.model.Product;
import diego.bsaletest.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Diego T. 31-08-2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/products")
public class ProductController {


    private final ProductRepository productRepository;
    @CrossOrigin( origins = {})
    @GetMapping()
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> list = productRepository.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}