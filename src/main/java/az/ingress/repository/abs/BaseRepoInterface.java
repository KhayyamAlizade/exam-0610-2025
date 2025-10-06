package az.ingress.repository.abs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface   BaseRepoInterface<T> extends JpaRepository<T, Long> {
}
