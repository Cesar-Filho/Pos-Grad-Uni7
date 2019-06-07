package uni7.persistencia.bancario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni7.persistencia.bancario.entity.Agencia;
import uni7.persistencia.bancario.entity.Cliente;
import uni7.persistencia.bancario.entity.Conta;
import uni7.persistencia.bancario.repository.ClienteRepository;

@Service
public class ClienteService extends BaseService<Cliente> {

  @Autowired
  protected ClienteRepository clienteRepository;

  @Override
  protected ClienteRepository getRepository() {
    return clienteRepository;
  }

  public Cliente findByAgenciaAndConta(Agencia agencia, Conta conta) {
    return clienteRepository.findByAgenciaAndConta(agencia, conta);
  }
}