package model.entity;

import java.util.List;

public class Estoque {
	
	private List<ItemEstoque> itens;
	
	public Estoque() {
	}
	
	public Estoque(List<ItemEstoque> itens) {
		this.itens = itens;
	}
	
	public List<ItemEstoque> getItens() {
		return itens;
	}
	public void setItens(List<ItemEstoque> itens) {
		this.itens = itens;
	}

}
