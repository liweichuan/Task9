<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>


<div style="margin:0px auto; width:500px">


    <form action="${pageContext.request.contextPath}/students/${student.id}" method="post">
        <input type="hidden" name="_method" value="PUT">
        name: <input name="name" value="${student.name}"> <br>
        type: <input name="type" value="${student.type}"> <br>
        wish: <input name="wish" value="${student.wish}"> <br>

        <button type="submit">提交</button>

    </form>
</div>