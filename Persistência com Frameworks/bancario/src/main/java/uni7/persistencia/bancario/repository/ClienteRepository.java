package uni7.persistencia.bancario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uni7.persistencia.bancario.entity.Agencia;
import uni7.persistencia.bancario.entity.Cliente;
import uni7.persistencia.bancario.entity.Conta;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

  Cliente findByAgenciaAndConta(Agencia agencia, Conta conta);
}