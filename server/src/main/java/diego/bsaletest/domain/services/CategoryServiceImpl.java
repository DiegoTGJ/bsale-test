package diego.bsaletest.domain.services;

import diego.bsaletest.domain.model.Category;
import diego.bsaletest.domain.repositories.CategoryRepository;
import diego.bsaletest.presentation.mappers.CategoryMapper;
import diego.bsaletest.presentation.model.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Diego T. 31-08-2022
 */
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public List<CategoryDto> listCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toList());
    }
}
