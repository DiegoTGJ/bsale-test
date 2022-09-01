package diego.bsaletest.presentation.controllers;

import diego.bsaletest.domain.services.ProductService;
import diego.bsaletest.infrastructure.config.SpringFoxConfig;
import diego.bsaletest.presentation.model.ProductPagedList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Diego T. 31-08-2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/products")
@Api(tags = SpringFoxConfig.PRODUCTS_TAG)
public class ProductController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 12;
    private static final String PAGE_NUMBER_VALUE = "Numero de pagina de los productos a obtener, parten de 0";
    private static final String PAGE_SIZE_VALUE = "Cantidad de productos a obtener, por defecto es 12, maximo 50";
    private static final String CATEGORY_ID_VALUE = "Filtra por id de categoria";
    private static final String NAME_SEARCH_VALUE = "Filtra por nombre de producto, ignora categoria";

    private final ProductService productService;

    @Operation(summary = "Obtener los productos disponibles de la tienda")
    @ApiResponse(code = 200,message = "Objeto con datos de la pagina y lista de productos en el atributo content.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductPagedList> getProducts(@RequestParam(value = "pageNumber", required = false)
                                                        @ApiParam(value = PAGE_NUMBER_VALUE,example = "1") Integer pageNumber,
                                                        @RequestParam(value = "pageSize", required = false)
                                                        @ApiParam(value = PAGE_SIZE_VALUE, example = "12") Integer pageSize,
                                                        @RequestParam(value = "categoryId", required = false)
                                                        @ApiParam(value = CATEGORY_ID_VALUE, example = "2") Integer categoryId,
                                                        @RequestParam(value = "nameSearch", required = false)
                                                        @ApiParam(value = NAME_SEARCH_VALUE, example = "papas")String nameSearch){
        if (pageNumber == null || pageNumber < 0 ){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1 || pageSize > 50) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        if(nameSearch == null) nameSearch = "";
        ProductPagedList list = productService.listProducts(PageRequest.of(pageNumber,pageSize),categoryId,nameSearch);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
