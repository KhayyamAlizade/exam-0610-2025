package az.ingress.controller.exam;


import az.ingress.entity.Tour;
import az.ingress.model.request.CreateTourRequest;
import az.ingress.repository.TourRepository;
import az.ingress.service.abs.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1/tours")
public class TourController {

    private final TourService service;

    public TourController(TourService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTour(@RequestBody CreateTourRequest tour) {
        service.save(tour);

    }




}
