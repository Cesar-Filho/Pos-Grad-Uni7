package uni7.persistencia.bancario.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uni7.persistencia.bancario.entity.BaseEntity;
import uni7.persistencia.bancario.service.BaseService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<T extends BaseEntity> {

  protected abstract BaseService<T> getService();

  @GetMapping
  public ResponseEntity<?> listar() {
    try {
      return new ResponseEntity<Iterable<T>>(getService().findAll(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> buscar(@PathVariable Long id) {
    try {
      Optional<T> entity = getService().findById(id);
      if (entity.isEmpty())
        throw new Exception("Registro não existe.");
      return new ResponseEntity<Optional<T>>(entity, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<?> criar(@RequestBody T entity) {
    try {
      entity = prePost(entity);
      return new ResponseEntity<T>(getService().save(entity), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  protected T prePost(T entity) throws Exception {
    return entity;
  }

  @PutMapping
  public ResponseEntity<?> editar(@RequestBody T entity) {
    try {
      if (entity.getId() == null)
        throw new Exception("Registro não existe.");
      entity = prePut(entity);
      return new ResponseEntity<T>(getService().save(entity), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  protected T prePut(T entity) throws Exception {
    return entity;
  }

  @DeleteMapping
  public ResponseEntity<?> deletar(@RequestBody T entity) {
    try {
      if (entity.getId() == null)
        throw new Exception("Registro não existe.");
      getService().delete(entity);
      return new ResponseEntity<String>("Registro excluído com sucesso!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}