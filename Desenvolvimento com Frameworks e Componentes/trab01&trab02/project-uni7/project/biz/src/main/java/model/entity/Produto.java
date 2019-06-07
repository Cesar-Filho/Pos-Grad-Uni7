package model.entity;


public class Produto {
	
	private Long id;
	private String descricao;
	private Double precoVenda;
	
	public Produto() {
	}

	public Produto(Long id, String descricao, Double precoVenda) {
		this.id = id;
		this.descricao = descricao;
		this.precoVenda = precoVenda;
	}
	
	public Long getCodigo() {
		return id;
	}
	public void setCodigo(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
}
