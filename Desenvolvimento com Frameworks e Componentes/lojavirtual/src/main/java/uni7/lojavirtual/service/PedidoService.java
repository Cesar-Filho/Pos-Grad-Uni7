package uni7.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni7.lojavirtual.model.entity.Estoque;
import uni7.lojavirtual.model.entity.ItemMovimentacao;
import uni7.lojavirtual.model.entity.Pedido;
import uni7.lojavirtual.model.repository.PedidoRepository;
import uni7.lojavirtual.model.util.Situacao;

@Service
public class PedidoService extends BaseService<Pedido> {

  @Autowired
  protected PedidoRepository pedidoRepository;

  @Autowired
  protected EstoqueService estoqueService;

  @Autowired
  protected ReposicaoService reposicaoService;

  @Override
  protected PedidoRepository getRepository() {
    return pedidoRepository;
  }

  public void verificar(Iterable<ItemMovimentacao> itens) throws Exception {
    for (ItemMovimentacao item : itens) {
      Estoque estoque = estoqueService.findByProduto(item.getProduto());

      if (estoque == null) {
        estoque = estoqueService.criarEstoque(item.getProduto());
      }
      if (estoque.getQuantidade() < item.getQuantidade()) {
        reposicaoService.reporEstoque(estoque, item);
        throw new Exception("Quantidade de produto no estoque insuficiente! Produto: " + item.getProduto().getNome());
      }

    }
  }

  public Pedido finalizar(Pedido entity) {
    for (ItemMovimentacao item : entity.getItens()) {
      if (item != null)
        estoqueService.retirar(item);
    }
    entity.setStatus(Situacao.FINALIZADO);
    pedidoRepository.save(entity);
    return entity;
  }
}