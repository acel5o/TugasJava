package org.example.database;

import org.example.database.rabbitmq.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


class DataBaseMain {
    public static EntityManager entityManager= Persistence
            .createEntityManagerFactory("mahasiswa-unit")
            .createEntityManager();
    public static DatabaseRecv receive = new DatabaseRecv(entityManager);

    public static void main(String[] args) {
        try{
            System.out.println(" [*] Waiting for messages..");
            receive.addMhs();
            receive.updateMhs();
            receive.absensiMhs();
        }catch (Exception e){
            System.out.println("Error DatabaseMain = " + e);
        }
    }
}
