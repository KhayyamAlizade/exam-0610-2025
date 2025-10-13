package az.ingress.entity;


//import jakarta.persistence.*;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;


@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "tour")
@AllArgsConstructor
public class Tour {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String description;

    BigDecimal price;

    Date startDate;

    Date endDate;



    @OneToMany(mappedBy = "tour", fetch = LAZY,cascade = {MERGE,PERSIST})
    List<Destination> destination;

    @ManyToMany
    @JoinTable(name = "tour_guides",joinColumns = @JoinColumn(name = "id"))
    List<Guide>  guides;

    @ManyToMany
    @JoinTable(name = "tour_traveller",joinColumns = @JoinColumn(name = "id"))
    List<Traveller> travelers;


}
