package az.ingress.service.abs;

import az.ingress.model.request.CreateDestinationRequest;

public interface DestinationService {
    void save(CreateDestinationRequest request);
}
