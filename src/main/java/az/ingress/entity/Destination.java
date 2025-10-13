package az.ingress.entity;


import lombok.*;


import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "destination")
@AllArgsConstructor
public class Destination {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String location;

    String description;

    Date visitDate;

    @ManyToOne
    @JoinColumn(name = "tourId")
    Tour tour;
}
