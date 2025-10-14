package az.ingress.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TourResponse {
    Long Id;
    String Name;
    String Description;
}
