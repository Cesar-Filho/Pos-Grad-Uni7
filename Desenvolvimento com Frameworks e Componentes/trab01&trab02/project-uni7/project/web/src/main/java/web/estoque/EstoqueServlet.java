package web.estoque;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import model.entity.ItemEstoque;

@Path("estoque")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstoqueServlet extends HttpServlet {

	@Inject
	private EstoqueController estoque;

	private static final long serialVersionUID = 1L;

	Gson gson = new Gson();

	@GET
	@Path("listar")
	public Response listar() {
		return Response.status(200).entity(gson.toJson(estoque.listar())).build();
	}

	@PUT
	@Path(value = "adicionar")
	public Response adicionarQuantidade(ItemEstoque itemEstoque) {
		estoque.adicionar(itemEstoque);
		return Response.status(200).build();
	}
	
}
