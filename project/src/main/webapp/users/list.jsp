<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 13.12.2021
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>List</title>--%>
<%--</head>--%>

<body>
    <%@ include file="/users/header.jsp" %>
    <!-- Page Heading -->
    <div class="container-fluid">

        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Users Crud</h1>
            <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Dodaj Użytkownika </a>
        </div>

            <h3 class="m-2 font-weight-bolder text-info">Lista Użytkowników</h3>

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
                        <th colspan="3">
                            <div display:block>Action</div>
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
                    <hr class="sidebar-divider">
                    <hr class="sidebar-divider">
                </div>
            </h2>
    </div>

            <%@ include file="/users/footer.jsp" %>
</body>
<%--</html>--%>
