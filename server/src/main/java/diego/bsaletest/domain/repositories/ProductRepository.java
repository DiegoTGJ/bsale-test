package diego.bsaletest.domain.repositories;

import diego.bsaletest.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Diego T. 31-08-2022
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
