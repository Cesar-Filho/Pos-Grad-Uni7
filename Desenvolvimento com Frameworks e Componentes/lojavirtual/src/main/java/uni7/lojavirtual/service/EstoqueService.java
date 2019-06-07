package uni7.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni7.lojavirtual.model.entity.Estoque;
import uni7.lojavirtual.model.entity.ItemMovimentacao;
import uni7.lojavirtual.model.entity.Produto;
import uni7.lojavirtual.model.repository.EstoqueRepository;

@Service
public class EstoqueService extends BaseService<Estoque> {

  @Autowired
  protected EstoqueRepository estoqueRepository;

  @Autowired
  protected ReposicaoService reposicaoService;

  @Override
  protected EstoqueRepository getRepository() {
    return estoqueRepository;
  }

  public Estoque findByProduto(Produto produto) {
    return estoqueRepository.findByProduto(produto);
  }

  public Estoque adicionar(ItemMovimentacao item) {
    Estoque estoque = this.findByProduto(item.getProduto());
    estoque.setQuantidade(estoque.getQuantidade() + item.getQuantidade());
    estoqueRepository.save(estoque);
    return estoque;
  }

  public Estoque retirar(ItemMovimentacao item) {
    Estoque estoque = this.findByProduto(item.getProduto());
    estoque.setQuantidade(estoque.getQuantidade() - item.getQuantidade());
    estoqueRepository.save(estoque);
    return estoque;
  }

  public void checarEstoque(ItemMovimentacao item) throws Exception {
    Estoque estoque = this.findByProduto(item.getProduto());
    if (estoque.getQuantidade() < item.getQuantidade()) {
      reposicaoService.reporEstoque(estoque, item);
      throw new Exception("Quantidade de produto no estoque insuficiente! Produto: " + item.getProduto().getNome());
    }
  }

  public Estoque criarEstoque(Produto produto) {
    Estoque estoque = new Estoque();
    estoque.setProduto(produto);
    estoque.setQuantidade((long) 0);
    estoqueRepository.save(estoque);
    return estoque;
  }

}