package uni7.lojavirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni7.lojavirtual.model.entity.Cliente;
import uni7.lojavirtual.model.repository.ClienteRepository;

@Service
public class ClienteService extends BaseService<Cliente> {

  @Autowired
  protected ClienteRepository clientes;

  @Override
  protected ClienteRepository getRepository() {
    return clientes;
  }

}