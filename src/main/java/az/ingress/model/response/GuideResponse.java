package az.ingress.model.response;

import az.ingress.entity.Tour;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class GuideResponse {


    Long id;

    String name;

    String email;


    String phoneNumber;


    List<Tour> tours ;
}
