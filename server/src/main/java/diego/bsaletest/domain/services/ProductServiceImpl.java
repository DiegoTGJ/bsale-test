package diego.bsaletest.domain.services;

import diego.bsaletest.domain.model.Product;
import diego.bsaletest.domain.repositories.ProductRepository;
import diego.bsaletest.presentation.mappers.ProductMapper;
import diego.bsaletest.presentation.model.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Diego T. 31-08-2022
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public List<ProductDto> listProducts() {
        return productRepository.findAll().stream().map(productMapper::toDto).collect(Collectors.toList());
    }
}
