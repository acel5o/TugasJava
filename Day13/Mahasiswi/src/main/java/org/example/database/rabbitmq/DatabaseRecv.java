package org.example.database.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import org.example.database.service.*;

public class DatabaseRecv {

    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private EntityManager entityManager;
    private MahasiswaDAO mhsDao;
    public DatabaseRecv(EntityManager entityManager){
        this.entityManager = entityManager;
        mhsDao = new MahasiswaDAO(entityManager);
    }

    public void connectRabbitMQ() throws IOException, TimeoutException {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
    }

    public void addMhs() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("create", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mhsString + "'");
                mhsDao.addMhsDAO(mhsString);
            };
            channel.basicConsume("create", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error insertMahasiswa = " + e);
        }
    }


    public void updateMhs() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("update", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mhsString + "'");
                mhsDao.updateMhsDAO(mhsString);
            };
            channel.basicConsume("update", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error updateMahasiswaById = " + e);
        }
    }

    public void absensiMhs() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("absen", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String idString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idString + "'");
                mhsDao.absensiDAO(idString);
            };
            channel.basicConsume("absen", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error TambahAbsenMhs = " + e);
        }
    }
}
