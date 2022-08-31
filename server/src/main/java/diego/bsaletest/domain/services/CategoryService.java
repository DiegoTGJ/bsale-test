package diego.bsaletest.domain.services;

import diego.bsaletest.domain.model.Category;
import diego.bsaletest.presentation.model.CategoryDto;

import java.util.List;

/**
 * Created by Diego T. 31-08-2022
 */
public interface CategoryService {
    List<CategoryDto> listCategories();
}
