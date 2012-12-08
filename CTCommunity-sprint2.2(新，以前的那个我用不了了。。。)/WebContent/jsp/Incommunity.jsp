<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="currentCommunity.communityName"/>社区</title>
</head>
<body>
	Welcome!<br>欢迎来到：<s:property value="currentCommunity.communityName"/>
	<br><input type="button" name="createtopic" value="新建话题" onclick="window.location.href='http://localhost:8080/CTCommunity/jsp/createitem.jsp?communityId=<s:property value="currentItem.itemId"/>'">
	<br>
	所有话题：
	<s:iterator id="item" value="@com.action.InCommunity@itemlist">
 	
 			<a
 				href="<s:url action="InItem" namespace="/com/action"/>?itemId=<s:property value="#item.getItemid()"/>">
 				<li><s:property value="#item.getItemName()"/></li>
 			</a>
	
	</s:iterator>
</body>
</html>