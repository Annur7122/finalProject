<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 09.05.2023
  Time: 12:39
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

        <div style="width: 95%; height: 355px; margin: auto; box-shadow: 3px 3px 20px black;">
            <div style="background-color: lightgray; height: 50px;padding-top: 10px; padding-left: 20px"><h4 style="font-weight: normal;">Add News</h4></div>
            <div style="width: 100%;">

                <form action="/add-news" method="post">
                    <table style="width: 100%; margin-left: 20px; line-height: 10px;">
                        <tr style="width: 160px; ">
                            <td style="width:10%; font-size: 22px;">TITLE:</td>
                            <td style="padding-top: 10px;"><input name="title_input" placeholder="Insert title" style="width: 80%; height: 35px; border: 0.5px solid lightgray;"><br></td>
                        </tr>
                        <br>
                        <tr style="width: 160px;  padding: 50px;">
                            <td style="width:10%; padding-top: 20px; font-size: 22px; ">Content</td>
                            <td style="padding-top: 20px;"><textarea name="content_input" placeholder="Insert content: " rows="10" required style="border: 0.5px solid lightgray; width: 80%; "></textarea></td>
                        </tr>
                    </table>
                    <br>
                    <button style="border: none; width:20%; height:45px; margin-left: 20px; margin-top: 20px; background-color: green;color:white; font-size: 25px;">Add Post</button>
                </form>
            </div>
        </div>

    </div>

</body>
</html>
