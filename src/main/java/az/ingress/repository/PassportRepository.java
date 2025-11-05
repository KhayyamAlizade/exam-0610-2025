package az.ingress.repository;

import az.ingress.entity.Passport;
import az.ingress.repository.abs.BaseRepoInterface;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends BaseRepoInterface<Passport> {
}
