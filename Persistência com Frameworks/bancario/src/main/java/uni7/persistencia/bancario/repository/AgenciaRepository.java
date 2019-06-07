package uni7.persistencia.bancario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uni7.persistencia.bancario.entity.Agencia;

@Repository
public interface AgenciaRepository extends CrudRepository<Agencia, Long> {
}