<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>直接登录</title>
</head>
<body>
	<s:form action="Login" namespace="/com/action" method="post">
		<s:textfield label="Username" name="User.username"></s:textfield>
		<s:password label="Password" name="User.password"></s:password>
		<s:submit value="submit"></s:submit>
	</s:form>
</body>
</html>