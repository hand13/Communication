<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hd110
  Date: 2017/9/1
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
    <form method="post" action="loginCheck.html">
      <label for="username" title="username">username:</label>
      <input type="text" id="username" name="username"/>
      <label for="password" title="password">password:</label>
      <input type="password" id="password" name="password"/>
      <input type="submit" value="submit"/>
    </form>
  <a href="rregiest.html">zuce</a>
    <c:if test="${!empty error}">
      <font color="red"><c:out value="${error}"/></font>
    </c:if>
  </body>
</html>
