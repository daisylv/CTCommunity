<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello!Please enter your userId and sinaId!
	<ul>
    <li>
		<s:form action="AddUser" namespace="/com/action" method="post">
		<!--<s:textfield label="userId" name="UserId"></s:textfield>
			<s:textfield label="sinaId" name="SinaId"></s:textfield>-->
			<s:textfield label="userId" name="User.userId"></s:textfield> 
			<s:textfield label="sinaId" name="User.sinaId"></s:textfield>
			<s:submit value="submit"></s:submit>
		</s:form>
	</li>
</ul>
</body>
</html>