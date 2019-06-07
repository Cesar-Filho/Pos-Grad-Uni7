package uni7.persistencia.bancario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import uni7.persistencia.bancario.util.TipoConta;

@Entity
@Where(clause = "ativo=true")
@SQLDelete(sql = "UPDATE conta SET ativo = false WHERE id = ?")
public class Conta extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @NotNull
  @Enumerated(EnumType.STRING)
  private TipoConta tipo;

  @NotNull
  private Long numero;

  @Column(columnDefinition = "decimal(10, 2) default '0.00'")
  private Double saldo;

  @Version
  private Long versao;

  public TipoConta getTipo() {
    return tipo;
  }

  public void setTipo(TipoConta tipo) {
    this.tipo = tipo;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public Long getVersao() {
    return versao;
  }

  public void setVersao(Long versao) {
    this.versao = versao;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }
}