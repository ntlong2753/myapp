package com.codegym.myapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "authServlet", urlPatterns = "/auth/*")
public class AuthServlet extends HttpServlet {
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
                renderPageLogin(request, response);
                break;
            case "/register":
                renderPageRegister(request, response);
                break;
            default:
                response.sendRedirect("/auth/login");
        }

    }

    private static void renderPageRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
    }

    private static void renderPageLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ktra request co error hay khong
        String error = request.getParameter("error");
        if ("true".equals(error)) {
            // truyen thong diep lai cho jsp
            request.setAttribute("errorMessage", "Invalid username or password.");
        }
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
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
                handleLogin(request, response);
                break;
        }
    }

    private static void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
