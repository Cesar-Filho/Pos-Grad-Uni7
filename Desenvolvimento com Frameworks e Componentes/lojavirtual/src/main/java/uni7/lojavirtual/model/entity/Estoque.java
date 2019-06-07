package uni7.lojavirtual.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "ativo='t'")
@SQLDelete(sql = "UPDATE estoque SET ativo = false WHERE id = ?")
public class Estoque extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @NotNull
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "produto_id", unique = true, referencedColumnName = "id")
  private Produto produto;

  @Column(columnDefinition = "bigint default '0.00'")
  private Long quantidade;

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
  }

}