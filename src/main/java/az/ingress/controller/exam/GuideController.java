package az.ingress.controller.exam;

import az.ingress.model.request.CreateGuideRequest;
import az.ingress.service.abs.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/guides")
public class GuideController {

    private final GuideService guideService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGuide(@RequestBody CreateGuideRequest guide) {
        guideService.save(guide);

    }
}
