package az.ingress.model.request;

import az.ingress.entity.Tour;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class CreateTravelerRequest {

    String firstName;

    String lastName;

    String email;

    @ManyToMany(mappedBy = "tours")
    List<Tour> tours;
}
