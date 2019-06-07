package uni7.persistencia.bancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni7.persistencia.bancario.entity.Cliente;
import uni7.persistencia.bancario.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController<Cliente> {

  @Autowired
  protected ClienteService clientes;

  @Override
  protected ClienteService getService() {
    return clientes;
  }

}