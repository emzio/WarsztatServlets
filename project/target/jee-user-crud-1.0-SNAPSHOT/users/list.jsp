<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 13.12.2021
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <%@ include file="/users/header.jsp" %>
    <!-- Page Heading -->
    <div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Users Crud</h1>
        <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj Użytkownika </a>
    </div>
    <div>
        <div class="h2 mb-0 font-weight-bold text-gray-800">Lista Użytkowników</div>

    </div>

    <%--<div class="card py-3">--%>

    <%--    <h6 class="m-0 font-weight-bold text-primary">Lista użytkowników</h6>--%>

    <%--</div>--%>
    <!-- Content Row -->
    <div class="row">





        <%--    <div class="col-xl-3 col-md-6 mb-4">`---%>
        <%--        <div class="card border-left-primary shadow h-100 py-2">`--%>
        <%--            <div class="card-body">`--%>
        <%--                <div class="row no-gutters align-items-center">`--%>
        <%--                    <div class="col mr-2">`---%>
        <%--                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">--%>
        <%--                            mój tekst </div>--%>
        <%--                        <div class="h5 mb-0 font-weight-bold text-gray-800">inny</div>--%>
        <%--                    </div>--%>
        <%--                    <div class="col-auto">--%>
        <%--                        <i class="fas fa-calendar fa-2x text-gray-300"></i>--%>
        <%--                    </div>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <%--    </div>--%>
        <h2>
            <div>
                <table class="table">
                    <th>
                        Id
                    </th>
                    <th>
                        User Name
                    </th>
                    <th>
                        Email
                    </th>
                    <th>
                        Password
                    </th>
                    <th>
                        action
                    </th>
                    <th>

                    </th>
                    <th>

                    </th>
                    <hr class="sidebar-divider">
                    <c:forEach items="${users}" var="user">

                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.password}</td>

                            <td> <a href="/user/edit?id=${user.id}" > edit </a> </td>
                            <td> <a href="/user/show?id=${user.id}" > show </a> </td>
                            <td> <a href="/user/delete?id=${user.id}" > delete </a> </td>

                        </tr>
                    </c:forEach>
                </table>

            </div>
        </h2>
    <%@ include file="/users/footer.jsp" %>
</body>
</html>
