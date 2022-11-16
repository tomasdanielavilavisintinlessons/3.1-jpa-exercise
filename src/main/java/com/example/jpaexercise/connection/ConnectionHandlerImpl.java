package com.example.jpaexercise.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionHandlerImpl implements ConnectionHandler {
    private static EntityManagerFactory emf;
    private EntityManager entityManager;

    private static ConnectionHandler INSTANCE = new ConnectionHandlerImpl();

    private ConnectionHandlerImpl() {
        emf = Persistence.createEntityManagerFactory("jpaee");
        this.entityManager = emf.createEntityManager();
    }

    public static ConnectionHandler getInstance() {
        return INSTANCE;
    }

    @Override
    public EntityManager getConnection() {
        return this.entityManager;
    }
}
