package diego.bsaletest.presentation.controllers;

import diego.bsaletest.domain.services.CategoryService;
import diego.bsaletest.infrastructure.config.SpringFoxConfig;
import diego.bsaletest.presentation.model.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Diego T. 31-08-2022
 */
@Api(tags = SpringFoxConfig.CATEGORY_TAG)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(summary = "Obtener las categorias de los productos disponibles")
    @ApiResponse(code = 200,message = "Lista con las categorias disponibles")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> list = categoryService.listCategories();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
