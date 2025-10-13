package az.ingress.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "traveller")
@AllArgsConstructor
public class Traveller {

    @Id
    Long id;

    String firstName;

    String lastName;

    String email;

    @ManyToMany(mappedBy = "trevelers")
    List<Tour> tours;
}
