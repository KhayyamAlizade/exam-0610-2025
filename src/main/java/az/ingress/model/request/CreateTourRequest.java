package az.ingress.model.request;

import az.ingress.entity.Destination;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreateTourRequest {

    String name;

    String description;

    BigDecimal price;

    Date startDate;

    Date endDate;

    List<Destination> destination;

}
