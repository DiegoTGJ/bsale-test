package diego.bsaletest.presentation.controllers;

import diego.bsaletest.domain.model.Category;
import diego.bsaletest.domain.services.CategoryService;
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
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @CrossOrigin( origins = {})
    @GetMapping()
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> list = categoryService.listCategories();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
