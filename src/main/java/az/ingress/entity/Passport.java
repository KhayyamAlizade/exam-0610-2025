package az.ingress.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "passport")
@AllArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String passportNumber;
    Date issueDate;
    Date expiryDate;
    String country;

    @OneToOne(mappedBy = "passport")
    Guide guide;
}
