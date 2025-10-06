package az.ingress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Tour {

    @Id
    Long id;

    String name;

    String description;

    BigDecimal price;

    Date startDate;

    Date endDate;

    @OneToMany(mappedBy ="tourId" )
    List<Destination> destination;

    @ManyToMany(mappedBy = "tours")
    List<Guide> guides;


}
