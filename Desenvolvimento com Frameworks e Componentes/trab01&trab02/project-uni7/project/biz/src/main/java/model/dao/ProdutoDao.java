package model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import model.entity.Produto;

@Stateless
public class ProdutoDao {
	
	List<Produto> itens = new ArrayList<Produto>();
	
	@PostConstruct
	private void init() {
		itens.add(new Produto(Long.valueOf(1), "Produto 01", Double.valueOf(2.30)));
		itens.add(new Produto(Long.valueOf(2), "Produto 02", Double.valueOf(3.30)));
		itens.add(new Produto(Long.valueOf(3), "Produto 03", Double.valueOf(5.30)));
		itens.add(new Produto(Long.valueOf(4), "Produto 04", Double.valueOf(10.30)));
		itens.add(new Produto(Long.valueOf(5), "Produto 05", Double.valueOf(9.30)));
		itens.add(new Produto(Long.valueOf(6), "Produto 06", Double.valueOf(5.90)));
	}
	
	public List<Produto> listar() {
		return itens;
	}

}
