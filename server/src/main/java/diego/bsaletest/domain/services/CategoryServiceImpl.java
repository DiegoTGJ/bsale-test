package diego.bsaletest.domain.services;

import diego.bsaletest.domain.model.Category;
import diego.bsaletest.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Diego T. 31-08-2022
 */
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }
}
