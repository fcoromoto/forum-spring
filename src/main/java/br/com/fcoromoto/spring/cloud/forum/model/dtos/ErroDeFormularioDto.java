package br.com.fcoromoto.spring.cloud.forum.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ErroDeFormularioDto {
  public String campo;
  private String erro;
}
