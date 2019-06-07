package uni7.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni7.lojavirtual.model.entity.Reposicao;
import uni7.lojavirtual.service.ReposicaoService;

@RestController
@RequestMapping("/reposicoes")
public class ReposicaoController extends BaseController<Reposicao> {

  @Autowired
  protected ReposicaoService reposicaoService;

  @Override
  protected ReposicaoService getService() {
    return reposicaoService;
  }

}