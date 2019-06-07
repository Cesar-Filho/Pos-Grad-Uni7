package uni7.persistencia.bancario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni7.persistencia.bancario.entity.Agencia;
import uni7.persistencia.bancario.entity.Cliente;
import uni7.persistencia.bancario.entity.Movimentacao;
import uni7.persistencia.bancario.service.MovimentacaoService;
import uni7.persistencia.bancario.util.QueryPeriodo;
import uni7.persistencia.bancario.util.Transferencia;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController extends BaseController<Movimentacao> {

  @Autowired
  protected MovimentacaoService movimentacaoService;

  @Override
  protected MovimentacaoService getService() {
    return movimentacaoService;
  }

  @GetMapping("/por-cliente")
  public ResponseEntity<?> findByCliente(@RequestBody Cliente cliente) {
    try {
      return new ResponseEntity<List<Movimentacao>>(movimentacaoService.findByCliente(cliente), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/por-agencia")
  public ResponseEntity<?> findByAgencia(@RequestBody Agencia agencia) {
    try {
      return new ResponseEntity<List<Movimentacao>>(movimentacaoService.findByAgencia(agencia), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/por-periodo")
  public ResponseEntity<?> findByDate(@RequestBody QueryPeriodo periodo) {
    try {
      return new ResponseEntity<List<Movimentacao>>(movimentacaoService.findByDataCriacaoBetween(periodo),
          HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/transferencia")
  public ResponseEntity<String> transferencia(@RequestBody Transferencia transferencia) {
    try {
      movimentacaoService.transferencia(transferencia);
      return new ResponseEntity<String>("Realizado com sucesso", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}