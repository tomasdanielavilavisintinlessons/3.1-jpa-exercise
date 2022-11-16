package com.example.jpaexercise.connection;

import jakarta.persistence.EntityManager;

import java.sql.Connection;

public interface ConnectionHandler {
    EntityManager getConnection();
}
