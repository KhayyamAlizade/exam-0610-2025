package az.ingress.entity;


import lombok.*;


import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "guide")
@AllArgsConstructor
public class Guide {

    @Id
    Long id;

    String name;

    String email;


    String phoneNumber;

    @ManyToMany(mappedBy = "guides")
    List<Tour> tours ;

    @OneToOne(cascade = {MERGE,PERSIST}, fetch =LAZY)
    @JoinColumn(name="passport_id")
    Passport passport;
}
