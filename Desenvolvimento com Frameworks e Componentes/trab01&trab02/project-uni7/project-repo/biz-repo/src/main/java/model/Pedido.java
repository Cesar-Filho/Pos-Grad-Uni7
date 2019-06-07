package model;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class Pedido {
	
	@Inject
	private JMSContext context;
	
	@Resource(lookup="java:/jms/queue/queue-loja")
	private Queue queue;
	
	public void enviarPedido(String req) {
		context.createProducer().send(queue, req);
		System.out.println("Pedido enviado!");
	}

}
