package uni7.persistencia.bancario.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uni7.persistencia.bancario.entity.Agencia;
import uni7.persistencia.bancario.entity.Conta;
import uni7.persistencia.bancario.entity.Movimentacao;

@Repository
public interface MovimentacaoRepository extends CrudRepository<Movimentacao, Long> {

  List<Movimentacao> findByAgenciaAndConta(Agencia agencia, Conta conta);

  List<Movimentacao> findByAgencia(Agencia agencia);

  List<Movimentacao> findByDataCriacaoBetween(Date datainicial, Date datafinal);
}