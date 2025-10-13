package az.ingress.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "passport")
@AllArgsConstructor
public class Passport {
    @Id
    Long id;

    String passportNumber;
    Date issueDate;
    Date expiryDate;
    String country;

    @OneToOne(mappedBy = "passport")
    Guide guide;
}
