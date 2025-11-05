package az.ingress.service.impl;

import az.ingress.controller.exam.TourController;
import az.ingress.model.request.CreateDestinationRequest;
import az.ingress.model.response.TourResponse;
import az.ingress.service.abs.DestinationService;
import az.ingress.service.abs.TourService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {
 private final TourService tourService;

    public DestinationServiceImpl(TourService tourService) {
        this.tourService = tourService;
    }

    @Override
    public void save(CreateDestinationRequest request) {
//        CreateDestinationRequest destinationRequest= CreateDestinationRequest.builder().tour(request.getTour())
//                                                        .description(request.getDescription())
//                                                        .visitDate(request.getVisitDate())
//                                                        .location(request.getLocation())
//                                                        .build();

//       TourResponse tourResponse= Optional.ofNullable(tourService.getTourById(request.getTourID())).get();

    }
}
