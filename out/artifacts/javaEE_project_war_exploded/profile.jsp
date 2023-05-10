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

    <div style="width: 95%; height: 245px; margin: auto; box-shadow: 3px 3px 20px black; padding-top: 30px;">
         <h1 style="text-align: center">Welcome to BITLAB News <%=currentUser!=null?currentUser.getFull_name():""%></h1>

        <div style="margin: auto;">
            <!-- Button trigger modal -->

                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editUser" style="width: 170px; height: 50px; margin-left: 415px; margin-top: 20px; font-size: 20px;" >
                    EDIT PROFILE
                </button>



            <!-- Modal -->
            <div class="modal fade" id="editUser" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/save-user" method="post">
                            <%--                        <input type="hidden" name="id_input" value="<%=news.getId()%>">--%>
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Edit News</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-12">
                                        <label>
                                            Name :
                                        </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="text" class="form-control" name="full_name_input" required
                                               placeholder="Insert title:" value="<%=currentUser.getFull_name()%>">
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-12">
                                        <label>
                                            Password :
                                        </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="text" class="form-control" name="password_input" required
                                               placeholder="Insert title:" value="<%=currentUser.getPassword()%>">
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
    </div>





</div>
