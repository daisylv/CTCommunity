<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
welcome!<br><br>
	Your community name is:<br>
	<s:property value="Community.communityName"/>
	<br><br>
	Your community type is:<br>
	<s:property value="Community.communityType"/>
	<br>
	<br>
	<input type="button" name="createtopic" value="新建话题" onclick="window.location.href='http://localhost:8080/CTCommunity/jsp/createitem.jsp?communityId=<s:property value="Community.communityId"/>'">
</body>
</html>