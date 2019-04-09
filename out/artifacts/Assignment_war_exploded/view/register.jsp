<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: s2rai
  Date: 08-Apr-19
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    User user = (User) request.getAttribute("user");
    if (user == null) {
        user = new User();

    }
%>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<style>
    #error_explanation {
        color: #f00;
    }

    ul {
        list-style: none;
        margin: 0 0 18px 0;
    }
</style>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <div id="error_explanation">
        <ul>
            <%
                for (String key : errors.keySet()) {
                    ArrayList<String> messages = errors.get(key);
                    for (String mess : messages) {

            %>
            <li><%= mess%>
            </li>
            <%
                    }
                }
            %>
        </ul>
    </div>

    <form method="post" action="/Assignment_war_exploded/register">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username"
                   value="<%= user.getUsername() != null ? user.getUsername() : ""%>"
                   placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password"
                   placeholder="Password">
        </div>
        <div class="form-group">
            <label for="fullName">Fullname</label>
            <input type="text" class="form-control" id="fullName" name="fullName"
                   value="<%= user.getFullName() != null ? user.getFullName() : ""%>"
                   placeholder="Enter fullname">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <%--</div>--%>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
