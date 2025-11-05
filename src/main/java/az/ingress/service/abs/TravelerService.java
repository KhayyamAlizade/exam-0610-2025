package az.ingress.service.abs;

import az.ingress.model.request.CreateTravelerRequest;

public interface TravelerService {

    void save(CreateTravelerRequest request);
}
