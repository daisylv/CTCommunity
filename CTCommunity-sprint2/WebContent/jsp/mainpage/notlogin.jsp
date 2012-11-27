<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
Logo+XXX………………………………………<button>新浪认证登录</button><button>直接登陆</button><button>注册</button>
<br>
<br>
热门社区…………………………………………<input><button>搜索社区</button>

<br>
<br>
<div id="cntent1" align="left" title="动画类">
	动漫类
 <table style="border: 2px">
 	<!--
 	<s:iterator value="communitylist">
 		<s:if test='communityType=="动画片"'>
 			<a href="<s:url action="InCommunity" namespace="/com/action"/>">
 				<li><s:property value="communityName"/></li>
 			</a>
		</s:if>
	</s:iterator>  
	-->
 	<s:iterator id="co" value="communitylist">
 		<s:if test='communityType=="动画片"'>
 			<a href="<s:url action="InCommunity" namespace="/com/action"/>">
 				<li><s:property value="#co.getCommunityName()"/></li>
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