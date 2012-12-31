<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>logon</title>
<link href="<%=request.getContextPath()%>/jsp/css/home.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/community.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/top.css" rel="stylesheet"  type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/footprint.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/modify-info.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/menu.css" rel="stylesheet" media="screen" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/js/jquery.min.js"></script>
<script type="text/javascript">
var timeout         = 500;
var closetimer		= 0;
var ddmenuitem      = 0;

function jsddm_open()
{	jsddm_canceltimer();
	jsddm_close();
	ddmenuitem = $(this).find('ul').eq(0).css('visibility', 'visible');}

function jsddm_close()
{	if(ddmenuitem) ddmenuitem.css('visibility', 'hidden');}

function jsddm_timer()
{	closetimer = window.setTimeout(jsddm_close, timeout);}

function jsddm_canceltimer()
{	if(closetimer)
	{	window.clearTimeout(closetimer);
		closetimer = null;}}

$(document).ready(function()
{	$('#jsddm > li').bind('mouseover', jsddm_open);
	$('#jsddm > li').bind('mouseout',  jsddm_timer);});

document.onclick = jsddm_close;
  </script> 
</head>

<body>
<a id="returnTop" href="javascript:;">回到顶部</a> 
<script src="<%=request.getContextPath()%>/jsp/js/jquery-1.6.4.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/jsp/js/top.js" type="text/javascript"></script>
<div class="nav">
<div class="logo"> <a href="http://localhost:8080/CTCommunity"><img src="<%=request.getContextPath()%>/jsp/res/logo.jpg" width="100" height="40" /></a> </div>


<div class="userId">
<ul id="jsddm1">
	<li><a href="http://localhost:8080/CTCommunity/jsp/login.jsp">登录</a>
	</li>
    </ul>

</div>
<div class="userId1">

    <ul id="jsddm1">
    <li><a href="http://localhost:8080/CTCommunity/jsp/register.jsp" >注册</a></li>
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
</div >

<div id="location">
<img src="<%=request.getContextPath()%>/jsp/res/home.gif" class="house" />
<em >></em>
<a href="http://localhost:8080/CTCommunity">首页</a>
<em >></em>
<a href="http://localhost:8080/CTCommunity/jsp/login.jsp">登录</a>
</div>

<div id="infomation_body">
<div class="my_information">
<h2>登录</h2>
</div>
<div>
<s:label>信息出错，请重新登录</s:label>
<br></br>
 <s:form action="Login" namespace="/com/action" method="post" theme="simple" >
    
    	<legend>用户名</legend>
    	<label>
		<s:textfield name="User.username" cssClass="validate[required,custom[userName]]text-input"></s:textfield>
		</label>

	
  
			<legend>
				密码
			</legend>
			<label>
    	<s:password  name="User.password" cssClass="validate[required,custom[passWord]] text-input"></s:password></label>
    
		<s:submit value="submit"></s:submit></s:form>

</div>




</body>
</html>
