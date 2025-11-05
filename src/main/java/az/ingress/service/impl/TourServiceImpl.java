package az.ingress.service.impl;

import az.ingress.entity.Destination;
import az.ingress.entity.Guide;
import az.ingress.entity.Tour;
import az.ingress.mapper.DestinationMapper;
import az.ingress.mapper.TourMapper;
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
        List<Guide> andGetFreeGuidesOfTour = findAndGetFreeGuidesOfTour(tour);

        Tour tourEntity = Tour.builder().name(tour.getName()).
                        endDate(tour.getEndDate()).
                        price(tour.getPrice()).
                        guides(andGetFreeGuidesOfTour).
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
    public void addTourGuide(CreateTourRequest request) {
        Tour tourById = getTourById(request.getId());
        List<Guide> guides = findAndGetFreeGuidesOfTour(request);
        tourById.setGuides(guides);
        tourRepository.save(tourById);

    }

    @Override
    public TourResponse getTourDestination(Long id) {
        Tour tour=tourRepository.findTourDestinationById(id);
       return TourMapper.INSTANCE.tourEntityToResponse(tour);
    }

    public Tour getTourById(Long id) {
        return  tourRepository.findById(id).get();
    }


    public List<Guide> findAndGetFreeGuidesOfTour(CreateTourRequest request) {
        List<Guide> guides = request.getGuides()
                .stream()
                .map(guide -> guideService.getGuideById(guide.getId()))
                .toList();

        guides.stream()
                .filter(guide -> guide.getTours().stream()
                        .anyMatch(existingTour -> !isGuideFree(request, existingTour)))
                .findAny()
                .ifPresent(guide -> {
                    throw new RuntimeException("Guide " + guide.getName() + " is busy");
                });
        return guides;
    };

    public boolean isGuideFree(CreateTourRequest guideTour, Tour newTour) {
        if (guideTour == null || newTour == null) {
            return true;
        }
        Date startDate = guideTour.getStartDate();
        Date endDate = guideTour.getEndDate();

        return newTour.getEndDate().before(startDate) || newTour.getStartDate().after(endDate);

        }
    }

