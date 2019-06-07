package model;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destinationLoookup", propertyValue = "jms/queue/queue-repo"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/queue-repo") })
public class PedidoRepBean implements MessageListener {
	
	@EJB
	private Pedido pedido;

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage msg = (TextMessage) message;
			try {
				String item = msg.getText();
				JsonObject req = new JsonObject();
				Gson gson = new Gson();
				req = gson.fromJson(item, JsonObject.class);
				Long qtd = req.get("quantidade").getAsLong();
				req.addProperty("quantidade", 10 - qtd);
				System.out.println(req);
				String resp = gson.toJson(req);
				pedido.enviarPedido(resp);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
