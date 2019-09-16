<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>phone</td>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="st">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
</table>
