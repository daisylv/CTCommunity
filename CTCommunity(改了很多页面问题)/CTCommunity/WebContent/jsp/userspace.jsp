<%@page import="org.hns.bean.Community"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import = "com.action.Hello" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>myspace</title>
<link href="<%=request.getContextPath()%>/jsp/css/home.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/community.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/top.css" rel="stylesheet"  type="text/css"/>
<link href="<%=request.getContextPath()%>/jsp/css/footprint.css" rel="stylesheet" type="text/css">
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
  
  <script type="text/javascript">
		function show_section(id)
		{
			//alert(id);
			reset();
			document.getElementById("section-"+id).style.display = "inline";
		}
		
		function reset()
		{
			var sections = document.getElementsByName("section");
			for(var i = 0 ; i < sections.length ; i++)
			{
				sections[i].style.display = "none";
			}
		}
	</script>
</head>

<body onload="MM_preloadImages('<%=request.getContextPath()%>/jsp/res/create_com1.png')">
<a id="returnTop" href="javascript:;">回到顶部</a> 
<script src="<%=request.getContextPath()%>/jsp/js/jquery-1.6.4.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/jsp/js/top.js" type="text/javascript"></script>
<div class="nav">
<div class="logo"> <a href="http://localhost:8080/CTCommunity/jsp/haslogin.jsp?username=<s:property value="#session.username"/>"><img src="<%=request.getContextPath()%>/jsp/res/logo.jpg" width="100" height="40" /></a> </div>

<div class="userId">
<ul id="jsddm">
	<li><a href="http://localhost:8080/CTCommunity/jsp/userspace.jsp"><s:property value="#session.username"/></a>
    <%int userid= Integer.parseInt(request.getSession().getAttribute("userid").toString());
	request.setAttribute("userid", userid);%>
		<ul>
	    <li><a href="#">登出</a></li>
			<li><a href="http://localhost:8080/CTCommunity/jsp/userspace.jsp">我的资料</a></li>
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
</div >

<div class="create_community_pic" >
<a href="http://localhost:8080/CTCommunity/jsp/createcommunity.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('create_com','','<%=request.getContextPath()%>/jsp/res/create_com1.png',1)"><img src="<%=request.getContextPath()%>/jsp/res/create_com.png" name="create_com" width="120" height="40" border="0" id="create_com" /></a> </div>
<div id="location">
<img src="<%=request.getContextPath()%>/jsp/res/home.gif" class="house" />
<em >></em>
<a href="http://localhost:8080/CTCommunity/jsp/haslogin.jsp?username=<s:property value="#session.username"/>">首页</a>
<em >></em>
<a href="#">我的社区</a>
</div>

<div id="footprint_body">
<h2 onClick="show_section(1)" class="mycommunity_click">我的社区</h2>
<h2 onClick="show_section(2)" class="myspace_click">我的足迹</h2>
<div class="history" id="section-1" name="section">



<table width="649">
<s:iterator id="co" value="@com.action.Login@userCommunity" begin="pagerbean.beginItem" end="pagerbean.endItem">
 		
<tr>
<td width="116"><div><img src="<%=request.getContextPath()%>/jsp/res/2.jpg" /></div></td>
<td width="587"><div><div id="community_title"><a href="<s:url action="InCommunity" namespace="/com/action"/>?communityId=<s:property value="communityId"/>">
 				<span><s:property value="#co.getCommunityName()"/></span>
 			</a></div>
 <p>社区1介绍</p></div></td>
 <td width="39"><a href="<s:url action="CommunityPager" namespace="/com/action"/>?username=<s:property value="#session.username"/>&cuPage=1&page=0&cuPage2=1&page2=0&ty=<s:property value="1"/>&oper=<s:property value="communityId"/>">删除</a></td>
</tr>
	</s:iterator>
</table>

<!--<s:property value="'共'+{#request.max}+'条'"/>
<s:property value="'当前第'+{#request.beginIt+1}+'到'+{#request.endIt+1}+'条'"/>
<s:property value="'当前第'+{#request.cuPage}+'页'"/>-->
<s:property value="'共'+{pagerbean.maxItem+1}+'条'"/>
<s:property value="'当前第'+{pagerbean.beginItem+1}+'到'+{pagerbean.endItem+1}+'条'"/>
<s:property value="'当前第'+pagerbean.cuP+'页'"/>
<s:if test="pagerbean.beginItem>0">
<a href="<s:url action="CommunityPager" namespace="/com/action"/>?username=
	<s:property value="#session.username"/>&page=<s:property value="-1"/>
	&cuPage=<s:property value="pagerbean.cuP"/>&page2=<s:property value="-1"/>
	&cuPage2=<s:property value="pagerbean2.cuP"/>&ty=<s:property value="1"/>">上一页</a>
</s:if>
<s:else>首页</s:else>

<s:if test="pagerbean.endItem<pagerbean.maxItem">
<a href="<s:url action="CommunityPager" namespace="/com/action"/>?username=
	<s:property value="#session.username"/>&page=<s:property value="1"/>
	&cuPage=<s:property value="pagerbean.cuP"/>&page2=<s:property value="1"/>
	&cuPage2=<s:property value="pagerbean2.cuP"/>&ty=<s:property value="1"/>">下一页</a>
</s:if>
<s:else>末页</s:else>	
</div>

<div class="myspace_div" id="section-2" style="display:none" name="section">
<table>

<s:iterator id="up" value="@com.action.Login@userpace" begin="pagerbean2.beginItem" end="pagerbean2.endItem">
<tr>
<td>
<span><s:property value="#up.getUserpace()"/><br><s:property value="#up.getTimestamp()"/></span>
 		<br>	<a href="#">
 				转发微薄？
 			</a></td>
</tr>
</s:iterator>
</table>

<s:property value="'共'+{pagerbean2.maxItem+1}+'条'"/>
<s:property value="'当前第'+{pagerbean2.beginItem+1}+'到'+{pagerbean2.endItem+1}+'条'"/>
<s:property value="'当前第'+pagerbean2.cuP+'页'"/>
<s:if test="pagerbean2.beginItem>0">
<a href="<s:url action="CommunityPager" namespace="/com/action"/>?username=
	<s:property value="#session.username"/>&page=<s:property value="-1"/>
	&cuPage=<s:property value="pagerbean.cuP"/>&page2=<s:property value="-1"/>
	&cuPage2=<s:property value="pagerbean2.cuP"/>&ty=<s:property value="2"/>">上一页</a>
</s:if>
<s:else>首页</s:else>

<s:if test="pagerbean2.endItem<pagerbean2.maxItem">
<a href="<s:url action="CommunityPager" namespace="/com/action"/>?username=
	<s:property value="#session.username"/>&page=<s:property value="1"/>
	&cuPage=<s:property value="pagerbean.cuP"/>&page2=<s:property value="1"/>
	&cuPage2=<s:property value="pagerbean2.cuP"/>&ty=<s:property value="2"/>">下一页</a>
</s:if>
<s:else>末页</s:else>
</div>



<div id="community_right"><!右边部分>
<div id="master">
<h2>个人信息</h2>
<div id="master_information">
<div id="master_pic"><img src="<s:property value="#session.picpath"/>" /></div>
<div id="master_name"><a>名字</a></div>
</div>
</div>



</div>

</div>



</body>
</html>
