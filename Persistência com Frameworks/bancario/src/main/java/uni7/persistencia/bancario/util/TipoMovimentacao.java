package uni7.persistencia.bancario.util;

public enum TipoMovimentacao {

  SAQUE("Saque"), DEPOSITO("Deposito"), TRANSFERENCIA_ENTRADA("Entrada por transferência"),
  TRANSFERENCIA_SAIDA("Saída por transferência");

  private String nome;

  TipoMovimentacao(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

}