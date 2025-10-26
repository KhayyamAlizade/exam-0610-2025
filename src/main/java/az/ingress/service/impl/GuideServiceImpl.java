package az.ingress.service.impl;

import az.ingress.entity.Guide;
import az.ingress.entity.Passport;
import az.ingress.mapper.GuideMapper;
import az.ingress.mapper.PassportMapper;
import az.ingress.model.request.CreateGuideRequest;
import az.ingress.model.response.GuideResponse;
import az.ingress.repository.GuideRepository;
import az.ingress.service.abs.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GuideServiceImpl implements GuideService {

    private final GuideRepository guideRepository;
     private final GuideMapper guideMapper=GuideMapper.INSTANCE;

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
        System.out.println(LocalDateTime.now());
     return  guideRepository.findGuideById(id);
    }


    @Override
    public GuideResponse getGuideResponseById(Long id) {
        Optional<Guide> guidefromHiber=  guideRepository.findById(id);
        if(guidefromHiber.isPresent()){
            System.out.println("hiberdane gelen var");
        }
        Guide GuideFromMy = getGuideById(id);
        if(GuideFromMy!=null){
            System.out.println("Mennen gelende var");
        }
        Passport passport = GuideFromMy.getPassport();
       Date issDate= passport.getIssueDate();
        return guideMapper.GuideToGuideResponse(GuideFromMy);

    }
    @Override
    public void createGuide(CreateGuideRequest build){


        save(build);
    }


}
