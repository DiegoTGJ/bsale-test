package diego.bsaletest.domain.repositories;

import diego.bsaletest.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Diego T. 31-08-2022
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByCategory_Id(Integer category, PageRequest pageRequest);
    Page<Product> findAllByNameContainsIgnoreCase(String name,PageRequest pageRequest);
}

