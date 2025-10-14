package az.ingress.repository;

import az.ingress.entity.Guide;
import az.ingress.repository.abs.BaseRepoInterface;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends BaseRepoInterface<Guide> {
    @Override
    @Query("select g from Guide g join fetch g.tours  where g.id =:id")
    public Guide findGuideById(@Param("id")Long id);

}
