package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import model.entity.Carrinho;
import model.entity.ItemEstoque;

@Stateful
public class CarrinhoDao {

	@EJB
	private ProdutoDao produtoDao;
	
	private Carrinho carrinho;

	@PostConstruct
	public void init() {
		List<ItemEstoque> itens = new ArrayList<ItemEstoque>();
		carrinho = new Carrinho(Long.valueOf(1), itens, false);
	}

	public Carrinho listar() {
		return carrinho;
	}

	public void addCarrinho(ItemEstoque itemEstoque) {
		if (carrinho.getIsFinalizado()) {
			List<ItemEstoque> itens = new ArrayList<ItemEstoque>();
			carrinho.setId(carrinho.getId() + 1);
			carrinho.setIsFinalizado(false);
			carrinho.setItens(itens);
		}
		
		List<ItemEstoque> lista = carrinho.getItens();
		lista.add(itemEstoque);
	}

	public void finalizar() {
		carrinho.setIsFinalizado(true);
	}
	
}
