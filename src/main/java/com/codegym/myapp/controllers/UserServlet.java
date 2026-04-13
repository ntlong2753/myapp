package com.codegym.myapp.controllers;

import com.codegym.myapp.models.Database;
import com.codegym.myapp.services.UserServices;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "userServlet", urlPatterns = "/users/*")
public class UserServlet extends HttpServlet {
    private UserServices userServices;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        System.out.println(pathInfo);

        if (pathInfo == null) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/":
                try {
                    userServices.renderPageListUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/create":
                userServices.renderFormCreateUser(request, response);
                break;
            case "/delete":
                try {
                    userServices.deleteUserById(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "/edit":
                try {
                    userServices.renderFormEditUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/search":
                try {
                    userServices.searchUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        System.out.println(pathInfo);

        if (pathInfo == null) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/create":
                try {
                    userServices.createUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/edit":
                try {
                    userServices.updateUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

}
