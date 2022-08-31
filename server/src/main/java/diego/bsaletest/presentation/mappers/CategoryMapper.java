package diego.bsaletest.presentation.mappers;

import diego.bsaletest.domain.model.Category;
import diego.bsaletest.presentation.model.CategoryDto;
import org.mapstruct.Mapper;

/**
 * Created by Diego T. 31-08-2022
 */
@Mapper
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toDomain(CategoryDto categoryDto);
}
