package br.com.fcoromoto.spring.cloud.forum.model.dtos;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@ToString
public class TopicoForm {

  @NotNull
  @NotEmpty
  @Length(min = 5)
  private String titulo;

  @NotNull
  @NotEmpty
  @Length(min = 10)
  private String mensagem;
  
  @NotNull
  @NotEmpty
  private String nomeCurso;

}
