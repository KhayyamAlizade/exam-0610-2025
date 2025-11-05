package az.ingress.mapper;

import az.ingress.entity.Destination;
import az.ingress.entity.Tour;
import az.ingress.model.request.CreateDestinationRequest;

public enum DestinationMapper {

    INSTANCE;

    DestinationMapper() {
    }

    public Destination createRequestToDestinationEnt(CreateDestinationRequest destination,Tour tour) {
        return Destination.builder().
                description(destination.getDescription()).
                visitDate(destination.getVisitDate()).
                location(destination.getLocation()).
                tour(tour).
                id(destination.getTourID()).
                build();

    }
}
