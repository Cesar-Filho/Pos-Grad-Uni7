package uni7.lojavirtual.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uni7.lojavirtual.model.entity.Estoque;
import uni7.lojavirtual.model.entity.Produto;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Long> {

  Estoque findByProduto(Produto produto);

}