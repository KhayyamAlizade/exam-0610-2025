package az.ingress.controller.exam;

import az.ingress.model.request.CreateTravelerRequest;
import az.ingress.service.abs.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/travellers")
public class TravelerController {

    private final TravelerService travelerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTraveller(@RequestParam Long id,@RequestBody CreateTravelerRequest request){



    }

}
