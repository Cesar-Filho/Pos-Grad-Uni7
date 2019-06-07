package uni7.persistencia.bancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni7.persistencia.bancario.entity.Conta;
import uni7.persistencia.bancario.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController extends BaseController<Conta> {

  @Autowired
  protected ContaService contaService;

  @Override
  protected ContaService getService() {
    return contaService;
  }

}