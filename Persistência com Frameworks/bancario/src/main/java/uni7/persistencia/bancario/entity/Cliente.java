package uni7.persistencia.bancario.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import uni7.persistencia.bancario.util.TipoPessoa;

@Entity
@Where(clause = "ativo=true")
@SQLDelete(sql = "UPDATE cliente SET ativo = false WHERE id = ?")
public class Cliente extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @NotBlank
  private String nomeCompleto;

  @NotBlank
  @Pattern(regexp = "[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}|^[0-9]{2}.[0-9]{3}.[0-9]{3}/[0-9]{4}-[0-9]{2}$", message = "Formato Inválido")
  private String cpfCnpj;

  @NotBlank
  private String logradouro;

  private Long numero;

  private String complemento;

  @NotBlank
  private String bairro;

  @NotBlank
  private String cidade;

  @NotNull
  @Enumerated(EnumType.STRING)
  private TipoPessoa tipo;

  @Email(message = "E-mail não é válido.")
  private String email;

  private String telefone;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "agencia_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_AGENCIA"))
  private Agencia agencia;

  @NotNull
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "conta_id", referencedColumnName = "id", foreignKey = @ForeignKey)
  private Conta conta;

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public TipoPessoa getTipo() {
    return tipo;
  }

  public void setTipo(TipoPessoa tipo) {
    this.tipo = tipo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public Agencia getAgencia() {
    return agencia;
  }

  public void setAgencia(Agencia agencia) {
    this.agencia = agencia;
  }

  public String getCpfCnpj() {
    return cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }
}