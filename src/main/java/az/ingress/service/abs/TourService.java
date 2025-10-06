package az.ingress.service.abs;

import az.ingress.model.request.CreateTourRequest;
import az.ingress.model.response.TourResponse;

public interface TourService {
   void save(CreateTourRequest tour);

   TourResponse getTourById(Long id);


}
