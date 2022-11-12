package br.com.fcoromoto.spring.cloud.forum.model.dtos;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class TopicoDetalhamentoDTO {

  private Long id;
  private String titulo;
  private String mensagem;
  private LocalDateTime dataCriacao;
  private String nomeAutor;
  private String nomeCurso;
  private List<RespostaDTO> respostas;

}
