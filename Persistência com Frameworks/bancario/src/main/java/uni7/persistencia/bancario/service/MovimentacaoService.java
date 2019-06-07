package uni7.persistencia.bancario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni7.persistencia.bancario.entity.Agencia;
import uni7.persistencia.bancario.entity.Cliente;
import uni7.persistencia.bancario.entity.Conta;
import uni7.persistencia.bancario.entity.Movimentacao;
import uni7.persistencia.bancario.repository.MovimentacaoRepository;
import uni7.persistencia.bancario.util.QueryPeriodo;
import uni7.persistencia.bancario.util.TipoMovimentacao;
import uni7.persistencia.bancario.util.Transferencia;

@Service
public class MovimentacaoService extends BaseService<Movimentacao> {

  @Autowired
  protected MovimentacaoRepository movimentacaoRepository;

  @Autowired
  protected ContaService contaService;

  @Autowired
  protected ClienteService clienteService;

  @Override
  protected MovimentacaoRepository getRepository() {
    return movimentacaoRepository;
  }

  public List<Movimentacao> findByCliente(Cliente cliente) throws Exception {
    Cliente newCliente = clienteService.findById(cliente.getId()).get();
    if (newCliente == null)
      throw new Exception("Cliente não existe.");
    return movimentacaoRepository.findByAgenciaAndConta(newCliente.getAgencia(), newCliente.getConta());
  }

  public List<Movimentacao> findByAgencia(Agencia agencia) {
    return movimentacaoRepository.findByAgencia(agencia);
  }

  public List<Movimentacao> findByDataCriacaoBetween(QueryPeriodo periodo) {
    return movimentacaoRepository.findByDataCriacaoBetween(periodo.getDataInicial(), periodo.getDataFinal());
  }

  public void saque(Movimentacao movimentacao) throws Exception {
    if (movimentacao.getTipo() != TipoMovimentacao.SAQUE)
      throw new Exception("Tipo de movimentação incorreta.");

    movimentacaoRepository.save(movimentacao);

    Conta conta = contaService.findById(movimentacao.getConta().getId()).get();
    conta.setSaldo(conta.getSaldo() - movimentacao.getValor());

    contaService.save(conta);
  }

  public void deposito(Movimentacao movimentacao) throws Exception {
    if (movimentacao.getTipo() != TipoMovimentacao.DEPOSITO)
      throw new Exception("Tipo de movimentação incorreta.");

    movimentacaoRepository.save(movimentacao);

    Conta conta = contaService.findById(movimentacao.getConta().getId()).get();
    conta.setSaldo(conta.getSaldo() + movimentacao.getValor());

    contaService.save(conta);
  }

  @Transactional
  public void transferencia(Transferencia transferencia) {
    try {
      Movimentacao entrada = new Movimentacao();
      Movimentacao saida = new Movimentacao();

      Conta contaEntrada = contaService.findById(transferencia.getContaDestinatario().getId()).get();
      Conta contaSaida = contaService.findById(transferencia.getContaRemetente().getId()).get();

      Cliente destinatario = clienteService.findById(transferencia.getDestinatario().getId()).get();
      Cliente remetente = clienteService.findById(transferencia.getRemetente().getId()).get();

      entrada.setAgencia(destinatario.getAgencia());
      entrada.setResponsavel(remetente);
      entrada.setTipo(TipoMovimentacao.TRANSFERENCIA_ENTRADA);
      entrada.setValor(transferencia.getValor());
      contaEntrada.setSaldo(contaEntrada.getSaldo() + transferencia.getValor());
      contaService.save(contaEntrada);

      entrada.setConta(contaEntrada);
      movimentacaoRepository.save(entrada);

      saida.setAgencia(remetente.getAgencia());
      saida.setConta(remetente.getConta());
      saida.setResponsavel(remetente);
      saida.setTipo(TipoMovimentacao.TRANSFERENCIA_SAIDA);
      saida.setValor(transferencia.getValor());
      contaSaida.setSaldo(contaSaida.getSaldo() - transferencia.getValor());
      contaService.save(contaSaida);
      movimentacaoRepository.save(saida);

      entrada.setMovimentacao(saida);
      saida.setMovimentacao(entrada);
      movimentacaoRepository.save(saida);
      movimentacaoRepository.save(entrada);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}