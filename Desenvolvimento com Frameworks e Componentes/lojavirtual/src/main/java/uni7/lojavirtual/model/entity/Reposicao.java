package uni7.lojavirtual.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import uni7.lojavirtual.model.util.FatorReposicao;
import uni7.lojavirtual.model.util.Situacao;

@Entity
@Where(clause = "ativo='t'")
@SQLDelete(sql = "UPDATE reposicao SET ativo = false WHERE id = ?")
public class Reposicao extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "produto_id", unique = true, referencedColumnName = "id")
  private Produto produto;

  @Enumerated(EnumType.STRING)
  private Situacao status = Situacao.ABERTO;

  private Long fatorReposicao = FatorReposicao.getRandomNumber(1, 3);

  @Column(columnDefinition = "bigint default '0.00'")
  private Long quantidade;

  public Situacao getStatus() {
    return status;
  }

  public void setStatus(Situacao status) {
    this.status = status;
  }

  public Long getFatorReposicao() {
    return fatorReposicao;
  }

  public void setFatorReposicao(Long fatorReposicao) {
    this.fatorReposicao = fatorReposicao;
  }

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