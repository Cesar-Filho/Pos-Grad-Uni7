package uni7.persistencia.bancario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "ativo=true")
@SQLDelete(sql = "UPDATE agencia SET ativo = false WHERE id = ?")
public class Agencia extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @NotBlank
  private String nome;

  @NotNull
  @Column(unique = true)
  private Long numero;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

}