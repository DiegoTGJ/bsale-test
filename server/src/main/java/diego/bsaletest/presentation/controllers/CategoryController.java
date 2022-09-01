package diego.bsaletest.presentation.controllers;

import diego.bsaletest.domain.services.CategoryService;
import diego.bsaletest.presentation.model.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Diego T. 31-08-2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> list = categoryService.listCategories();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
