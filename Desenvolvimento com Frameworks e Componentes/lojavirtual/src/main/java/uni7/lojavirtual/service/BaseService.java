package uni7.lojavirtual.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import uni7.lojavirtual.model.entity.BaseEntity;

public abstract class BaseService<T extends BaseEntity> {

  protected abstract CrudRepository<T, Long> getRepository();

  public Iterable<T> findAll() {
    return getRepository().findAll();
  }

  public Optional<T> findById(Long id) {
    Optional<T> entity = getRepository().findById(id);
    return entity;
  }

  public T save(T entity) {
    return getRepository().save(entity);
  }

  public void delete(T entity) {
    getRepository().delete(entity);
  }
}