package az.ingress.mapper;

import az.ingress.entity.Guide;
import az.ingress.entity.Tour;
import az.ingress.model.request.CreateTourRequest;
import az.ingress.model.response.TourResponse;

import java.util.List;

public enum TourMapper {

    INSTANCE;

    TourMapper() {
    }

    public TourResponse tourEntityToResponse(Tour tour) {
        return TourResponse.builder().
                Id(tour.getId()).
                Name(tour.getName()).
                Description(tour.getDescription()).
                build();

    }
    public Tour createRequestToTourEntity(CreateTourRequest request, List<Guide> guide){
        return Tour.builder().
                name(request.getName()).
                price(request.getPrice()).
                endDate(request.getEndDate()).
                startDate(request.getStartDate()).
                description(request.getDescription()).
                guides(guide).
                build();
    }
}
