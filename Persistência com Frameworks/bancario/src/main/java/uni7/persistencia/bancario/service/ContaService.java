package uni7.persistencia.bancario.service;

import javax.persistence.LockModeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uni7.persistencia.bancario.entity.Conta;
import uni7.persistencia.bancario.repository.ContaRepository;

@Service
public class ContaService extends BaseService<Conta> {

  @Autowired
  protected ContaRepository contaRepository;

  @Override
  protected ContaRepository getRepository() {
    return contaRepository;
  }

  @Override
  @Transactional
  @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
  public Conta save(Conta entity) {
    return super.save(entity);
  }

}