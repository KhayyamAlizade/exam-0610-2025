package az.ingress.repository.abs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface   BaseRepoInterface<T> extends JpaRepository<T, Long> {
}
