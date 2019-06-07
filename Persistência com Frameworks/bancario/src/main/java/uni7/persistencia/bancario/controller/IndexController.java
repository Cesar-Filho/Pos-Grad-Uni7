package uni7.persistencia.bancario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

  @GetMapping
  public ResponseEntity<String> versao() {
    return new ResponseEntity<String>("version 1.0", HttpStatus.OK);
  }
}