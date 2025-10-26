package az.ingress.repository;

import az.ingress.entity.Guide;
import az.ingress.repository.abs.BaseRepoInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import static javax.persistence.LockModeType.OPTIMISTIC;
import static javax.persistence.LockModeType.PESSIMISTIC_WRITE;

@Repository
public interface GuideRepository extends JpaRepository<Guide,Long> {


    @Lock(PESSIMISTIC_WRITE)
    @Query("select g from Guide g left join fetch g.tours where g.id = :id")
    Guide findGuideById(@Param("id")Long id);

}
