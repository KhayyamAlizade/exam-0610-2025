package az.ingress.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String firstName;

    String lastName;

    String email;

    @ManyToMany(mappedBy = "travelers")
    List<Tour> tours;
}
