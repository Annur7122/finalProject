<%@ page import="bitlab.db.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bitlab.db.Comments" %><%--
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
       <h1>NEWS:</h1>
        <%
            News news = (News)request.getAttribute("news");
            if(news != null){
        %>
         <div style="background-color: rgb(236,236,236); min-height: 220px; margin-bottom: 20px; padding-left: 20px; padding-top: 20px; padding-bottom: 20px;">
             <h1> <%=news.getTitle()%> </h1>

             <h4> <%=news.getContent()%> </h4>

             <h5 style="margin-bottom: 20px;">The post date: <%=news.getPost_date()%></h5>

              <%
                  if(currentUser != null && currentUser.getRole_id().equals("1")){
              %>
         </div>

              <div>
                  <!-- Button trigger modal -->
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editNews" style="width: 120px; height: 40px; font-size: 18px; margin-top: 5px; margin-bottom: 20px;">
                      EDIT
                  </button>

                  <!-- Modal -->
                  <div class="modal fade" id="editNews" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                      <div class="modal-dialog">
                          <div class="modal-content">
                              <form action="/save-news" method="post">
                                  <input type="hidden" name="id_input" value="<%=news.getId()%>">
                                  <div class="modal-header">
                                      <h1 class="modal-title fs-5" id="staticBackdropLabel">Edit News</h1>
                                      <button type="button" class="btn-close" data-bs-dismiss="modal"
                                              aria-label="Close"></button>
                                  </div>
                                  <div class="modal-body">
                                      <div class="row">
                                          <div class="col-12">
                                              <label>
                                                  TITLE :
                                              </label>
                                          </div>
                                      </div>
                                      <div class="row mt-2">
                                          <div class="col-12">
                                              <input type="text" class="form-control" name="title_input" required
                                                     placeholder="Insert title:" value="<%=news.getTitle()%>">
                                          </div>
                                      </div>
                                      <div class="row mt-3">
                                          <div class="col-12">
                                              <label>
                                                  CONTENT :
                                              </label>
                                          </div>
                                      </div>
                                      <div class="row mt-2">
                                          <div class="col-12">
                                                <textarea class="form-control" name="content_input"
                                                          placeholder="Insert content:" required
                                                          rows="10"><%=news.getContent()%></textarea>
                                          </div>
                                      </div>
                                  </div>
                                  <div class="modal-footer">
                                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                                      </button>
                                      <button class="btn btn-success">Update</button>
                                  </div>
                              </form>

                          </div>
                      </div>
                  </div>

              </div>
              <%
                  }
              %>


         <%
             if (currentUser != null) {
         %>

         <div>
             <h2>Write your comments:</h2>
             <form action="/add-comment" method="post">
                 <input type="hidden" name="news_id_input" value="<%=news.getId()%>">
                 <div class="row">
                     <div class="col-12">
                         <textarea class="form-control" name="comment_input"></textarea>
                     </div>
                 </div>
                 <div class="row mt-3">
                     <div class="col-12">
                         <button class="btn btn-success btn-sm">ADD COMMENT</button>
                     </div>
                 </div>
             </form>
         </div>
         <%
             }
         %>


         <div class="row">
             <div class="col-12">
                 <%
                     ArrayList<Comments> comments = (ArrayList<Comments>) request.getAttribute("comments");

                     if (comments != null){
                         for(Comments comment : comments){
                 %>

                 <div class="list-group">
                     <a href="JavaScript:void(0)" class="list-group-item list-group-item-action">
                         <div class="d-flex w-100 justify-content-between">
                             <h5 class="mb-1"><%=comment.getUser().getFull_name()%></h5>
                             <small class="text-body-secondary"><%=comment.getPost_date()%></small>
                         </div>
                         <p class="mb-1"><%=comment.getComment()%></p>
                     </a>

                 </div>

                 <%
                         }
                     }else{
                 %>
                    <h1>No comments yet</h1>
                 <%
                     }
                 %>
             </div>
         </div>

       <%
         }else{
       %>
        <h3>No news yet</h3>
       <%
         }
       %>
     </div>
</body>
</html>
