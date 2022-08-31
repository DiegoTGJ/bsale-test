package diego.bsaletest.domain.services;


import diego.bsaletest.presentation.model.ProductPagedList;
import org.springframework.data.domain.PageRequest;
/**
 * Created by Diego T. 31-08-2022
 */
public interface ProductService {
    ProductPagedList listProducts(PageRequest pageRequest, Integer category, String nameSearch);
}
