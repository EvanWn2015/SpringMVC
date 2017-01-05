<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<script type="text/javascript"
	src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<title>Insert title here</title>
</head>
<body>
	<form method="post" id="loginForm">
		First name:<br> <input type="text" name="username" value="Mickey">
		<br> Last name:<br> <input type="text" name="password"
			value="Mouse"> <br>
		<br>
		<button>Submit</button>
	</form>
	
<script type="text/javascript">
	$(function() {
		bindEvent();
	})

	function bindEvent() {
		$('button').bind({
			click : post
		});
	}

	function post() {
		$.post({
			type : "POST",
			url : "login",
			data : $('#loginForm').serialize ,
			success : function(data) {
				console.log('success');
			}
		});
	}
</script>
</body>
</html>