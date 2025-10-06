package az.ingress.service.impl;

import az.ingress.model.request.CreateTourRequest;
import az.ingress.model.response.TourResponse;
import az.ingress.service.abs.TourService;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements TourService {
    @Override
    public void save(CreateTourRequest tour) {

    }

    @Override
    public TourResponse getTourById(Long id) {
        return null;
    }
}
