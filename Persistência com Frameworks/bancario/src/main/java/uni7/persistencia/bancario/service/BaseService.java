package uni7.persistencia.bancario.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import uni7.persistencia.bancario.entity.BaseEntity;

public abstract class BaseService<T extends BaseEntity> {

  protected abstract CrudRepository<T, Long> getRepository();

  public Iterable<T> findAll() {
    return getRepository().findAll();
  }

  public Optional<T> findById(Long id) {
    Optional<T> entity = getRepository().findById(id);
    return entity;
  }

  @Transactional
  public T save(T entity) {
    return getRepository().save(entity);
  }

  @Transactional
  public void delete(T entity) {
    getRepository().delete(entity);
  }
}