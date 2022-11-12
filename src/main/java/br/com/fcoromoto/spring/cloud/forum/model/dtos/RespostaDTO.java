package br.com.fcoromoto.spring.cloud.forum.model.dtos;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class RespostaDTO {
  private Long id;
  private String mensagem;
  private LocalDateTime dataCriacao;
  private String nomeAutor;
}
