package uni7.lojavirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni7.lojavirtual.model.entity.Pedido;
import uni7.lojavirtual.model.repository.EstoqueRepository;
import uni7.lojavirtual.model.util.Situacao;
import uni7.lojavirtual.service.PedidoService;
import uni7.lojavirtual.service.ReposicaoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController extends BaseController<Pedido> {

  @Autowired
  protected PedidoService pedidos;

  @Autowired
  protected EstoqueRepository estoqueRepository;

  @Autowired
  protected ReposicaoService reposicaoService;

  @Override
  protected PedidoService getService() {
    return pedidos;
  }

  @PutMapping("/finalizar")
  public ResponseEntity<?> finalizar(@RequestBody Pedido entity) {
    try {
      if (entity.getId() == null)
        throw new Exception("Registro não existe.");

      validarPedido(entity);

      return new ResponseEntity<Pedido>(pedidos.finalizar(entity), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/cancelar")
  public ResponseEntity<?> cancelar(@RequestBody Pedido entity) {
    try {
      if (entity.getId() == null)
        throw new Exception("Registro não existe.");
      if (entity.getStatus() != Situacao.ABERTO)
        throw new Exception("Somente pedido em aberto pode ser cancelado.");

      entity.setStatus(Situacao.CANCELADO);

      return new ResponseEntity<Pedido>(pedidos.save(entity), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  protected Pedido prePost(Pedido entity) throws Exception {
    validarPedido(entity);
    return entity;
  }

  @Override
  protected Pedido prePut(Pedido entity) throws Exception {
    validarPedido(entity);
    return entity;
  }

  private void validarPedido(Pedido entity) throws Exception {
    if (entity.getCliente().getId() == null)
      throw new Exception("Cliente não encontrado.");

    if (entity.getStatus() != Situacao.ABERTO)
      throw new Exception("Pedido Inválido! Pedido deve está no status em aberto.");

    if (entity.getItens() == null || entity.getItens().size() == 0)
      throw new Exception("Informe pelo menos um item no pedido.");

    pedidos.verificar(entity.getItens());
  }
}