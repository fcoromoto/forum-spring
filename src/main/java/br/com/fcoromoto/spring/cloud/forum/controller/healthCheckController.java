package br.com.fcoromoto.spring.cloud.forum.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("health")
@AllArgsConstructor
public class healthCheckController {

  @GetMapping()
  public String check() {
    return "UP";
  }

}
