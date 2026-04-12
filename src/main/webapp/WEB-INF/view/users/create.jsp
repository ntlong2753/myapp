<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create User</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <%@include file="../layout/header.jsp" %>

  <div class="col-md-6 mx-auto mt-4">
    <h2 class="text-center mb-4">Create User</h2>

    <form action="/users/create" method="post">

      <div class="mb-3">
        <label class="form-label">Username</label>
        <input type="text" name="username" class="form-control" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="password" name="password" class="form-control" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Name</label>
        <input type="text" name="name" class="form-control" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Email</label>
        <input type="email" name="email" class="form-control" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Phone</label>
        <input type="text" name="phone" class="form-control">
      </div>

      <div class="mb-3">
        <label class="form-label">Address</label>
        <input type="text" name="address" class="form-control">
      </div>

      <div class="d-flex justify-content-between">
        <a href="/users/" class="btn btn-secondary">Back</a>
        <button type="submit" class="btn btn-success">Create</button>
      </div>

    </form>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>