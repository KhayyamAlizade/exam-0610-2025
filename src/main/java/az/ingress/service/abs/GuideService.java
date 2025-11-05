package az.ingress.service.abs;

import az.ingress.entity.Guide;
import az.ingress.model.request.CreateGuideRequest;
import az.ingress.model.response.GuideResponse;

public interface GuideService {

    void save(CreateGuideRequest request);

     Guide getGuideById(Long id);

     GuideResponse getGuideResponseById(Long id);

    public void createGuide(CreateGuideRequest request);

}
