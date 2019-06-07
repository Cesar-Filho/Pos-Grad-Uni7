package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.entity.Estoque;
import model.entity.ItemEstoque;
import model.entity.Produto;

@Stateless
public class EstoqueDao {

	@EJB
	private ProdutoDao produtoDao;

	private Estoque estoque;

	@PostConstruct
	public void init() {
		List<Produto> produtos = produtoDao.listar();

		List<ItemEstoque> itens = new ArrayList<ItemEstoque>();

		for (int i = 0; i < produtos.size(); i++) {
			itens.add(new ItemEstoque(Long.valueOf(i), produtos.get(i), Long.valueOf(10)));
		}
		estoque = new Estoque(itens);

	}

	public Estoque listar() {
		return estoque;
	}

	public void addEstoque(ItemEstoque itemEstoque) {
		for (ItemEstoque item : estoque.getItens()) {
			if (item.getId() == itemEstoque.getId()) {
				item.setQuantidade(item.getQuantidade() + itemEstoque.getQuantidade());
			}
		}
	}
	
	public Long getItemEstoqueQtd(ItemEstoque itemEstoque) {
		for (ItemEstoque item : estoque.getItens()) {
			if (item.getId() == itemEstoque.getId()) {
				return item.getQuantidade();
			}
		}
		return null;
	}

	public void remove(ItemEstoque itemEstoque) {
		for (ItemEstoque item : estoque.getItens()) {
			if (item.getId() == itemEstoque.getId()) {
				item.setQuantidade(item.getQuantidade() - itemEstoque.getQuantidade());
			}
		}
	}
}
