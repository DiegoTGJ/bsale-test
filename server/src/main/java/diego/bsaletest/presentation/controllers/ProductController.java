package diego.bsaletest.presentation.controllers;

import diego.bsaletest.domain.model.Product;
import diego.bsaletest.domain.services.ProductService;
import diego.bsaletest.presentation.model.ProductDto;
import diego.bsaletest.presentation.model.ProductPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Diego T. 31-08-2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 12;
    private final ProductService productService;
    @CrossOrigin( origins = {})
    @GetMapping()
    public ResponseEntity<ProductPagedList> getProducts(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                        @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                        @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                                        @RequestParam(value = "nameSearch", required = false) String nameSearch){
        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        if(nameSearch == null) nameSearch = "";
        ProductPagedList list = productService.listProducts(PageRequest.of(pageNumber,pageSize),categoryId,nameSearch);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
