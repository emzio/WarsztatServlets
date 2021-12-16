<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 14.12.2021
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <%@ include file="/users/header.jsp" %>

    <div class="container-fluid">

        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Users Crud</h1>
            <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                    class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników </a>
        </div>

        <div class="row">
            <div class="card py-3">
                <form action="" method="post">


                    <div class="form-check">
<%--                    <div class="col-2">--%>
<%--                                            <fieldset>--%>
                        <label for="username">User Name</label>
                        <input id="username" name="username" type="text" placeholder="User Name"/>
<%--                                            </fieldset>--%>
                    </div>
                    <div class="form-check">
                        <%--                    <fieldset>--%>
                        <label for="email">Email</label>
                        <input id="email" name="email" type="email" placeholder="Email"/>
                        <%--                    </fieldset>--%>
                    </div>
                    <div class="form-check">
                        <%--                    <fieldset>--%>
                        <label for="password">Password</label>
                        <input id="password" name="password" type="password" placeholder="Password"/>
                        <%--                    </fieldset>--%>
                    </div>
                    <div class="form-check">
                        <input type="submit" value="Dodaj Użytkownika" />
                    </div>

                </form>
            </div>
<%--    </div>--%>

    <%@ include file="/users/footer.jsp" %>
</body>
</html>
