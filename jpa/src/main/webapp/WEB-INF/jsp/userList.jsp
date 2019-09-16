<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
	/*将post method 改变为delete*/
	$(function(){
		$(".delete").click(function(){
			var href=$(this).attr("href");
			$("#formdelete").attr("action",href).submit();
			return false;
		})
	})
</script>


<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
	<table align='center' border='1' cellspacing='0'>
	    <tr>
	        <td>id</td>
	        <td>username</td>
			<td>password</td>
			<td>phone</td>
	        <td>编辑</td>
	        <td>删除</td>
	    </tr>
	    <c:forEach items="${page.content}" var="c" varStatus="st">
	        <tr>
	            <td>${c.id}</td>
	            <td>${c.username}</td>
				<td>${c.password}</td>
				<td>${c.phone}</td>
				<td><a href="${pageContext.request.contextPath}/users/${c.id}">编辑</a></td>
				<td><a class="delete" href="${pageContext.request.contextPath}/users/${c.id}">删除</a></td>
	        </tr>
	    </c:forEach>
	</table>
	<br>
	<div>
		<c:if test="${page.hasPrevious()}">
			<a href="?start=0">[首  页]</a>
			<a href="?start=${page.number-1}">[上一页]</a>
		</c:if>

		<c:if test="${page.hasNext()}" >
			<a href="?start=${page.number+1}">[下一页]</a>
			<a href="?start=${page.totalPages-1}">[末  页]</a>
		</c:if>
	</div>
	<br>
	<form action="${pageContext.request.contextPath}/users" method="post">
	
	    username: <input name="username"> <br>
		password: <input name="password"> <br>
		phone: <input name="phone"> <br>
	<button type="submit">提交</button>
	
	</form>
	<form id="formdelete" action="" method="POST">
		<input type="hidden" name="_method" value="DELETE">
	</form>
</div>
