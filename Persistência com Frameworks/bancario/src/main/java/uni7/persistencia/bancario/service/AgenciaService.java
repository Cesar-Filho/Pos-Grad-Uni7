package uni7.persistencia.bancario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni7.persistencia.bancario.entity.Agencia;
import uni7.persistencia.bancario.repository.AgenciaRepository;

@Service
public class AgenciaService extends BaseService<Agencia> {

  @Autowired
  protected AgenciaRepository agenciaRepository;

  @Override
  protected AgenciaRepository getRepository() {
    return agenciaRepository;
  }

}