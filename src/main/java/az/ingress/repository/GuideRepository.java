package az.ingress.repository;

import az.ingress.entity.Guide;
import az.ingress.repository.abs.BaseRepoInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import static javax.persistence.LockModeType.OPTIMISTIC;

@Repository
public interface GuideRepository extends JpaRepository<Guide,Long> {

    @Transactional
    @Lock(OPTIMISTIC)
    @Query("select g from Guide g left join fetch g.tours where g.id = :id")
    Guide findGuideById(@Param("id")Long id);

}
