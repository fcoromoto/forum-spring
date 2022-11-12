package br.com.fcoromoto.spring.cloud.forum.controller;

import br.com.fcoromoto.spring.cloud.forum.model.dtos.TopicoDTO;
import br.com.fcoromoto.spring.cloud.forum.model.dtos.TopicoForm;
import br.com.fcoromoto.spring.cloud.forum.services.TopicoService;
import java.net.URI;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController()
@RequestMapping("topicos")
@AllArgsConstructor
public class TopicosController {
  private final TopicoService topicoService;

  @GetMapping()
  public Page<TopicoDTO> listarTopicos(@RequestParam(required = false) String nomeCurso, @RequestParam int pagina,
      @RequestParam int quantidade) {
    Pageable paginacao = PageRequest.of(pagina, quantidade);
    return topicoService.listarTopicos(nomeCurso, paginacao);
  }

  @PostMapping
  public ResponseEntity<TopicoDTO> cadastrarTopico(@RequestBody @Valid TopicoForm topico,
      UriComponentsBuilder uriBuilder) {
    TopicoDTO topicoDTO = topicoService.cadastrarTopico(topico);
    URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(topicoDTO);
  }

  @GetMapping("/{topicoId}")
  public ResponseEntity<?> buscarTopicoPorId(@PathVariable Long topicoId) {
    return topicoService.buscarTopicoPorId(topicoId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{idTopico}")
  public ResponseEntity<TopicoDTO> atualizarTopico(@RequestBody @Valid TopicoForm topico,
      @PathVariable() Long idTopico) {
    return topicoService.atualizarTopico(topico, idTopico).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{topicoId}")
  public ResponseEntity<?> deletarTopico(@PathVariable Long topicoId) {
    topicoService.deletarTopico(topicoId);
    return ResponseEntity.ok().build();
  }

}
