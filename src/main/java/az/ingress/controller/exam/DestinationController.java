package az.ingress.controller.exam;

import az.ingress.model.request.CreateDestinationRequest;
import az.ingress.service.abs.DestinationService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/destinations")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody CreateDestinationRequest destination) {
        destinationService.save(destination);
    }


}
