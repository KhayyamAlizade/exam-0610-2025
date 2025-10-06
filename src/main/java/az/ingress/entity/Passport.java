package az.ingress.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Passport {


    @Id
    Long id;

    String passportNumber;

    Date issueDate;

    Date exporyDate;

    String country;

    @OneToOne()
    Guide guideId;

}
