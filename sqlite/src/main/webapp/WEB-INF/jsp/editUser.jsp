<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>


<div style="margin:0px auto; width:500px">


<form action="${pageContext.request.contextPath}/updateUser" method="post">

    username: <input name="username" value="${user.username}"> <br>
    password: <input name="password" value="${user.password}"> <br>
    phone: <input name="phone" value="${user.phone}"> <br>

<input name="id" type="hidden" value="${user.id}">
<button type="submit">提交</button>

</form>
</div>