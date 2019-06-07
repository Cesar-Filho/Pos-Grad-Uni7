package uni7.persistencia.bancario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import uni7.persistencia.bancario.util.TipoMovimentacao;

@Entity
@Where(clause = "ativo=true")
@SQLDelete(sql = "UPDATE movimentacao SET ativo = false WHERE id = ?")
public class Movimentacao extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "responsavel_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_RESPONSAVEL"))
  private Cliente responsavel;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "agencia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_AGENCIA"))
  private Agencia agencia;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "conta_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CONTA"))
  private Conta conta;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movimentacao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_MOVIMENTACAO"))
  private Movimentacao movimentacao;

  @NotNull
  @Enumerated(EnumType.STRING)
  private TipoMovimentacao tipo;

  @Column(columnDefinition = "decimal(10, 2) default '0.00'")
  private Double valor;

  public Agencia getAgencia() {
    return agencia;
  }

  public void setAgencia(Agencia agencia) {
    this.agencia = agencia;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }

  public TipoMovimentacao getTipo() {
    return tipo;
  }

  public void setTipo(TipoMovimentacao tipo) {
    this.tipo = tipo;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Cliente getResponsavel() {
    return responsavel;
  }

  public void setResponsavel(Cliente responsavel) {
    this.responsavel = responsavel;
  }

  public Movimentacao getMovimentacao() {
    return movimentacao;
  }

  public void setMovimentacao(Movimentacao movimentacao) {
    this.movimentacao = movimentacao;
  }

}