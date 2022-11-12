package br.com.fcoromoto.spring.cloud.forum.services;

import br.com.fcoromoto.spring.cloud.forum.model.entities.Curso;
import br.com.fcoromoto.spring.cloud.forum.repositories.CursoRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CursoService {
  private final CursoRepository cursoRepository;

  public Optional<Curso> buscarPorNome(String nomeCurso) {
    return cursoRepository.findByNome(nomeCurso).stream().findFirst();
  }
}
