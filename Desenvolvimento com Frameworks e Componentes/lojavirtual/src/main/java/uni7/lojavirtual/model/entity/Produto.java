package uni7.lojavirtual.model.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "ativo='t'")
@SQLDelete(sql = "UPDATE produto SET ativo = false WHERE id = ?")
public class Produto extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @NotNull
  private String nome;

  @NotNull
  private Double valor;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

}