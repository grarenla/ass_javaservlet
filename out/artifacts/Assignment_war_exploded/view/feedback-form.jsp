<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Feedback" %><%--
  Created by IntelliJ IDEA.
  User: s2rai
  Date: 09-Apr-19
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Feedback feedback = (Feedback) request.getAttribute("feedback");
    if (feedback == null) {
        feedback = new Feedback();

    }
%>
<html>
<head>
    <title>Title</title>
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
    <%
        if (request.getAttribute("success") != null) {
    %>
    <div class="alert alert-success text-center" role="alert">
        <%= request.getAttribute("success")%>
    </div>
    <%
        }
    %>
    <form method="POST" action="/Assignment_war_exploded/feedback" class="form panel-body" role="form">
        <div class="form-group row">
            <label for="title" class="col-sm-2 col-form-label">Title</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="title" placeholder="Title" name="title"
                       value="<%= feedback.getTitle() != null ? feedback.getTitle() : ""%>">
            </div>
        </div>
        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                    <textarea class="form-control" id="description" placeholder="Description"
                              name="description" rows="15">
                    </textarea>
            </div>
        </div>

        <div class="form-group row">
            <div class="col align-self-start">

            </div>
            <div class="col align-self-center">
                <button class="btn btn-primary pull-right col-md-4" type="submit">Send</button>
            </div>
            <div class="col align-self-end">

            </div>
        </div>
    </form>


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
<script>
    $(document).ready(function () {
        var description = "<%= feedback.getDescription() != null ? feedback.getDescription() : "" %>";
        if (description !== "") {
            $('#description').val(description);
        } else {
            $('#description').val('');
        }
    });

</script>
</body>
</html>
