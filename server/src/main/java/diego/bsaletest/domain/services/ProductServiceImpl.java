package diego.bsaletest.domain.services;

import diego.bsaletest.domain.model.Product;
import diego.bsaletest.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Diego T. 31-08-2022
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
}
