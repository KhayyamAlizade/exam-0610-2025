package az.ingress.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateGuideRequest {
    Long id;
    String name;

    String email;

    String phoneNumber;

    CreatePassportRequest passportRequest;


}
