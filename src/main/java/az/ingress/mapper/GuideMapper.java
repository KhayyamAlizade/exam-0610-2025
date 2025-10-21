package az.ingress.mapper;

import az.ingress.entity.Guide;
import az.ingress.entity.Passport;
import az.ingress.model.request.CreateGuideRequest;
import az.ingress.model.response.GuideResponse;
import org.springframework.stereotype.Component;

public enum GuideMapper {

    INSTANCE;

    private GuideMapper() {
    }

    public Guide createRequestToGuide(CreateGuideRequest request, Passport passport) {
        return Guide.builder().
                email(request.getEmail()).
                name(request.getName()).
                phoneNumber(request.getPhoneNumber()).
                passport(passport).
                build();

    }
     public GuideResponse GuideToGuideResponse(Guide guide) {
            return GuideResponse.builder().
                    id(guide.getId()).
                    email(guide.getEmail()).
                    name(guide.getName()).
                    phoneNumber(guide.getPhoneNumber())
                    .build();

     }
}
