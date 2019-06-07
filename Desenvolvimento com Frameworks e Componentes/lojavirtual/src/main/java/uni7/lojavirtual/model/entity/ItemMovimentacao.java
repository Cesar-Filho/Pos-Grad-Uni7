package uni7.lojavirtual.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "ativo='t'")
@SQLDelete(sql = "UPDATE itemmovimentacao SET ativo = false WHERE id = ?")
public class ItemMovimentacao extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @NotNull
  @JoinColumn(name = "produto_id", referencedColumnName = "id")
  private Produto produto;

  @NotNull
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