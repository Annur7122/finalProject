<%@ page import="java.util.ArrayList" %>
<%@ page import="bitlab.db.Users" %><%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 25.04.2023
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="link.jsp"%>

</head>
<body>

<%@include file="navbar.jsp"%>

<div style="width: 70%; margin:auto;">

    <div style="width: 95%; height: 345px; margin: auto; box-shadow: 3px 3px 20px black;">
        <div style="background-color: lightgray; height: 50px;padding-top: 10px; padding-left: 20px"><h4 style="font-weight: normal;">Login Page</h4></div>
        <div style="width: 100%;">
            <%
                String emailerror = request.getParameter("error");

                if(emailerror != null){
            %>
            <div style="background-color: #ff9fb4; width: 100%; height: 50px; padding-left: 20px; padding-top: 12px; margin: auto;">
                <p style="color: #ff4c85">Incorrect <span style="color: #ff1b3e ">email</span></span>!</p>
            </div>
            <%
                }
            %>


            <form action="/login" method="post">
                <table style="width: 100%; margin-left: 20px; line-height: 10px;">
                    <tr style="width: 160px; ">
                        <td style="width:10%; font-size: 22px;">Email</td>
                        <td style="padding-top: 10px;"><input name="email_input" style="width: 80%; height: 35px; border: 0.5px solid lightgray;"><br></td>
                    </tr>
                    <br>
                    <tr style="width: 160px;  padding: 50px;">
                        <td style="width:10%; padding-top: 20px; font-size: 22px; ">Password</td>
                        <td style="padding-top: 20px;"><input  type="password" name="password_input" style="width: 80%; height: 35px; border: 0.5px solid lightgray; "></td>
                    </tr>
                </table>
                <br>
                <button style="border: none; width:20%; height:45px; margin-left: 20px; margin-top: 20px; background-color: green;color:white; font-size: 25px;">Login</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>
