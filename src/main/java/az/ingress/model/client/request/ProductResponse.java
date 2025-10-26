package az.ingress.model.client.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponse {
    public Long id;
    public String name;
    public String description;
    public BigDecimal price;
    public long count;
}
