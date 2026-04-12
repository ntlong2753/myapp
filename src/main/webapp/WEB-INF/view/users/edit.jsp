<%@ page import="com.codegym.myapp.entities.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ntlong
  Date: 12/04/2026
  Time: 07:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  User userEdit = (User) request.getAttribute("user");
%>
<html>
<head>
  <title>Edit User</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <%@include file="../layout/header.jsp" %>

  <div class="col-md-6 mx-auto mt-4">
    <h2 class="text-center mb-4">Edit User</h2>

    <form action="/users/edit?id=<%=userEdit.getId()%>" method="post">
      <div class="mb-3">
        <label class="form-label">Name</label>
        <input value="<%=userEdit.getName()%>" type="text" name="name" class="form-control">
      </div>
      <div class="mb-3">
        <label class="form-label">Email</label>
        <input value="<%=userEdit.getEmail()%>" type="email" name="email" class="form-control" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Phone</label>
        <input value="<%=userEdit.getPhone()%>" type="text" name="phone" class="form-control">
      </div>

      <div class="mb-3">
        <label class="form-label">Address</label>
        <input value="<%=userEdit.getAddress()%>" type="text" name="address" class="form-control">
      </div>

      <div class="d-flex justify-content-between">
        <a href="/users/" class="btn btn-secondary">Back</a>
        <button type="submit" class="btn btn-success">Update</button>
      </div>

    </form>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>