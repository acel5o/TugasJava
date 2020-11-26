package org.example.restapi.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RestApiSend {

    public static void addMhs(String mahasiswa) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("create", false, false, false, null);
            channel.basicPublish("", "create", null, mahasiswa.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mahasiswa + "'");
        }
    }


    public static void updateMhs(String mahasiswa) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("update", false, false, false, null);
            channel.basicPublish("", "update", null, mahasiswa.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mahasiswa + "'");
        }
    }

    public static void absensiMhs(String mahasiswa) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("absen", false, false, false, null);
            channel.basicPublish("", "absen", null, mahasiswa.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mahasiswa + "'");
        }
    }
}

