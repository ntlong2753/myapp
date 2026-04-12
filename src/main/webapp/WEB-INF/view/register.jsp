<%--
  Created by IntelliJ IDEA.
  User: ntlong
  Date: 12/04/2026
  Time: 01:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <h2 class="text-center" style="margin-top: 30px;">Register</h2>
  <form action="/register" method="post" class="form-signin" style="max-width: 400px; margin: 0 auto;">

    <div class="mb-3">
      <label for="username" class="form-label">Username</label>
      <input type="text" class="form-control" id="username" name="username" required>
    </div>

    <div class="mb-3">
      <label for="email" class="form-label">Email</label>
      <input type="email" class="form-control" id="email" name="email" required>
    </div>

    <div class="mb-3">
      <label for="password" class="form-label">Password</label>
      <input type="password" class="form-control" id="password" name="password" required>
    </div>

    <div class="mb-3">
      <label for="confirm_password" class="form-label">Confirm Password</label>
      <input type="password" class="form-control" id="confirm_password" name="confirm_password" required>
    </div>

    <button class="btn btn-primary w-100" type="submit">Register</button>

    <div class="text-center mt-3">
      <a href="/auth/login">Already have an account? Login</a>
    </div>

  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</body>
</html>
