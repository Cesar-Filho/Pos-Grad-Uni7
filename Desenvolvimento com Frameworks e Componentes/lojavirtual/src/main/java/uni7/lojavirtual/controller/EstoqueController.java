package uni7.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni7.lojavirtual.model.entity.Estoque;
import uni7.lojavirtual.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController extends BaseController<Estoque> {

  @Autowired
  protected EstoqueService estoqueService;

  @Override
  protected EstoqueService getService() {
    return estoqueService;
  }
}