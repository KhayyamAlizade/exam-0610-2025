package az.ingress.repository;
import  az.ingress.entity.Tour;
import az.ingress.repository.abs.BaseRepoInterface;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository  extends BaseRepoInterface<Tour> {
}
