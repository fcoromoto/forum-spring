package br.com.fcoromoto.spring.cloud.forum.mappers;

import br.com.fcoromoto.spring.cloud.forum.model.dtos.TopicoDTO;
import br.com.fcoromoto.spring.cloud.forum.model.dtos.TopicoDetalhamentoDTO;
import br.com.fcoromoto.spring.cloud.forum.model.dtos.TopicoForm;
import br.com.fcoromoto.spring.cloud.forum.model.entities.Curso;
import br.com.fcoromoto.spring.cloud.forum.model.entities.Topico;
import br.com.fcoromoto.spring.cloud.forum.model.entities.Usuario;
import java.util.List;
import java.util.Objects;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface TopicoMapper {
  TopicoDTO toTopicoDTO(Topico topico);

  Topico toTopico(TopicoForm topicoForm);

  @Mapping(target = "nomeCurso", source = "curso.nome")
  @Mapping(target = "nomeAutor", source = "autor.nome")
  TopicoDetalhamentoDTO toTopicoDetalhamento(Topico topico);
  
  void atualizar(@MappingTarget Topico topico, TopicoForm topicoForm);

  default Topico toTopico(TopicoForm topicoForm, Curso curso, Usuario usuario) {
    Topico topico = toTopico(topicoForm);
    if (Objects.isNull(topico)) {
      return null;
    }
    topico.setCurso(curso);
    topico.setAutor(usuario);
    return topico;
  }

  List<TopicoDTO> toTopicosDTO(List<Topico> topicos);
}
