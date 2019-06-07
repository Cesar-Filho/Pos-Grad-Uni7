package uni7.lojavirtual.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uni7.lojavirtual.model.entity.Reposicao;

@Repository
public interface ReposicaoRepository extends CrudRepository<Reposicao, Long> {

}