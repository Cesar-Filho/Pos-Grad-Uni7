package web.carrinho;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import model.entity.ItemEstoque;

@Path("carrinho")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarrinhoServlet extends HttpServlet {

	@Inject
	private CarrinhoController carrinho;

	private static final long serialVersionUID = 1L;

	Gson gson = new Gson();

	@GET
	@Path("listar")
	public Response listar() {
		return Response.status(200).entity(gson.toJson(carrinho.listar())).build();
	}

	@POST
	@Path(value = "adicionar")
	public Response adicionarQuantidade(ItemEstoque itemEstoque) {
		carrinho.adicionar(itemEstoque);
		return Response.status(200).build();
	}
	
	@POST
	@Path(value = "finalizar")
	public Response finalizar() {
		carrinho.finalizar();
		return Response.status(200).entity(gson.toJson(carrinho.listar())).build();
	}
}
