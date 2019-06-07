package uni7.persistencia.bancario.util;

public enum TipoConta {

  CORRENTE("Conta Corrente"), POUPANCA("Conta Poupança");

  private String nome;

  TipoConta(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

}