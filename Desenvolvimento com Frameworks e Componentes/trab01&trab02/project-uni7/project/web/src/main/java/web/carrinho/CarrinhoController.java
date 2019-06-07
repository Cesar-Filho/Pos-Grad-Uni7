package web.carrinho;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.InfoBean;
import model.entity.Carrinho;
import model.entity.ItemEstoque;

@Stateless
@LocalBean
public class CarrinhoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private InfoBean info;

	public Carrinho listar() {
		return info.getCarrinho();
	}

	public void adicionar(ItemEstoque itemEstoque) {
		info.addCarrinho(itemEstoque);
	}

	public void finalizar() {
		info.finalizar();
	}
}
