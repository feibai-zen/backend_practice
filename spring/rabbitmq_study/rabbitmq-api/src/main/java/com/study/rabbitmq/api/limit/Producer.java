package com.study.rabbitmq.api.limit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

  public static void main(String[] args) throws Exception {

    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.setHost("111.230.115.242");
    connectionFactory.setPort(5672);
    connectionFactory.setVirtualHost("/");

    Connection connection = connectionFactory.newConnection();
    Channel channel = connection.createChannel();

    String exchange = "test_qos_exchange";
    String routingKey = "qos.save";

    String msg = "Hello RabbitMQ QOS Message";

    for (int i = 0; i < 5; i++) {
      channel.basicPublish(exchange, routingKey, true, null, msg.getBytes());
    }

  }
}
