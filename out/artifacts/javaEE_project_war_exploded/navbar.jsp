<%@ page import="bitlab.db.Users" %><%
   Users currentUser = (Users) session.getAttribute("currentUser");
%>
<nav class="navbar navbar-expand-lg" style="background-color: green; padding: 10px; margin-bottom: 50px;">
    <div class="container-fluid">
        <a class="navbar-brand" href="/login" style="color: white; font-size: 24px;">BITLAB News
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/news" style="color: white; font-size: 20px;">All News</a>
                </li>
                <%if(currentUser != null && currentUser.getRole_id().equals("1")){%>
                <li class="nav-item">
                    <a class="nav-link" href="/add-news-page" style="color: white; font-size: 20px;">Add News</a>
                </li>
                <%}%>

                <%if(currentUser != null){%>
                    <li class="nav-item dropdown">

                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: white; font-size: 20px;">
                            <%=currentUser.getFull_name()%>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/profile" style="color: #000000; font-size: 16px;">Profile</a></li>
                            <li><a class="dropdown-item" href="#" style="color: black; font-size: 16px;">Settings</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="/logout" style="color: black; font-size: 16px;">Logout</a></li>
                        </ul>
                    </li>
                <%
                    }else{
                %>
                    <li>
                        <a class="nav-link" href="/login" style="color: white; font-size: 20px;">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/registration" style="color: white; font-size: 20px;">Registration</a>
                    </li>
                <%
                    }
                %>


            </ul>
        </div>
    </div>
</nav>




<%--<div style="border-bottom: 1px solid black; display: flex; justify-content: space-between">--%>
<%--    <a style="font-size: 35px; font-weight: bold; color: black; text-decoration: none;" href="/home.html ">BITLAB NEWS</a>--%>
<%--    <div style="display: flex; justify-content: space-around">--%>
<%--        <a style="margin-left:25px; margin-top: 15px; text-decoration: none; color: black;" href="">Top Sales</a>--%>
<%--        <a style="margin-left:25px; margin-top: 15px; text-decoration: none; color: black;" href="">New Sales</a>--%>
<%--        <a style="margin-left:25px; margin-top: 15px; text-decoration: none; color: black;" href="">By Category</a>--%>
<%--        <a style="margin-left:25px; margin-top: 15px; text-decoration: none; color: black;" href="">Sign In</a>--%>
<%--    </div>--%>
<%--</div>--%>