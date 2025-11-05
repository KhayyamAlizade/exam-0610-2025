package az.ingress.model.request;

import az.ingress.entity.Tour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTravelerRequest {

    String firstName;

    String lastName;

    String email;


    List<Tour> tours;
}
