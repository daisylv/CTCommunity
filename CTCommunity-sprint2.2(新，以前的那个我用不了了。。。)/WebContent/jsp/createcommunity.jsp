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
	Hello!Please enter your communityName  communityIntroduce and communityType!
	<ul>
	<s:debug/>
		<s:form action="Addcommunity" namespace="/com/action" method="post">
		   
			<s:textfield label="communityName" name="Community.communityName"></s:textfield> 
			<s:textfield label="communityIntroduce" name="Community.communityIntro"></s:textfield>
			<s:textfield label="communityType" name="Community.communityType"></s:textfield>
			<s:submit value="submit"></s:submit>
		</s:form>
	</ul>
</body>
</html>