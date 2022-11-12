package br.com.fcoromoto.spring.cloud.forum.model.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "topico")
public class Topico {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String mensagem;

  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao = LocalDateTime.now();

  @Enumerated(EnumType.STRING)
  private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

  @ManyToOne(fetch = FetchType.LAZY)
  private Usuario autor;

  @ManyToOne(fetch = FetchType.LAZY)
  private Curso curso;

  @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
  private List<Resposta> respostas = new ArrayList<>();

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
    Topico other = (Topico) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
