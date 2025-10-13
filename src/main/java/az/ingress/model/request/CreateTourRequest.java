package az.ingress.model.request;

import az.ingress.entity.Destination;
import az.ingress.entity.Guide;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
public class CreateTourRequest {

    String name;

    String description;

    BigDecimal price;

    Date startDate;

    Date endDate;

    List<CreateGuideRequest>  guides;

    List<CreateDestinationRequest> destination;

}
