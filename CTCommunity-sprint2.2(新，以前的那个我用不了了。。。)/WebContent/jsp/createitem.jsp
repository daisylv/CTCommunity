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
	Hello!Please enter your ItemId  ItemCountent OwnerId and CommunityItemcol!
	<%int communityId= Integer.parseInt(request.getParameter("communityId").toString());
	request.setAttribute("communityId", communityId);%>
	<ul>
    	<li>
		<s:form action="Additem" namespace="/com/action" method="post" >
			<s:hidden name="communityId" value="%{#request.communityId}"></s:hidden>
		    <s:textfield label="ItemName" name="Item.ItemName"></s:textfield>
			<s:textarea label="ItemCountent" name="Item.ItemCountent"></s:textarea>
			<s:submit value="submit"></s:submit>
		</s:form>
		</li>
	</ul>
</body>
</html>