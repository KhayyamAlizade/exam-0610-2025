package az.ingress.controller.exam;


import az.ingress.model.request.CreateTourRequest;
import az.ingress.model.response.TourResponse;
import az.ingress.service.abs.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

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
    @PutMapping("add-guide")
    @ResponseStatus(HttpStatus.OK)
    public void addGuideToTour(@RequestBody CreateTourRequest tour) {
        service.addTourGuide(tour);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public TourResponse getTourDestionationsById(@RequestParam("id") Long id) {
        return service.getTour(id);

    }




}
