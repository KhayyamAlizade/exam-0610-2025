package az.ingress.repository;

import az.ingress.entity.Traveler;
import az.ingress.repository.abs.BaseRepoInterface;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository  extends BaseRepoInterface<Traveler> {
}
