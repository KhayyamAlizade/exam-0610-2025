package az.ingress.service.impl;

import az.ingress.entity.Tour;
import az.ingress.model.request.CreateTourRequest;
import az.ingress.model.response.TourResponse;
import az.ingress.service.abs.TourService;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements TourService {
    @Override
    public void save(CreateTourRequest tour) {

//        Tour.builder().name(tour.getName()).
//                endDate(tour.getEndDate()).
//                price(tour.getPrice()).
//                guides(tour.getGuides()).
//                destination(tour.getDestination())
//                .startDate(tour.getStartDate())
//                .build();

    }

    @Override
    public TourResponse getTourById(Long id) {
        return null;
    }
}
