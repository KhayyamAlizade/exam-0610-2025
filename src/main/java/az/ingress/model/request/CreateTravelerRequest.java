package az.ingress.model.request;

import az.ingress.entity.Tour;


import java.util.List;

public class CreateTravelerRequest {

    String firstName;

    String lastName;

    String email;


    List<Tour> tours;
}
