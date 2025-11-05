package az.ingress.repository;

import az.ingress.entity.Destination;
import az.ingress.repository.abs.BaseRepoInterface;
import org.springframework.stereotype.Repository;

@Repository
public interface   DestinationRepository extends BaseRepoInterface<Destination> {
}
