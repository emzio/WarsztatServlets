<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 15.12.2021
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
    <%@ include file="/users/header.jsp" %>

    <div class="container-fluid">

        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Users Crud</h1>
            <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                    class="fas fa-download fa-sm text-white-50"></i> Lista Użytkowników</a>
        </div>
<%--        <div class="d-sm-flex align-items-center justify-content-between mb-4">--%>
<%--            <h2 class="h3 mb-0 text-gray-800">Sczegóły użytkownika</h2>--%>
<%--        </div>--%>
        <div class="row">

<%--            <br>--%>
    <div class="card py-3">

        <h3 class=" m-2 font-weight-bolder text-info">Sczegóły użytkownika</h3>
        <h5 class="m-2">
        <table class="table-striped tbody tr:nth-of-type(odd)">
            <tr>
            <tr>
                <td><h5 class="m-2 text-info">Id</h5> </td>
            <td><h5 class="m-2">${user.id}</h5></td>
            </tr>
            <tr>
                <td><h5 class="m-2 text-info">User name</h5> </td>
                <td><h5 class="m-2">${user.username}</h5></td>
            </tr>
            <tr>
                <td><h5 class="m-2 text-info">User email</h5> </td>
                <td><h5 class="m-2">${user.email}</h5></td>
            </tr>
            <tr>
                <td><h5 class="m-2 text-info">User password </h5></td>
                <td><h5 class="m-2">${user.password}</h5></td>
            </tr>
            </tr>
        </table>
        </h5>
    </div>




    <%@ include file="/users/footer.jsp" %>
</body>
</html>
