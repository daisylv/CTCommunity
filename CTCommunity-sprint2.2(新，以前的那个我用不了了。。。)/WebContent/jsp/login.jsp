<!--已合-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>logon</title>
<link href="css/home.css" rel="stylesheet" type="text/css"> 
<link href="css/community.css" rel="stylesheet" type="text/css"> 
<link href="css/top.css" rel="stylesheet"  type="text/css">
<link href="css/footprint.css" rel="stylesheet" type="text/css">
<link href="css/modify-info.css" rel="stylesheet" type="text/css">
<link href="css/menu.css" rel="stylesheet" media="screen" type="text/css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
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
<script src="js/jquery-1.6.4.min.js" type="text/javascript"></script> 
<script src="js/top.js" type="text/javascript"></script>
<div class="nav">
<div class="logo"> <a href="http://localhost:8080/CTCommunity/"><img src="res/logo.jpg" width="100" height="40" /></a> </div>


<div class="userId">
<ul id="jsddm1">
	<li><a href="logon.html">登录</a>
	</li>
    </ul>

</div>
<div class="userId1">

    <ul id="jsddm1">
    <li><a href="#" >注册</a></li>
    </ul>

</div>
<div id="search">
<table id="__01" width="181" height="40" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3">
			<img src="images/search2_01.png" width="180" height="8" alt=""></td>
		<td>
			<img src="" width="1" height="8" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/search2_02.png" width="13" height="27" alt=""></td>
		<td class="search_input" >
        <form id="form1" name="form1" method="post" action="">
		  <label for="search"></label>
		  <input name="search_input" type="text" id="search_input" size="14" />
	    </form>
        </td>
		<td>
			<a href="#"><img src="images/search2_04.png" width="29" height="25" alt=""></a></td>
		<td>
			</td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/search2_05.png" width="138" height="7" alt=""></td>
		<td rowspan="2">
			<img src="images/search2_06.png" width="29" height="7" alt=""></td>
		<td>
			<img src="" width="1" height="2" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/search2_07.png" width="13" height="5" alt=""></td>
		<td>
			<img src="" width="1" height="5" alt=""></td>
	</tr>
</table>
</div>
</div >

<div id="location">
<img src="res/home.gif" class="house" />
<em >></em>
<a href="#">首页</a>
<em >></em>
<a href="#">登录</a>
</div>

<div id="infomation_body">
<div class="my_information">
<h2>登录</h2>
</div>
<div>
<table width="845" border="0">
  <tr>
    
    <td width="670"><s:form action="Login" namespace="/com/action" method="post">
		<s:textfield label="用户名" name="User.username"></s:textfield></td>
  </tr>
 
 	
	
  <tr>

    <td><s:password label="密码" name="User.password"></s:password>
		<s:submit value="submit"></s:submit></s:form></td>
  </tr>
 
  
</table>

</div>

</div>



</body>
</html>
