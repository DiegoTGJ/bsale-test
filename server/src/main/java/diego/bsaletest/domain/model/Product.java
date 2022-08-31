package diego.bsaletest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Diego T. 30-08-2022
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    private Integer id;

    private String name;
    @Column(name = "url_image")
    private String urlImage;
    private Float price;
    private int discount;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

}
