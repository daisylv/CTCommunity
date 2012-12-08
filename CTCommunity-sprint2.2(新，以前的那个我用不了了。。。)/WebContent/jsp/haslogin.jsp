<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<<%@ page import = "com.action.Hello" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
Logo+XXX………………………………………………Hello!<s:property value="#session.username"/>……………………………………<input type="button" name="CreateC" value="创建社区" 
																		onclick="window.location.href='http://localhost:8080/CTCommunity/jsp/createcommunity.jsp'">
																		…………………………<input type="button" name="Myspace" value="我的天地" 
																		onclick="window.location.href='http://localhost:8080/CTCommunity/jsp/userspace.jsp?username=<s:property value="#session.username"/>'"></input>
<br>
<br>
<div id="cntent1" align="left" title="动画类">
	动漫类
 <table style="border: 2px">
 	<!--
 	<s:iterator value="communitylist2">
 		<s:if test='communityType=="动画片"'>
 			<a href="<s:url action="InCommunity" namespace="/com/action"/>">
 				<li><s:property value="communityName"/></li>
 			</a>
		</s:if>
	</s:iterator>  
	-->
 	<s:iterator id="co" value="@com.action.Hello@communitylist">
 		<s:if test='communityType=="动画片"'>
 			<a
 				href="<s:url action="InCommunity" namespace="/com/action"/>?communityId=<s:property value="communityId"/>">
 				<li><s:property value="#co.getCommunityName()"/></li>
 			</a>
		</s:if>
	</s:iterator>
 </table>
</div>

<div id="content" align="right" title=“运动类”>
	体育类
	<table style="border: 2px">
 		<s:iterator value="@com.action.Hello@communitylist">
 			<s:if test='communityType=="运动"'>
					<a
						href="<s:url action="InCommunity" namespace="/com/action"/>?communityId=<s:property value="communityId"/>">
						<li><s:property value="communityName" /></li>
					</a>
				</s:if>
		</s:iterator>
 	</table>
</div>
<div id="content"></div>
<div id="content"></div>
</body>
</html>