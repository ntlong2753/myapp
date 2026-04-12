package com.codegym.myapp.services;

import com.codegym.myapp.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServices {
    private static List<User> users = new ArrayList<>();

    public UserServices() {

    }

    public void initData() {
        users.add(new User(1, "Jayce", "jayce@gmail.com", "0123456789", "001 Top lane", "jayce", "123"));
        users.add(new User(2, "Wukong", "wukong@gmail.com", "0987654321", "002 Jungle", "wukong", "123"));
        users.add(new User(3, "Sylas", "sylas@gmail.com", "0432167890", "003 Mid lane", "sylas", "123"));
        users.add(new User(4, "Lucian", "lucian@gmail.com", "0276543890", "004 Bot lane adc", "lucian", "123"));
        users.add(new User(5, "Senna", "senna@gmail.com", "0314567890", "005 Bot lane support", "senna", "123"));
    }

    public static List<User> getAllUsers() {
        return users;
    }

    public static void renderPageListUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // truyen list user vao request
        List<User> users = UserServices.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/view/users/list.jsp").forward(request, response);
    }

    public static void renderFormCreateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/users/create.jsp").forward(request, response);
    }

    private static int currentId = 5;

    public static void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User newUser = new User();

        currentId++;
        newUser.setId(currentId);

        newUser.setName(request.getParameter("name"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setPhone(request.getParameter("phone"));
        newUser.setAddress(request.getParameter("address"));
        newUser.setUsername(request.getParameter("username"));
        newUser.setPassword(request.getParameter("password"));

        users.add(newUser);

        response.sendRedirect("/users");
    }

    public static void deleteUserById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        // tim user theo id
        User userDelete = null;
        for (User user : users) {
            if (String.valueOf(user.getId()).equals(id)) {
                userDelete = user;
                break;
            }
        }
        // xoa user neu tim thay
        if (userDelete != null) {
            users.remove(userDelete);
            response.sendRedirect("/users");
        } else {
            response.sendRedirect("/users");
        }
    }

    public static void renderFormEditUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        User userEdit = null;
        for (User user : users) {
            if (String.valueOf(user.getId()).equals(id)) {
                userEdit = user;
                break;
            }
        }

        if (userEdit != null) {
            request.setAttribute("user", userEdit);
            request.getRequestDispatcher("/WEB-INF/view/users/edit.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/view/error/404.jsp").forward(request, response);
        }
    }

    public static void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String _name = request.getParameter("name");
        String _email = request.getParameter("email");
        String _phone = request.getParameter("phone");
        String _address = request.getParameter("address");
        String _username = request.getParameter("username");
        String _password = request.getParameter("password");

        User userUpdate = null;
        for (User user : users) {
            if (String.valueOf(user.getId()).equals(id)) {
                userUpdate = user;
                break;
            }
        }

        if (userUpdate != null) {
            userUpdate.setName(_name);
            userUpdate.setEmail(_email);
            userUpdate.setPhone(_phone);
            userUpdate.setAddress(_address);
            response.sendRedirect("/users");
        } else {
            request.getRequestDispatcher("/WEB-INF/view/error/404.jsp").forward(request, response);
        }
    }

    public static void searchUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (user.getUsername().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(user);
            }
        }
        System.out.println(result.size());
        request.setAttribute("users", result);
        request.getRequestDispatcher("/WEB-INF/view/users/list.jsp").forward(request, response);
    }

}
