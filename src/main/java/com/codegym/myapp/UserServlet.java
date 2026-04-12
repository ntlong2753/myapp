package com.codegym.myapp;

import com.codegym.myapp.services.UserServices;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userServlet", urlPatterns = "/users/*")
public class UserServlet extends HttpServlet {
    private UserServices userServices;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userServices = new UserServices();
        userServices.initData();

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
                userServices.renderPageListUser(request, response);
                break;
            case "/create":
                userServices.renderFormCreateUser(request, response);
                break;
            case "/delete":
                userServices.deleteUserById(request, response);
                break;

            case "/edit":
                userServices.renderFormEditUser(request, response);
                break;
            case "/search":
                userServices.searchUser(request, response);
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
                userServices.createUser(request, response);
                break;
            case "/edit":
                userServices.updateUser(request, response);
                break;
        }
    }

}
