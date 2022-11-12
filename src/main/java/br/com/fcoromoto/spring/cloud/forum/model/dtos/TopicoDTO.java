package br.com.fcoromoto.spring.cloud.forum.model.dtos;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class TopicoDTO {

  private Long id;
  private String titulo;
  private String mensagem;
  private LocalDateTime dataCriacao;

}
