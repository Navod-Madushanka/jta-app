package com.jiat.ejb.impl;

import com.jiat.ejb.remote.Register;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Stateless
public class RegisterImpl implements Register {
    @Resource(lookup = "jdbc/web_db")
    private DataSource db;

    @Override
    public boolean register(String name) {
        try (Connection connection = db.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (`name`) VALUES(?)")) {
            preparedStatement.setString(1, name);
            int i = preparedStatement.executeUpdate();
            System.out.println(i + " record(s) inserted");
            return i > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL query", e);
        }

    }
}
