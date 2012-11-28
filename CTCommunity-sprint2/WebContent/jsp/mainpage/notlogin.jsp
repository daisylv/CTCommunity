<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
	Logo+XXX…………………………………………
	<input type="button" name="LoginBySina" value="新浪认证登陆"
onclick="window.location.href='http://localhost:8080/CTCommunity/jsp/weiboAcct/Home.jsp'">
	<input type="button" name="Login" value="直接登录">
	<input type="button" name="Register" value="注册"
		onclick="window.location.href='http://localhost:8080/CTCommunity/jsp/register.jsp'">
	<br>
	<br> 热门社区…………………………………………
	<input>
	<button>搜索社区</button>

	<br>
	<br>
	<div id="cntent1" align="left" title="动画类">
		动漫类
		<table style="border: 2px">
			<s:iterator id="co" value="communitylist">
				<s:if test='communityType=="动画片"'>
					<a
						href="<s:url action="InCommunity" namespace="/com/action"/>?communityId=<s:property value="communityId"/>">
						<s:property value="#co.getCommunityName()" />
					</a>
				</s:if>
			</s:iterator>
		</table>
	</div>

	<div id="content" align="right" title=“运动类”>
		体育类
		<table style="border: 2px">
			<s:iterator value="communitylist">
				<s:if test='communityType=="运动"'>
					<a
						href="<s:url action="InCommunity" namespace="/com/action"/>?communityId=<s:property value="communityId"/>">
						<s:property value="communityName" />
					</a>
				</s:if>
			</s:iterator>
		</table>
	</div>
	<div id="content"></div>
	<div id="content"></div>
</body>
</html>