package model.entity;

import java.util.List;

public class Carrinho {

	private Long id;
	private List<ItemEstoque> itens;
	private Boolean isFinalizado;

	public Carrinho() {
	}

	public Carrinho(Long id, List<ItemEstoque> itens, Boolean isFinalizado) {
		this.id = id;
		this.itens = itens;
		this.isFinalizado = isFinalizado;
	}
	
	public Boolean getIsFinalizado() {
		return isFinalizado;
	}

	public void setIsFinalizado(Boolean isFinalizado) {
		this.isFinalizado = isFinalizado;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemEstoque> getItens() {
		return itens;
	}

	public void setItens(List<ItemEstoque> itens) {
		this.itens = itens;
	}
}
