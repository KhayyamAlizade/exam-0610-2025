package az.ingress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Guide {

    @Id
    Long id;

    String name;

    String email;


    String phoneNumber;


    @ManyToMany(mappedBy = "guides")
    List<Tour> tours ;

}
