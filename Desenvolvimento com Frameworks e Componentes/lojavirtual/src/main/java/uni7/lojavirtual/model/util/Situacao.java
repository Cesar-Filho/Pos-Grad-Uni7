package uni7.lojavirtual.model.util;

public enum Situacao {

  ABERTO("aberto"), FINALIZADO("finalizado"), CANCELADO("cancelado");

  private String nome;

  Situacao(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

}