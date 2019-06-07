package uni7.persistencia.bancario.util;

public enum TipoPessoa {

  FISICA("Física"), JURIDICA("Jurídica");

  private String nome;

  TipoPessoa(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

}