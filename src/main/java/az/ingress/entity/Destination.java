package az.ingress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Destination {

    @Id
    Long id;

    String location;

    String description;

    Date visitDate;

    @ManyToOne()
    Tour tourId;

}
