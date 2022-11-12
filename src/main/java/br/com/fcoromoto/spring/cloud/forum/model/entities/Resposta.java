package br.com.fcoromoto.spring.cloud.forum.model.entities;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resposta")
@Getter
@Setter
public class Resposta {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  private String mensagem;
  private Boolean solucao = false;
  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao = LocalDateTime.now();
  @ManyToOne(fetch = FetchType.LAZY)
  private Usuario autor;
  @ManyToOne(fetch = FetchType.LAZY)
  private Topico topico;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Resposta other = (Resposta) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
