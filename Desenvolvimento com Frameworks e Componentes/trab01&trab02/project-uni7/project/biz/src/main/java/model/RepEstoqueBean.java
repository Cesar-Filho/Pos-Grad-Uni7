package model;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.google.gson.Gson;

import model.entity.ItemEstoque;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destinationLoookup", propertyValue = "jms/queue/queue-loja"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/queue-loja") })
public class RepEstoqueBean implements MessageListener {

	@EJB
	private InfoBean infoBean;

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage msg = (TextMessage) message;
			try {
				ItemEstoque item = new Gson().fromJson(msg.getText(), ItemEstoque.class);
				infoBean.addEstoque(item);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
