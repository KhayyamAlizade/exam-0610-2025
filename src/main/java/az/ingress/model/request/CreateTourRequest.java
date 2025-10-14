package az.ingress.model.request;

import az.ingress.entity.Destination;
import az.ingress.entity.Guide;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTourRequest {
    Long id;

    String name;

    String description;

    BigDecimal price;

    Date startDate;

    Date endDate;

    List<CreateGuideRequest>  guides;

    List<CreateDestinationRequest> destination;

}
