package az.ingress.service.impl;

import az.ingress.entity.Guide;
import az.ingress.entity.Passport;
import az.ingress.mapper.GuideMapper;
import az.ingress.mapper.PassportMapper;
import az.ingress.model.request.CreateGuideRequest;
import az.ingress.repository.GuideRepository;
import az.ingress.service.abs.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuideServiceImpl implements GuideService {

    private final GuideRepository guideRepository;


    @Override
    public void save(CreateGuideRequest request) {

        Passport passportEntity = PassportMapper.INSTANCE.
                                  createRequestToPassportEnt(request.getPassportRequest());
        Guide guideEntity = GuideMapper.INSTANCE.
                                    createRequestToGuide(request, passportEntity);

        guideRepository.save(guideEntity);

    }
    @Override
    public Guide getGuideById(Long id) {
     return  guideRepository.findById(id).orElseThrow(() -> new RuntimeException("No guides found with id: " + id));
    }
}
