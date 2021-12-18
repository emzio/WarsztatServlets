<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 15.12.2021
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Edit</title>
</head>
<%@ include file="/users/header.jsp" %>

    <div class="container-fluid">

        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Users Crud</h1>
            <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników </a>
        </div>



            <div class="card">
                <div class="card-header">
                    <h3 class=" m-2 font-weight-bolder text-info">Edytowanie użytkownika</h3>
                </div>
                <div class="card-body">
                    <form action="/user/edit?id=${user.id}" method="post">
                        <div class="form-group">
                            <fieldset>
                                <label for="username">Username</label>
                                <input class="form-control" id="username" name="username" type="text" placeholder="${user.username}" />
                            </fieldset>
                        </div>
                        <div class="form-group">
                            <fieldset>
                                <label for="email">Email</label >
                                <input class="form-control" id="email" name="email" type="email" placeholder="${user.email}" />
                            </fieldset>
                        </div>
                        <div class="form-group">
                            <fieldset>
                                <label for="password">Password</label>
                                <input class="form-control" id="password" name="password" type="password" placeholder="Hasło użytkownika" />
                            </fieldset>
                        </div>
                        <input type="submit" value="Edytuj Użytkownika" />
                    </form>
                </div>

            </div>
        </div>
    <%@ include file="/users/footer.jsp" %>
