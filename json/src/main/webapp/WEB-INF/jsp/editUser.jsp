<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>


<div style="margin:0px auto; width:500px">


<form action="${pageContext.request.contextPath}/users/${user.id}" method="post">
    <input type="hidden" name="_method" value="PUT">
    username: <input name="username" value="${user.username}"> <br>
    password: <input name="password" value="${user.password}"> <br>
    phone: <input name="phone" value="${user.phone}"> <br>

<button type="submit">提交</button>

</form>
</div>