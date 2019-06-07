package uni7.lojavirtual.model.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "ativo='t'")
@SQLDelete(sql = "UPDATE cliente SET ativo = false WHERE id = ?")
public class Cliente extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @NotBlank
  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}