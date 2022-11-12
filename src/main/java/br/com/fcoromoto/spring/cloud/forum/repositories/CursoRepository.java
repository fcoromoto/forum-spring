package br.com.fcoromoto.spring.cloud.forum.repositories;

import br.com.fcoromoto.spring.cloud.forum.model.entities.Curso;
import br.com.fcoromoto.spring.cloud.forum.model.entities.Topico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
  List<Curso> findByNome(String nomeCurso);
}
