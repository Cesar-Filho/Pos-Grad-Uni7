package uni7.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni7.lojavirtual.model.entity.Produto;
import uni7.lojavirtual.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends BaseController<Produto> {

  @Autowired
  protected ProdutoService produtos;

  @Override
  protected ProdutoService getService() {
    return produtos;
  }

}