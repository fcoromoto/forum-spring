package br.com.fcoromoto.spring.cloud.forum.repositories;

import br.com.fcoromoto.spring.cloud.forum.model.entities.Curso;
import br.com.fcoromoto.spring.cloud.forum.model.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  List<Usuario> findByEmail(String email);
}
