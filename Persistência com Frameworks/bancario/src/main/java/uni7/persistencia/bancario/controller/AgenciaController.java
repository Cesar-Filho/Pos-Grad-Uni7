package uni7.persistencia.bancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni7.persistencia.bancario.entity.Agencia;
import uni7.persistencia.bancario.service.AgenciaService;

@RestController
@RequestMapping("/agencias")
public class AgenciaController extends BaseController<Agencia> {

  @Autowired
  protected AgenciaService agenciaService;

  @Override
  protected AgenciaService getService() {
    return agenciaService;
  }

}