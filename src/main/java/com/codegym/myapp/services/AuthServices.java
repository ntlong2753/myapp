package com.codegym.myapp.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthServices {

    public AuthServices() {

    }

    public static void renderPageRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
    }

    public static void renderPageLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ktra request co error hay khong
        String error = request.getParameter("error");
        if ("true".equals(error)) {
            // truyen thong diep lai cho jsp
            request.setAttribute("errorMessage", "Invalid username or password.");
        }
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    public static void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // xu ly du lieu tu form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // xu ly dang nhap
        if ("admin".equals(username) && "admin".equals(password)) {
            // chuyen huong ve trang chu
            response.sendRedirect("/home");
        } else {
            response.sendRedirect("/auth/login?error=true");
        }
    }
}
