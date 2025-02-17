package com.study.rabbitmq.api.returnlistener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

public class Consumer {

  public static void main(String[] args) throws Exception {

    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.setHost("111.230.115.242");
    connectionFactory.setPort(5672);
    connectionFactory.setUsername("feibai");
    connectionFactory.setPassword("123456");
    connectionFactory.setVirtualHost("/");

    Connection connection = connectionFactory.newConnection();
    Channel channel = connection.createChannel();

    String exchangeName = "test_return_exchange";
    String routingKey = "return.#";
    String queueName = "test_return_queue";

    channel.exchangeDeclare(exchangeName, "topic", true, false, null);
    channel.queueDeclare(queueName, true, false, false, null);
    channel.queueBind(queueName, exchangeName, routingKey);

    QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

    channel.basicConsume(queueName, true, queueingConsumer);//para2: ackType

    while (true) {

      Delivery delivery = queueingConsumer.nextDelivery();
      String msg = new String(delivery.getBody());
      System.err.println("消费者: " + msg);
    }

  }
}
