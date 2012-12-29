<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索结果</title>
</head>
<body>
<div id="cntent1" align="left" title="搜索结果">
	我们帮您找到的符合的社区有：
 <table style="border: 2px">
 	<s:iterator id="co" value="communitySearchlist">
 		<a
 				href="<s:url action="InCommunity" namespace="/com/action"/>?communityId=<s:property value="communityId"/>">
 				<li><s:property value="#co.getCommunityName()"/></li>
 		</a>
	</s:iterator>
 </table>
</div>

</body>
</html>