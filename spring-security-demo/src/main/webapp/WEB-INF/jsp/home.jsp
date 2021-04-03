<%--
  Created by IntelliJ IDEA.
  User: krish
  Date: 29/03/21
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring Security Demo App</title>
</head>
<body>

    <h1>Welcome to Spring security demo App!!!</h1>
    <hr />

    <!-- Adding Logout support -->

    <form:form action="${pageContext.request.contextPath}/logout" method="post" >
        <input type="submit" value="Logout">
    </form:form>



</body>
</html>
