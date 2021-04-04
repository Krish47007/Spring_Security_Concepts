<%--
  Created by IntelliJ IDEA.
  User: krish
  Date: 29/03/21
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri= "http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Spring Security Demo App</title>
</head>
<body>

    <h1>Welcome to Spring security demo App!!!</h1>
    <hr />
    User : <security:authentication property="principal.username" />
    <br><br>
    Role(s) : <security:authentication property="principal.authorities" />
    <hr/>

    <!-- Added a link for managers-->

    <security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
    </p>
    <hr />
    </security:authorize>

    <!-- Added a link for Admins-->
    <security:authorize access="hasRole('ADMIN')">
        <p>
            <a href="${pageContext.request.contextPath}/systems">IT Systems meeting</a>
        </p>
        <hr />
    </security:authorize>

    <!-- Adding Logout support -->

    <form:form action="${pageContext.request.contextPath}/logout" method="post" >
        <input type="submit" value="Logout">
    </form:form>



</body>
</html>
