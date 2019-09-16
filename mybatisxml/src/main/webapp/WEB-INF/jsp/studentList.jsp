<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>type</td>
        <td>wish</td>
    </tr>
    <c:forEach items="${studentList}" var="student" varStatus="st">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.type}</td>
            <td>${student.wish}</td>
        </tr>
    </c:forEach>
</table>
