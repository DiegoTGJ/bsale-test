package diego.bsaletest.presentation.mappers;

import diego.bsaletest.domain.model.Product;
import diego.bsaletest.presentation.model.ProductDto;
import org.mapstruct.Mapper;

/**
 * Created by Diego T. 31-08-2022
 */
@Mapper(uses = {CategoryMapper.class})
public interface ProductMapper {
    ProductDto toDto(Product beer);
    Product toDomain(ProductDto beerDto);
}
