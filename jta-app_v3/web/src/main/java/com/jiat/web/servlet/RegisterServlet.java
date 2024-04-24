package com.jiat.web.servlet;

import com.jiat.ejb.remote.Register;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @EJB(lookup = "com.jiat.ejb.remote.Register")
    private Register register;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        boolean log = register.register(name);
        response.getWriter().write("Register: "+log);
    }
}
