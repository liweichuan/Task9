<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>


<div style="margin:0px auto; width:500px">


<form action="${pageContext.request.contextPath}/updateStudent" method="post">

    name: <input name="name" value="${student.name}"> <br>
    type: <input name="type" value="${student.type}"> <br>
    wish: <input name="wish" value="${student.wish}"> <br>

<input name="id" type="hidden" value="${student.id}">
<button type="submit">提交</button>

</form>
</div>