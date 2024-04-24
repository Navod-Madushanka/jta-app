package com.jiat.ejb.impl;

import com.jiat.ejb.remote.Login;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class LoginImpl  implements Login {

    @Resource(lookup = "jdbc/web_db")
    private DataSource db;

    @Override
    public boolean login(String email, String password) {
        try {

            Connection c = db.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM `user` WHERE id =?");
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String name = rs.getString(2);
                System.out.println("User's name = "+name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(email.equals("abc@gmail.com") && password.equals("1234")){
            return true;
        }
        return false;
    }
}
