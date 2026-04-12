package com.codegym.myapp.controllers;

import com.codegym.myapp.services.AuthServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "authServlet", urlPatterns = "/auth/*")
public class AuthServlet extends HttpServlet {
    private AuthServices authServices;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(request, response);
        String pathInfo = request.getPathInfo();
        System.out.println(pathInfo);

        if (pathInfo == null) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/login":
                authServices.renderPageLogin(request, response);
                break;
            case "/register":
                authServices.renderPageRegister(request, response);
                break;
            default:
                response.sendRedirect("/auth/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        System.out.println(pathInfo);

        if (pathInfo == null) {
            pathInfo = "/";
        }
        switch (pathInfo) {
            case "/login":
                authServices.handleLogin(request, response);
                break;
        }
    }
}
