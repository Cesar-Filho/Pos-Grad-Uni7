package uni7.lojavirtual.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import uni7.lojavirtual.model.util.Situacao;

@Entity
@Where(clause = "ativo='t'")
@SQLDelete(sql = "UPDATE pedido SET ativo = false WHERE id = ?")
public class Pedido extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "cliente_id", referencedColumnName = "id")
  private Cliente cliente;

  @OneToMany(fetch = FetchType.EAGER)
  @Fetch(FetchMode.SUBSELECT)
  @Where(clause = "ativo = 't'")
  @JoinColumn(name = "itemmovimentacao_id")
  private List<ItemMovimentacao> itens;

  @Enumerated(EnumType.STRING)
  private Situacao status = Situacao.ABERTO;

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Situacao getStatus() {
    return status;
  }

  public void setStatus(Situacao status) {
    this.status = status;
  }

  public List<ItemMovimentacao> getItens() {
    return itens;
  }

  public void setItens(List<ItemMovimentacao> itens) {
    this.itens = itens;
  }

}