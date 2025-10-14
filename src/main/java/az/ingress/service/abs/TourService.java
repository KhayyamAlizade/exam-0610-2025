package az.ingress.service.abs;

import az.ingress.entity.Tour;
import az.ingress.model.request.CreateTourRequest;
import az.ingress.model.response.TourResponse;

public interface TourService {
   void save(CreateTourRequest tour);



   void addTourGuide(CreateTourRequest request);


   TourResponse getTourDestination(Long id);
}
