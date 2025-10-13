package az.ingress.mapper;

import az.ingress.entity.Passport;
import az.ingress.model.request.CreatePassportRequest;

import java.util.Optional;

public enum  PassportMapper {

    INSTANCE;

    private PassportMapper() {
    }



    public  Passport createRequestToPassportEnt(CreatePassportRequest createPassportRequest) {
       return Optional.ofNullable(Passport.builder().
                passportNumber(createPassportRequest.getPassportNumber()).
                country(createPassportRequest.getCountry()).
                expiryDate(createPassportRequest.getExporyDate()).
                issueDate(createPassportRequest.getIssueDate()).
                build()).orElseThrow(()-> new RuntimeException("No passport found"));
    }
}
