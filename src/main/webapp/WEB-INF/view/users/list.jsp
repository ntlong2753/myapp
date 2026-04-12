<%@ page import="com.codegym.myapp.entities.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ntlong
  Date: 12/04/2026
  Time: 03:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<User> users = (List<User>) request.getAttribute("users");
%>
<html>
<head>
  <title>List Users</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body>
  <div class="container mt-5">
    <%@include file="../layout/header.jsp" %>
    <div class="col-10 mx-auto">
      <h2 class="text-center mb-4">User List</h2>
        <div class="d-flex justify-content-between align-items-center mb-3">
          <a href="/users/create" class="btn btn-success">Create</a>

          <form action="/users/search" method="get" class="m-0">
            <div class="input-group" style="width: 300px;">
              <input type="text" name="keyword" class="form-control" placeholder="Tìm kiếm...">
              <button class="btn btn-primary" type="submit">Search</button>
            </div>
          </form>
        </div>
      <table class="table table-bordered table-hover align-middle">
        <thead class="table-dark">
        <tr class="text-center">
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Address</th>
          <th>Username</th>
          <th>Password</th>
          <th style="width: 1%; white-space: nowrap;">Action</th>
        </tr>
        </thead>

        <tbody>
        <% for (User user : users) { %>
        <tr>
          <td class="text-center"><%=user.getId()%></td>
          <td><%=user.getName()%></td>
          <td><%=user.getEmail()%></td>
          <td class="text-center"><%=user.getPhone()%></td>
          <td><%=user.getAddress()%></td>
          <td><%=user.getUsername()%></td>
          <td><%=user.getPassword()%></td>
          <td>
            <div class="d-flex justify-content-center gap-2">
              <a href="/users/edit?id=<%=user.getId()%>" class="btn btn-primary btn-sm">Edit</a>
              <a onclick="return confirm('Are you sure ???')" href="/users/delete?id=<%=user.getId()%>" class="btn btn-danger btn-sm">Delete</a>
            </div>
          </td>
        </tr>
        <% } %>
        </tbody>
      </table>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</body>
</html>
