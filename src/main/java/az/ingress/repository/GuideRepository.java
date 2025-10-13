package az.ingress.repository;

import az.ingress.entity.Guide;
import az.ingress.repository.abs.BaseRepoInterface;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends BaseRepoInterface<Guide> {
}
