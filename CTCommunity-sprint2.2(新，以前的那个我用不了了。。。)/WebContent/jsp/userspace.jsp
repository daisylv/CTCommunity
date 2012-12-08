<%@page import="org.hns.bean.Community"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import = "com.action.Hello" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户空间</title>
</head>
<body>
	Hello…………<s:property value="#session.username"/>
	<%int userid= Integer.parseInt(request.getSession().getAttribute("userid").toString());
	request.setAttribute("userid", userid);%>
	<!-- <%out.println(userid); %> -->
	
	<input type="button" name="mainpage" value="回到主页" onclick="window.location.href='http://localhost:8080/CTCommunity/jsp/haslogin.jsp?username=<s:property value="#session.username"/>'">
	
	<input type="button" name="CreateCinS" value="创建社区" onclick="window.location.href='http://localhost:8080/CTCommunity/jsp/createcommunity.jsp'">
<div id="cntent1" align="left" title="用户所有">
	你的社区 
 <table style="border: 2px">
 	<!--
 	<s:iterator value="communitylist">
 		<s:if test='ownerId == userid'>
 			<a href="<s:url action="InCommunity" namespace="/com/action"/>">
 				<li><s:property value="communityName"/></li>
 			</a>
		</s:if>
	</s:iterator>  
	-->
 	<s:iterator id="co" value="@com.action.Hello@communitylist">
 		<s:if test='ownerId == #request.userid'>
 			<a
 				href="<s:url action="InCommunity" namespace="/com/action"/>?communityId=<s:property value="communityId"/>">
 				<li><s:property value="#co.getCommunityName()"/></li>
 			</a>
		</s:if>
	</s:iterator>
 </table>
</div>
</body>
</html>