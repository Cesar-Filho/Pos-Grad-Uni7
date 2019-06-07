package uni7.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni7.lojavirtual.model.entity.Produto;
import uni7.lojavirtual.model.repository.ProdutoRepository;

@Service
public class ProdutoService extends BaseService<Produto> {

  @Autowired
  protected ProdutoRepository produtos;

  @Override
  protected ProdutoRepository getRepository() {
    return produtos;
  }

}