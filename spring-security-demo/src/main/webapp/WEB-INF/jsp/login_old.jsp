<%--
  Created by IntelliJ IDEA.
  User: krish
  Date: 01/04/21
  Time: 7:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>My_APP</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

    <h3>Custom Login Page</h3>

    <form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">

        <!-- Check for login error -->
        <c:if test="${param.error != null}">    <!--This error parameter is sent by Spring security in case login fails -->
            <i class="error">Invalid username/password...please try again</i>
        </c:if>
        <p>
            User Name : <input type="text" name="username" /> <!-- Spring security will read these default field names to authenticate the user-->
        </p>
        <p>
            Password  : <input type="password" name="password" />
        </p>
         <p>
             <input type="submit" value="Login">
         </p>

    </form:form>

</body>
</html>
