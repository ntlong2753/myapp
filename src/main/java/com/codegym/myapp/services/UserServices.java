package com.codegym.myapp.services;

import com.codegym.myapp.entities.User;
import com.codegym.myapp.models.Database;
import com.codegym.myapp.models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServices {
    private static final UserModel userModel = new UserModel(Database.getConnection());

    public UserServices() {

    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        // 1. Xóa sạch cái list cũ trong RAM đi trước khi nạp dữ liệu mới từ DB
        users.clear();

        ResultSet resultSet = userModel.getAll();
        while (resultSet.next()) {
            User user = new User();

            // 2. PHẢI lấy dữ liệu từ resultSet nạp vào đối tượng user
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPhone(resultSet.getString("phone"));
            user.setAddress(resultSet.getString("address"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));

            // 3. Sau đó mới add vào list
            users.add(user);
        }
        return users;
    }

    public static void renderPageListUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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
            throws ServletException, IOException, SQLException {

        User newUser = new User();

        currentId++;
        newUser.setId(currentId);

        newUser.setName(request.getParameter("name"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setPhone(request.getParameter("phone"));
        newUser.setAddress(request.getParameter("address"));
        newUser.setUsername(request.getParameter("username"));
        newUser.setPassword(request.getParameter("password"));

        userModel.create(
                newUser.getName(),
                newUser.getEmail(),
                newUser.getPhone(),
                newUser.getAddress(),
                newUser.getUsername(),
                newUser.getPassword()
        );

        response.sendRedirect("/users");
    }

    public static void deleteUserById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        userModel.deleteById(Integer.parseInt(id));
        response.sendRedirect("/users");
    }

    public static void renderFormEditUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String id = request.getParameter("id");
        // tim user trong db
        ResultSet resultSet = userModel.getById(Integer.parseInt(id));

        if (resultSet != null) {
            User userEdit = null;
            while (resultSet.next()) {
                userEdit = new User();
                userEdit.setId(resultSet.getInt("id"));
                userEdit.setName(resultSet.getString("name"));
                userEdit.setEmail(resultSet.getString("email"));
                userEdit.setPhone(resultSet.getString("phone"));
                userEdit.setAddress(resultSet.getString("address"));
                userEdit.setUsername(resultSet.getString("username"));
                userEdit.setPassword(resultSet.getString("password"));
            }
            request.setAttribute("user", userEdit);
            request.getRequestDispatcher("/WEB-INF/view/users/edit.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/view/error/404.jsp").forward(request, response);
        }
    }

    public static void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        String _name = request.getParameter("name");
        String _email = request.getParameter("email");
        String _phone = request.getParameter("phone");
        String _address = request.getParameter("address");
        String _username = request.getParameter("username");
        String _password = request.getParameter("password");

        // tim user trong db
        ResultSet resultSet = userModel.getById(Integer.parseInt(id));
        User userUpdate = null;

        if (resultSet != null) {
            userModel.updateById(Integer.parseInt(id), _name, _email, _phone, _address, _username, _password);
            response.sendRedirect("/users");
        } else {
            request.getRequestDispatcher("/WEB-INF/view/error/404.jsp").forward(request, response);
        }
    }

    public static void searchUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String keyword = request.getParameter("keyword");

        List<User> result = new ArrayList<>();

        ResultSet resultSet = userModel.search(keyword);

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPhone(resultSet.getString("phone"));
            user.setAddress(resultSet.getString("address"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));

            result.add(user);
        }
        System.out.println(result.size());
        request.setAttribute("users", result);
        request.getRequestDispatcher("/WEB-INF/view/users/list.jsp").forward(request, response);
    }

}
