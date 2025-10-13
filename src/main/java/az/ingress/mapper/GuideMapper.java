package az.ingress.mapper;

import az.ingress.entity.Guide;
import az.ingress.entity.Passport;
import az.ingress.model.request.CreateGuideRequest;

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
}
