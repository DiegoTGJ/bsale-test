package diego.bsaletest.domain.services;

import diego.bsaletest.domain.model.Product;
import diego.bsaletest.presentation.model.ProductDto;

import java.util.List;

/**
 * Created by Diego T. 31-08-2022
 */
public interface ProductService {
    List<ProductDto> listProducts();
}
