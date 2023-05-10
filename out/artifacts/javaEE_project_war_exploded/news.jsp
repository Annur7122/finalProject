<%@ page import="bitlab.db.News" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 09.05.2023
  Time: 13:14
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
         <h1>Breaking News! </h1>
         <br>
        <%
            ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
            if(news != null){
            for(News n : news){
        %>
          <div style="background-color: rgb(236,236,236); min-height: 220px; margin-bottom: 20px; padding-left: 20px; padding-top: 20px">
              <a href="/news-details?id=<%=n.getId()%>" style="color: rgba(0,0,0,0.97); text-decoration: none;">
                  <h1> <%=n.getTitle()%> </h1>
              </a>

            <h4> <%=n.getContent()%> </h4>

            <h5 style="margin-bottom: 20px;">The post date: <%=n.getPost_date()%></h5>

          </div>
       <%
           }
         }else{
       %>
        <h3>No news yet</h3>
       <%
         }
       %>
     </div>
</body>
</html>
