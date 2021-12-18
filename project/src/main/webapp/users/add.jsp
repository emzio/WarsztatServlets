<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 14.12.2021
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Add</title>
    <%@ include file="/users/header.jsp" %>

    <div class="container-fluid">

        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Users Crud</h1>
            <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                    class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników </a>
        </div>
    </div>

<div class="card">
    <div class="container-fluid">
        <h3 class="m-2 font-weight-bolder text-info ">Dodaj użytkownika</h3>
<%--        wstawka--%>
        <h2 class="m-2 font-weight-bolder text-danger"><c:if test="${not empty error}">
            Podany email już istnieje!
        </c:if></h2>
        <%--    wstawka--%>
    </div>


    <div class="m-2 container-fluid">
        <form action="/user/add" method="post">
            <div class="form-group">
                    <label for="username">User Name</label>
                    <input  class="form-control" id="username" name="username" type="text" placeholder="User Name"/>
            </div>
            <div class="form-group">
                    <label for="email">Email</label>
                    <input class="form-control" id="email" name="email" type="email" placeholder="Email"/>
            </div>
            <div class="form-group">
                    <label for="password">Password</label>
                    <input class="form-control" id="password" name="password" type="password" placeholder="Password"/>
            </div>
            <div class="form-check">
                <input type="submit" value="Dodaj Użytkownika" />
            </div>
        </form>
    </div>
</div>

    <%@ include file="/users/footer.jsp" %>
