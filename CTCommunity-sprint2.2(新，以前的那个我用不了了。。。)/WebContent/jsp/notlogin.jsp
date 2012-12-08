<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>home_notlogon</title>
<link href="<%=request.getContextPath()%>/jsp/css/home.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/top.css" rel="stylesheet"  type="text/css">
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
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
 
</head>

<body >
<a id="returnTop" href="javascript:;">回到顶部</a> 
<script src="<%=request.getContextPath()%>/jsp/js/jquery-1.6.4.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/jsp/js/top.js" type="text/javascript"></script>
<div class="nav">
<div class="logo"> <a href="home.html"><img src="<%=request.getContextPath()%>/jsp/res/logo.jpg" width="100" height="40" /></a> </div>


<div class="userId">
<ul id="jsddm1">
	<li><a href="http://localhost:8080/CTCommunity/jsp/login.jsp">直接登录</a>
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
		<td colspan="3">
			<img src="<%=request.getContextPath()%>/jsp/images/search2_01.png" width="180" height="8" alt=""></td>
		<td>
			<img src="" width="1" height="8" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="<%=request.getContextPath()%>/jsp/images/search2_02.png" width="13" height="27" alt=""></td>
		<td class="search_input" >
        <s:form action="Search" namespace="/com/action">
				<s:textfield name="searchcontent"></s:textfield>
				<s:submit value="搜索社区"></s:submit>
		</s:form>
        </td>
		<td>
			<a href="#"><img src="<%=request.getContextPath()%>/jsp/images/search2_04.png" width="29" height="25" alt=""></a></td>
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
</table>
</div>
</div >

<div id="location">
<img src="<%=request.getContextPath()%>/jsp/res/home.gif" class="house" />
<em >></em>
<a href="#">首页</a>
</div>

<% String type = (String)(request.getParameter("type"));
	//type.getBytes("UTF-8");
	
%>
<%=type%>
<div class="four_table">
<div id="catelog" >
<ul class="tags">
<li><a href="?type=sports" >运动类</a></li>
<li><a href="?type='动画类'" >动画类</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类10</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类1</a></li>
<li><a href="#" >分类10</a></li>
</ul>
</div>
<div id="communities">
<ul>
<s:iterator value="communitylist">
 			<s:if test='communityType=="运动"'>
<li >
<div id="community_picture"><a href="community.html">
<img src="<%=request.getContextPath()%>/jsp/res/2.jpg" /></a>
</div>
<div id="community_content">
 <div id="community_title">
 <table><tr><td><a href="<s:url action="InCommunity" namespace="/com/action"/>?communityId=<s:property value="communityId"/>">
						<s:property value="communityName" /></td></tr>
					</a></div>
 <p>社区1介绍</p>
 </table>
</div>
</li>



</s:if>
		</s:iterator>

</ul>
</div>

</div>
<div id="bottom">
<ul>
<li><a href="#">关于我们</a></li>
<li><a href="#">联系我们</a></li>
<li><a href="#">提供建议</a></li>
<li><a href="#">特别感谢</a></li>

</ul>
</div>

</body>
</html>
