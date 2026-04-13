package com.codegym.myapp.models;

import com.codegym.myapp.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserModel {
    private Connection connect;
    public UserModel(Connection connect) {
        this.connect = connect;
    }

    public ResultSet getAll() throws SQLException {
        String sql = "SELECT * FROM user";
        Statement statement = connect.prepareStatement(sql);
        return statement.executeQuery(sql);
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = " + id;
        Statement statement = connect.prepareStatement(sql);
        statement.executeUpdate(sql);
    }

    public User update(User user) throws SQLException {
        String sql = "UPDATE user SET name = ?, email = ?, phone = ?, address = ? WHERE id = ?";
        Statement statement = connect.prepareStatement(sql);
        return null;
    }

    public ResultSet getById(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = " + id;
        Statement statement = connect.prepareStatement(sql);
        return statement.executeQuery(sql);
    }

    public void updateById(int id, String name, String email, String phone, String address, String username, String password) throws SQLException {
        String sql = "UPDATE user SET " +
                "name = '" + name + "', " +
                "email = '" + email + "', " +
                "phone = '" + phone + "', " +
                "address = '" + address + "' " +
                "WHERE id = " + id;

        Statement statement = connect.prepareStatement(sql);
        statement.executeUpdate(sql);
    }

    public void create(String name, String email, String phone, String address, String username, String password) throws SQLException {
        String sql = "INSERT INTO user (name, email, phone, address, username, password) VALUES (" +
                "'" + name + "', " +
                "'" + email + "', " +
                "'" + phone + "', " +
                "'" + address + "', " +
                "'" + username + "', " +
                "'" + password + "')";

        Statement statement = connect.prepareStatement(sql);
        statement.executeUpdate(sql);
    }

    public ResultSet search(String keyword) throws SQLException {
        String sql = "SELECT * FROM user WHERE username LIKE '%" + keyword + "%'";
        Statement statement = connect.prepareStatement(sql);
        return statement.executeQuery(sql);
    }

}
