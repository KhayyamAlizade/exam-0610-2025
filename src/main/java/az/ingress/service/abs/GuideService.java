package az.ingress.service.abs;

import az.ingress.model.request.CreateGuideRequest;

public interface GuideService {

    void save(CreateGuideRequest request);
}
