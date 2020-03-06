import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class RabbitMqClient {

	ConnectionFactory factory;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RabbitMqClient rabbitMqClient = new RabbitMqClient();
		rabbitMqClient.publishMessageToQueue();
		rabbitMqClient.consumeMessageFromQueue();
	}
	
	public ConnectionFactory getConnectionFactory() {
		if (factory == null) {
			factory = new ConnectionFactory();
			factory.setHost("internal-VES-EG1V-ELB-AMQPA011-1009969357.us-east-1.elb.amazonaws.com");//("10.118.138.24");//("10.118.129.134");//// //////10.118.130.91
			factory.setPort(5672);
			factory.setUsername("gyev_user");
			factory.setPassword("GYEVuser1");
			factory.setVirtualHost("GYEV");
		}
		return factory;
	}
	
	public void publishMessageToQueue() {
		
		try {
			Connection connection = getConnectionFactory().newConnection();
			Channel channel = connection.createChannel();
//			channel.queueDeclare("VSIB-DEV-UTIL-QUEUE", true, false, false, null);
//			channel.queueDeclare("test_suman_queue", false, false, false, null);
			channel.exchangeDeclarePassive("VSIB-DEV-DB-UTIL-EXCHANGE");

			String message = "Consume message Test Suman4";
			System.out.println("Message being published to RabbitMQ Q: "+message);
			channel.basicPublish("", "VSIB_DEV_UTIL_QUEUE", null, message.getBytes("UTF-8"));
//			channel.basicPublish("", "test_suman_queue", null, message.getBytes("UTF-8"));
			System.out.println("Message published successfully!!");
			channel.close();
			connection.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
	}
	
	public void consumeMessageFromQueue() {
		
		try {
			Connection connection = getConnectionFactory().newConnection();
			Channel channel = connection.createChannel();
			
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
	            String message = new String(delivery.getBody(), "UTF-8");
	            System.out.println("Message Received '" + message + "'");
	        };
	        channel.basicConsume("VSIB_DEV_UTIL_QUEUE", true, deliverCallback, consumerTag -> { });
//			channel.close();
//			connection.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			
		}
		
	}

}
