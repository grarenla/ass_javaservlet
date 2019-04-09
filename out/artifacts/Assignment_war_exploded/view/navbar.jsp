<%@ page import="entity.User" %><%
    HttpSession httpSession = request.getSession();
    User user = (User) httpSession.getAttribute("user");
    if (user == null) user = new User();
    String fullName = user.getFullName();
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/Assignment_war_exploded/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/Assignment_war_exploded/feedback">Send feedback <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/Assignment_war_exploded/manage">Manage<span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <%
            if (fullName == null) {
        %>
                <a class="btn btn-default my-2 my-lg-0" href="/Assignment_war_exploded/register">Register</a>
                <a class="btn btn-default my-2 my-lg-0" href="/Assignment_war_exploded/login">Login</a>
        <%
            } else {
        %>
                <a class="btn btn-default my-2 my-lg-0"><%= fullName%></a>
                <button class="btn btn-default" type="button" onclick="logout()">
                    Logout
                </button>
        <%
            }
        %>
    </div>
</nav>
<script>
    function logout() {
        var JSESSIONID = document.cookie;
        console.log(JSESSIONID);
        document.cookie = "JSESSIONID=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
    }
</script>