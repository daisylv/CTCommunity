<!--谁也不许动 金41来写-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome your joining!</title>
</head>
<body>
	<s:form action="AddUser" namespace="/com/action" method="post">
		
			<s:textfield label="用户名" name="User.username"></s:textfield>
			<s:textfield label="性别" name="User.usergender"></s:textfield>
			<s:password label="密码" name="User.password"></s:password>
			<s:submit value="submit"></s:submit>
			
	</s:form>
</body>
</html>