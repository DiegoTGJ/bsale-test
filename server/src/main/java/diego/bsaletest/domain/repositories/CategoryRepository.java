package diego.bsaletest.domain.repositories;

import diego.bsaletest.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Diego T. 31-08-2022
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
