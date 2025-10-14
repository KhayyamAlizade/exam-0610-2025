package az.ingress.controller.exam;


import az.ingress.model.request.CreateTourRequest;
import az.ingress.service.abs.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/tours")
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
