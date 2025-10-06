package az.ingress.service.abs;

import az.ingress.model.request.CreatePassportRequest;

public interface PassportService {

    void save(CreatePassportRequest request);
}
