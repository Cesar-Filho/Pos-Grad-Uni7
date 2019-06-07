package uni7.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni7.lojavirtual.model.entity.Estoque;
import uni7.lojavirtual.model.entity.ItemMovimentacao;
import uni7.lojavirtual.model.entity.Reposicao;
import uni7.lojavirtual.model.repository.ReposicaoRepository;
import uni7.lojavirtual.model.util.Situacao;

@Service
public class ReposicaoService extends BaseService<Reposicao> {

  @Autowired
  protected ReposicaoRepository reposicaoRepository;
  @Autowired
  protected EstoqueService estoqueService;

  @Override
  protected ReposicaoRepository getRepository() {
    return reposicaoRepository;
  }

  public void reporEstoque(Estoque estoque, ItemMovimentacao item) {
    Reposicao reposicao = new Reposicao();
    reposicao.setProduto(item.getProduto());
    reposicao.setQuantidade((item.getQuantidade() - estoque.getQuantidade()) * reposicao.getFatorReposicao());
    reposicaoRepository.save(reposicao);

    ItemMovimentacao itemReposicao = new ItemMovimentacao();
    itemReposicao.setProduto(reposicao.getProduto());
    itemReposicao.setQuantidade(reposicao.getQuantidade());
    estoqueService.adicionar(itemReposicao);
    reposicao.setStatus(Situacao.FINALIZADO);

    estoqueService.save(estoque);
    reposicaoRepository.save(reposicao);
  }
}