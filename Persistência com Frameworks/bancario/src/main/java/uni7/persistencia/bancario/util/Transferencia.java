package uni7.persistencia.bancario.util;

import java.io.Serializable;

import uni7.persistencia.bancario.entity.Agencia;
import uni7.persistencia.bancario.entity.Cliente;
import uni7.persistencia.bancario.entity.Conta;

public class Transferencia implements Serializable {

  private static final long serialVersionUID = 1L;

  private Cliente remetente;

  private Cliente destinatario;

  private Agencia agenciaRemetente;

  private Agencia agenciaDestinatario;

  private Conta contaRemetente;

  private Conta contaDestinatario;

  private Double valor;

  public Cliente getRemetente() {
    return remetente;
  }

  public void setRemetente(Cliente remetente) {
    this.remetente = remetente;
  }

  public Cliente getDestinatario() {
    return destinatario;
  }

  public void setDestinatario(Cliente destinatario) {
    this.destinatario = destinatario;
  }

  public Agencia getAgenciaRemetente() {
    return agenciaRemetente;
  }

  public void setAgenciaRemetente(Agencia agenciaRemetente) {
    this.agenciaRemetente = agenciaRemetente;
  }

  public Agencia getAgenciaDestinatario() {
    return agenciaDestinatario;
  }

  public void setAgenciaDestinatario(Agencia agenciaDestinatario) {
    this.agenciaDestinatario = agenciaDestinatario;
  }

  public Conta getContaRemetente() {
    return contaRemetente;
  }

  public void setContaRemetente(Conta contaRemetente) {
    this.contaRemetente = contaRemetente;
  }

  public Conta getContaDestinatario() {
    return contaDestinatario;
  }

  public void setContaDestinatario(Conta contaDestinatario) {
    this.contaDestinatario = contaDestinatario;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

}