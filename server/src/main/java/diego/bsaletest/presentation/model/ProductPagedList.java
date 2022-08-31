package diego.bsaletest.presentation.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Diego T. 31-08-2022
 */
public class ProductPagedList extends PageImpl<ProductDto> implements Serializable {
    static final long serialVersionUID = -3209815236862135220L;
    public ProductPagedList(List<ProductDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
    public ProductPagedList(List<ProductDto> content) {
        super(content);
    }
}
