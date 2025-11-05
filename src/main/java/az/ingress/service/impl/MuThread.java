package az.ingress.service.impl;

import az.ingress.model.request.CreateGuideRequest;
import az.ingress.service.abs.GuideService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MuThread implements Runnable {
    private final GuideService guideService;

    @Override
    public void run() {
        CreateGuideRequest build = CreateGuideRequest.builder().email("asdas").
                phoneNumber("Threat 2").
                name("Bomba kimi").
                build();
        guideService.createGuide(build);
    }
}
