<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0058)http://localhost:8080/CTCommunity/com/action/Search.action -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>search</title>
<link href="<%=request.getContextPath()%>/jsp/css/home.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/community.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/top.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/footprint.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/search.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/modify-info.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/menu.css" rel="stylesheet" media="screen" type="text/css">
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
<a id="returnTop" href="javascript:;">回到首页</a> 
<script src="<%=request.getContextPath()%>/jsp/js/jquery-1.6.4.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/jsp/js/top.js" type="text/javascript"></script>
<div class="nav">
<div class="logo"> <a href="http://localhost:8080/CTCommunity/com/action/home.html"><img src="<%=request.getContextPath()%>/jsp/res/logo.jpg" width="100" height="40"></a> </div>


<div class="userId">
<ul id="jsddm">
	<li><a href="http://localhost:8080/CTCommunity/com/action/footprint.html">用户名</a>
		<ul>
	    <li><a href="http://localhost:8080/CTCommunity/com/action/Search.action#">我的资料</a></li>
			<li><a href="http://localhost:8080/CTCommunity/com/action/Search.action#">我的社区</a></li>
			<li><a href="http://localhost:8080/CTCommunity/com/action/Search.action#">我的足迹</a></li>
		</ul>
	</li>
    </ul>
</div>
<div id="search">
<table id="__01" width="181" height="40" border="0" cellpadding="0" cellspacing="0">
	<tbody><tr>
		<td colspan="3">
			<img src="<%=request.getContextPath()%>/jsp/images/search2_01.png" width="180" height="8" alt=""></td>
		<td>
			<img src="" width="1" height="8" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="<%=request.getContextPath()%>/jsp/images/search2_02.png" width="13" height="27" alt=""></td>
		<td class="search_input">
        <form id="form1" name="form1" method="post" action="">
		  <label for="search"></label>
		  <input name="search_input" type="text" id="search_input" size="14">
	    </form>
        </td>
		<td>
			<a href="http://localhost:8080/CTCommunity/com/action/Search.action#"><img src="<%=request.getContextPath()%>/jsp/images/search2_04.png" width="29" height="25" alt=""></a></td>
		<td>
			</td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="<%=request.getContextPath()%>/jsp/images/search2_05.png" width="138" height="7" alt=""></td>
		<td rowspan="2">
			<img src="<%=request.getContextPath()%>/jsp/images/search2_06.png" width="29" height="7" alt=""></td>
		<td>
			<img src="" width="1" height="2" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="<%=request.getContextPath()%>/jsp/images/search2_07.png" width="13" height="5" alt=""></td>
		<td>
			<img src="" width="1" height="5" alt=""></td>
	</tr>
</tbody></table>
</div>
</div>

<div id="location">
<img src="<%=request.getContextPath()%>/jsp/res/home.gif" class="house">
<em>&gt;</em>
<a href="http://localhost:8080/CTCommunity/com/action/Search.action#">首页</a>
<em>&gt;</em>
<a href="http://localhost:8080/CTCommunity/com/action/Search.action#">搜索</a>
</div>

<div class="search_body">
<h2>搜索结果</h2>
<div class="search_table">
  <form id="form2" name="form2" action="">
    <div class="search_inp">
<input name="search_big2" type="text" id="search_big" size="78"></div>
    <div class="search_button"> <input type="image" value=" "></div>
  </form>
</div>
<div class="search_result">
<table width="800" border="0">
  <tr>
    <td colspan="2" height="60"><div class="search_com"><a>相关社区</a></div><div class="search_topic"><a>相关话题</a></div></td>
    </tr>
	
	<s:iterator id="co" value="communitySearchlist">
	
  <tr>
    <td width="122" height="100"><div><img src="<%=request.getContextPath()%>/jsp/res/2.jpg"></div></td>
    <td width="668"><div>
	<a href="<s:url action="InCommunity" namespace="/com/action"/>?communityId=<s:property value="communityId"/>">
 				<li><s:property value="#co.getCommunityName()"/></li>
 		</a>
	</div><div>内容</div></td>
  </tr>
  </s:iterator>
</table>

</div>
</div>





</body></html>