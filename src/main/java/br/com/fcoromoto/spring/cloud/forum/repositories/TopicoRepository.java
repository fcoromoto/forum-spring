package br.com.fcoromoto.spring.cloud.forum.repositories;

import br.com.fcoromoto.spring.cloud.forum.model.entities.Topico;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
  Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

  @Query("SELECT DISTINCT topico FROM Topico topico " +
      "JOIN FETCH topico.autor autor " +
      "JOIN FETCH topico.curso curso " +
      "LEFT JOIN FETCH topico.respostas respostas " +
      "WHERE topico.id = :id ")
  Optional<Topico> detalhar(Long id);
}
