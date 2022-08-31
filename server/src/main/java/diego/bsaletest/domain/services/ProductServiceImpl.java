package diego.bsaletest.domain.services;

import diego.bsaletest.domain.model.Product;
import diego.bsaletest.domain.repositories.ProductRepository;
import diego.bsaletest.presentation.mappers.ProductMapper;
import diego.bsaletest.presentation.model.ProductDto;
import diego.bsaletest.presentation.model.ProductPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ProductPagedList listProducts(PageRequest pageRequest, Integer category, String nameSearch) {
        Page<Product> productPage;

        if(nameSearch.trim().isEmpty()){
            if(category == null) {
                productPage = productRepository.findAll(pageRequest);
            }else{
                productPage = productRepository.findAllByCategory_Id(category,pageRequest);
            }
        }else{
            productPage = productRepository.findAllByNameContainsIgnoreCase(nameSearch,pageRequest);
        }
         return new ProductPagedList(productPage
                 .stream()
                 .map(productMapper::toDto)
                 .collect(Collectors.toList()),
                 PageRequest.of(productPage.getPageable().getPageNumber(),
                 productPage.getPageable().getPageSize()),
                 productPage.getTotalElements());
    }
}
