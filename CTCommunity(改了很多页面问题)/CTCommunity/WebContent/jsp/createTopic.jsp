<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>创建社区</title>
<link href="css/home.css" rel="stylesheet" type="text/css">
<link href="css/menu.css" rel="stylesheet" type="text/css">
<link href="css/top.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	var timeout = 500;
	var closetimer = 0;
	var ddmenuitem = 0;

	function jsddm_open() {
		jsddm_canceltimer();
		jsddm_close();
		ddmenuitem = $(this).find('ul').eq(0).css('visibility', 'visible');
	}

	function jsddm_close() {
		if (ddmenuitem)
			ddmenuitem.css('visibility', 'hidden');
	}

	function jsddm_timer() {
		closetimer = window.setTimeout(jsddm_close, timeout);
	}

	function jsddm_canceltimer() {
		if (closetimer) {
			window.clearTimeout(closetimer);
			closetimer = null;
		}
	}

	$(document).ready(function() {
		$('#jsddm > li').bind('mouseover', jsddm_open);
		$('#jsddm > li').bind('mouseout', jsddm_timer);
	});

	document.onclick = jsddm_close;
</script>
</head>

<body>
	<a id="returnTop" href="javascript:;">回到顶部</a>
	<script src="js/jquery-1.6.4.min.js" type="text/javascript"></script>
	<script src="js/top.js" type="text/javascript"></script>
	<div class="nav">
<div class="logo"> <a href="http://localhost:8080/CTCommunity/jsp/haslogin.jsp?username=<s:property value="#session.username"/>"><img src="<%=request.getContextPath()%>/jsp/res/logo.jpg" width="100" height="40" /></a> </div>



		<div class="userId">
			<ul id="jsddm">
	<li><a href="http://localhost:8080/CTCommunity/jsp/userspace.jsp"><s:property value="#session.username"/></a>
		<ul>
	    <li><a href="#">登出</a></li>
		
			<li><a href="http://localhost:8080/CTCommunity/jsp/userspace.jsp">我的足迹</a></li>
			<li><a href="http://localhost:8080/CTCommunity/jsp/upfile_.jsp?userid=<s:property value="#session.userid"/>">修改头像</a></li>
		
		</ul>
	</li>
    </ul>
		</div>
		<div id="search">
			<table id="__01" width="181" height="40" border="0" cellpadding="0" cellspacing="0">
	
	<tr>
		
		<td  >
        <s:form action="Search" namespace="/com/action">
				<s:textfield name="searchcontent"></s:textfield>
				<s:submit value="搜索社区"></s:submit>
		</s:form>
        </td>
		
	</tr>
	
</table>
		</div>
	</div>

	<div id="location">
		<img src="res/home.gif" class="house" /> <em>></em> <a href="#">首页</a>
		<em>></em> <a href="#">创建话题</a>
	</div>

	<div id="create_title">
		<h2>创建话题</h2>
	</div>

	<div id="create-community-table">
		<s:form action="AddTopic" namespace="/communityAction">
		<%
		String communityId = request.getParameter("communityId");
		%>
		<input type="hidden" name="communityId" value="<%=communityId%>">
			<table width="960" height="114" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<th width="133" height="46" scope="row">话题名</th>
					<td width="617"><s:textfield name="tpTitle" value="name"
							size="30" /></td>
				</tr>

				<tr>
					<th scope="row">内容</th>
					<td><s:textarea name="tpContent" value="content" cols="45"
							rows="5" /></td>
				</tr>
				<tr>
					<th scope="row">&nbsp;</th>
					<td>&nbsp;</td>
				</tr>
			</table>
			<div class="submit_div">
				<s:submit name="execute" value="提交" />
			</div>
		</s:form>
	</div>

	<div class="create_right">
		<h2>创建注意事项</h2>
	</div>
</body>
</html>
