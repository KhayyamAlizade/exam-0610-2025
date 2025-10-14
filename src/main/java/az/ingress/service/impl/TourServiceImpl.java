package az.ingress.service.impl;

import az.ingress.entity.Destination;
import az.ingress.entity.Guide;
import az.ingress.entity.Tour;
import az.ingress.mapper.DestinationMapper;
import az.ingress.model.request.CreateTourRequest;
import az.ingress.model.response.TourResponse;
import az.ingress.repository.TourRepository;
import az.ingress.service.abs.GuideService;
import az.ingress.service.abs.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final GuideService guideService;

    @Override
    public void save(CreateTourRequest tour) {
        List<Guide> guides = tour.getGuides()
                .stream()
                .map(guide -> guideService.getGuideById(guide.getId()))
                .toList();

        guides.stream().filter(guide -> guide.getTours().stream().anyMatch(tour1 -> isGuideFree(tour,tour1))).;


                Tour tourEntity = Tour.builder().name(tour.getName()).
                        endDate(tour.getEndDate()).
                        price(tour.getPrice()).
                        guides(guides).
                        startDate(tour.getStartDate())
                        .build();

        List<Destination> destinations = tour.getDestination()
                .stream()
                .map(destination -> DestinationMapper.INSTANCE.createRequestToDestinationEnt(destination, tourEntity))
                .toList();
        tourEntity.setDestination(destinations);

        tourRepository.save(tourEntity);
    }

    @Override
    public TourResponse getTourById(Long id) {
        return null;
    }

    public boolean isGuideFree(CreateTourRequest guideTour, Tour newTour) {
        if (guideTour.getGuides() != null && newTour.getGuides() != null) {
            Date startDate = guideTour.getStartDate();
            Date endDate = guideTour.getEndDate();
            if ((newTour.getStartDate().before(startDate) && newTour.getEndDate().after(startDate)) ||
                    (newTour.getStartDate().after(startDate) && newTour.getEndDate().after(endDate)) ||
                    (newTour.getStartDate().after(startDate) && newTour.getEndDate().before(endDate)) ||
                    (newTour.getStartDate().after(startDate) && newTour.getEndDate().before(startDate) && newTour.getEndDate().after(endDate))) {
                return false;
            }

        }
        return true;
    }
}
