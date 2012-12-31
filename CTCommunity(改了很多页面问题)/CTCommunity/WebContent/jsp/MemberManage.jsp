<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MemberManage</title>
</head>
<body>
我的消息盒子：
<s:debug></s:debug>
<s:if test="@com.action.MemberManage@msglist.size()==0">已处理完毕</s:if>
<s:iterator id="msg" value="@com.action.MemberManage@msglist">
	
	<s:property value="content"/>
	<a
 	href="<s:url action="MemberAccept" namespace="/com/action"/>?communityId=<s:property value="communityId"/>&senderId=<s:property value="#msg.getSenderId()"/>">
 	<!-- 所以还是将user的list取出来吧 -->
 	同意？
 	</a>
</s:iterator>
<a href="<s:url action="CommunityPager" namespace="/com/action"/>?username=<s:property value="#session.username"/>&cuPage=1&page=0&cuPage2=1&page2=0&ty=<s:property value="1"/>">返回我的天地</a>
<br>
	<!--<s:iterator id="msg" value="@com.action.MemberManage@msglist">
		<s:iterator id="users" value="@com.action.MemberManage@userlist">
			<s:if test="#session.userid == #msg.getReceiverId">
				<s:property value="content"/>
				<a
 					href="<s:url action="MemberAccept" namespace="/com/action"/>?communityId=<s:property value="communityId"/>&senderId=<s:property value="#msg.getSenderId()"/>">
 					所以还是将user的list取出来吧
 					同意？
 				</a>
			</s:if>
		</s:iterator>
	</s:iterator>-->
</body>
</html>