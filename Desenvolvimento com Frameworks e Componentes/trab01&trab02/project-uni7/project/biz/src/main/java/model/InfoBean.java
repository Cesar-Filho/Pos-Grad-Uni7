package model;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.dao.CarrinhoDao;
import model.dao.EstoqueDao;
import model.entity.Carrinho;
import model.entity.Estoque;
import model.entity.ItemEstoque;

@Startup
@Singleton
public class InfoBean {

	@EJB
	private EstoqueDao estoqueDao;
	@EJB
	private CarrinhoDao carrinhoDao;

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:/jms/queue/queue-repo")
	private Queue queue;

	private Estoque estoque;
	private Carrinho carrinho;

	@PostConstruct
	private void init() {
		estoque = estoqueDao.listar();
		carrinho = carrinhoDao.listar();
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void addEstoque(ItemEstoque itemEstoque) {
		estoqueDao.addEstoque(itemEstoque);
	}

	public void addCarrinho(ItemEstoque itemEstoque) {
		carrinhoDao.addCarrinho(itemEstoque);
	}

	public void finalizar() {
		try {
			carrinhoDao.finalizar();
			for (ItemEstoque item : carrinho.getItens()) {
				estoqueDao.remove(item);
				if (estoqueDao.getItemEstoqueQtd(item) <= 0) {
					Gson gson = new Gson();
					JsonObject req = new JsonObject();
					req.addProperty("id", item.getId());
					req.addProperty("quantidade", estoqueDao.getItemEstoqueQtd(item));
					String pedido = gson.toJson(req);
					context.createProducer().send(queue, pedido);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
