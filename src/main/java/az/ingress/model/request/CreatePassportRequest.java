package az.ingress.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePassportRequest {

    String passportNumber;

    Date issueDate;

    Date exporyDate;

    String country;

}
