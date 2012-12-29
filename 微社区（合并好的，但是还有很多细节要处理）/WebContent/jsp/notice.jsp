<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>消息提醒</title>
	</head>
	<body>
	<code>
	<c:forEach items="${sessionScope.noticeList}" var="notice"> 
	${notice.fromUsername}在<a href="#" onclick='javascript:window.open("http://${notice.topicUrl}")'>${notice.tpTitle}</a>给您留言
    <br>
    </c:forEach> 
	</code>
	</body>
</html>
