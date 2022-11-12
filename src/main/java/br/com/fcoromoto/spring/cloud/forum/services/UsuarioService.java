package br.com.fcoromoto.spring.cloud.forum.services;

import br.com.fcoromoto.spring.cloud.forum.model.entities.Usuario;
import br.com.fcoromoto.spring.cloud.forum.repositories.UsuarioRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
  private final UsuarioRepository repository;

  public Optional<Usuario> buscarUsuario() {
    final String email = "aluno@email.com";
    return repository.findByEmail(email).stream().findFirst();
  }
}
