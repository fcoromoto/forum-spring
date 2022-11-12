package br.com.fcoromoto.spring.cloud.forum.services;

import br.com.fcoromoto.spring.cloud.forum.mappers.TopicoMapper;
import br.com.fcoromoto.spring.cloud.forum.model.dtos.TopicoDTO;
import br.com.fcoromoto.spring.cloud.forum.model.dtos.TopicoDetalhamentoDTO;
import br.com.fcoromoto.spring.cloud.forum.model.dtos.TopicoForm;
import br.com.fcoromoto.spring.cloud.forum.model.entities.Curso;
import br.com.fcoromoto.spring.cloud.forum.model.entities.Topico;
import br.com.fcoromoto.spring.cloud.forum.model.entities.Usuario;
import br.com.fcoromoto.spring.cloud.forum.repositories.TopicoRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class TopicoService {
  private final TopicoRepository repository;
  private final TopicoMapper mapper;
  private final CursoService cursoService;
  private final UsuarioService usuarioService;

  public Page<TopicoDTO> listarTopicos(String nomeCurso, Pageable paginacao) {
    Page<Topico> topicos = StringUtils.hasText(nomeCurso) ?
        repository.findByCursoNome(nomeCurso, paginacao) :
        repository.findAll(paginacao);

    return topicos.map(mapper::toTopicoDTO);
  }

  public TopicoDTO cadastrarTopico(TopicoForm topicoForm) {
    Curso curso = buscarCursoPorNome(topicoForm);
    Usuario usuario = usuarioService.buscarUsuario().orElseThrow();
    Topico topico = mapper.toTopico(topicoForm, curso, usuario);
    repository.save(topico);
    return mapper.toTopicoDTO(topico);
  }

  private Curso buscarCursoPorNome(TopicoForm topicoForm) {
    String nomeCurso = topicoForm.getNomeCurso();
    return cursoService.buscarPorNome(nomeCurso).orElseThrow();
  }

  public Optional<TopicoDetalhamentoDTO> buscarTopicoPorId(Long topicoId) {
    return repository.detalhar(topicoId).map(mapper::toTopicoDetalhamento);
  }

  public Optional<TopicoDTO> atualizarTopico(TopicoForm topicoForm, Long idTopico) {
    return repository.findById(idTopico).map(topico -> {
      mapper.atualizar(topico, topicoForm);
      Topico topicoAtualizado = repository.save(topico);
      return mapper.toTopicoDTO(topicoAtualizado);
    });
  }

  public void deletarTopico(Long topicoId) {
    repository.deleteById(topicoId);
  }
}
