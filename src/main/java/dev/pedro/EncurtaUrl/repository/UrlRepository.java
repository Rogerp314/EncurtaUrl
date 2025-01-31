package dev.pedro.EncurtaUrl.repository;

import dev.pedro.EncurtaUrl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByUrlEncurtada(String urlEncurtada);
    List<Url> findByDataCriacaoBefore(LocalDateTime dataCriacao);
    boolean existsByUrlEncurtada(String urlEncurtada);
}