package web.estoque;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.InfoBean;
import model.entity.Estoque;
import model.entity.ItemEstoque;

@Stateless
@LocalBean
public class EstoqueController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private InfoBean info;

	public Estoque listar() {
		return info.getEstoque();
	}

	public void adicionar(ItemEstoque itemEstoque) {
		info.addEstoque(itemEstoque);
	}
}
