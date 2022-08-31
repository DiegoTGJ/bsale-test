package diego.bsaletest.presentation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Diego T. 31-08-2022
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
    private Integer id;
    private String name;
    private String urlImage;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Float price;
    private int discount;

    private CategoryDto category;
}
