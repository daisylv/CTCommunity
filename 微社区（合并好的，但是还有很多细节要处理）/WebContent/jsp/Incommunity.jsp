f<%@page import="communityAction.TopicAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>community</title>
<link href="<%=request.getContextPath()%>/jsp/css/home.css" rel="stylesheet" type="text/css"/> 
<link href="<%=request.getContextPath()%>/jsp/css/top.css" rel="stylesheet"  type="text/css"/>
<link href="<%=request.getContextPath()%>/jsp/css/menu.css" rel="stylesheet" media="screen" type="text/css"/>
<link href="<%=request.getContextPath()%>/jsp/css/community.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/jsp/js/css/easydialog.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/js/easydialog.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/js/guest.js"></script>
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

<body onload="MM_preloadImages('<%=request.getContextPath()%>/jsp/res/create_item1.png')">
<a id="returnTop" href="javascript:;">回到顶部</a> 
<script src="<%=request.getContextPath()%>/jsp/js/jquery-1.6.4.min.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/jsp/js/top.js" type="text/javascript"></script>
<div class="nav">
<div class="logo"> <s:if test="#session.username!=null"><a href="http://localhost:8080/CTCommunity/jsp/haslogin.jsp?username=<s:property value="#session.username"/>"><img src="<%=request.getContextPath()%>/jsp/res/logo.jpg" width="100" height="40" /></a></s:if>
<s:if test="#session.username==null"><a href="http://localhost:8080/CTCommunity"><img src="<%=request.getContextPath()%>/jsp/res/logo.jpg" width="100" height="40" /></a></s:if>
 </div>


<div class="userId">
<ul id="jsddm">
	<li><a href="footprint.html"><s:property value="#session.username"/></a>
		<ul>
	    <li><a href="#">登出</a></li>
			<li><a href="#">我的资料</a></li>
			<li><a href="#">我的足迹</a></li>
		</ul>
	</li>
    </ul>
</div>

	<s:if test="msgconfirm == 'manage'">
	<a href="<s:url action="MemberManage" namespace="/com/action"/>
	?communityId=<s:property value="currentCommunity.communityId"/>
	">社区管理</a></s:if>
	<s:if test="msgconfirm == 'requestsend'">
	<a href="<s:url action="SendRequest" namespace="/com/action"/>
	?communityId=<s:property value="currentCommunity.communityId"/>
	&ownerId=<s:property value="currentCommunity.ownerId"/>&communityName=<s:property value="currentCommunity.communityName"/>">
	申请加入</a>
	</s:if>
	<s:if test="msgconfirm == 'member'">社区社员</s:if>
	<s:if test="msgconfirm == 'sended'"><a href="#">已发申请</a></s:if>
	
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
        <form id="form1" name="form1" method="post" action="">
		  <label for="search"></label>
		  <input name="search_input" type="text" id="search_input" size="14" />
	    </form>
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
			<img src="<%=request.getContextPath()%>/jsp/images/search2_06.png" width="29" height="7" alt=""/></td>
		<td>
			<img src="" width="1" height="2" alt=""/></td>
	</tr>
	<tr>
		<td>
			<img src="<%=request.getContextPath()%>/jsp/images/search2_07.png" width="13" height="5" alt=""/></td>
		<td>
			<img src="" width="1" height="5" alt=""/></td>
	</tr>
</table>
</div>
</div >

<div id="location">
<img src="<%=request.getContextPath()%>/jsp/res/home.gif" class="house" />
<em >></em>
<a href="#">首页</a>
<em >></em>
<a href="#">社区</a>
</div>


<div class="topic">
<div class="community_pic">
<img src="<%=request.getContextPath()%>/jsp/res/2.jpg" />
</div>
<div id="coomunity_introduce">
<div><s:property value="currentCommunity.communityName"/></div>
<p>社区1介绍</p>
</div>
<% String communityId = request.getParameter("communityId"); %>
<div id="addnew"><a href="<%=request.getContextPath()%>/jsp/createTopic.jsp?communityId=<%=communityId %>" onclick="return checkGuest(<s:property value="#session.username"/>);" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('create_item','','<%=request.getContextPath()%>/jsp/res/create_item1.png',1)"><img src="<%=request.getContextPath()%>/jsp/res/create_item.png" name="create_item" width="120" height="40" border="0" id="create_item" /></a> </div>
</div>

<div id="community_context">
<div id="community_left">
<s:form action="Topic" namespace="/topicAction" method="post">
<div id="community_topics">

<table width="749" border="0" cellspacing="0">
  <tr id="topic_top">
    <td>话题</td>
    <td>作者</td>
    <td>回复</td>
    <td>最后发表</td>
  </tr>
  <!--<s:hidden name="communityId" value="communityId"></s:hidden>  用来传递communityId-->

  <s:iterator value="topics" id="topic" begin="beginItem" end="endItem">
	<tr>
		<td><a
			href="http://localhost:8080/CTCommunity/communityAction/Reply.action?topicId=<s:property value="#topic.topicId"/>" />
			<s:property value="#topic.tpTitle" /></td>
		<td><s:property value="#topic.topicinfo.author" /></td>
		<td><s:property value="#topic.topicinfo.replyNum" /></td>
		<td><s:date name="#topic.topicinfo.updateTime" format="yyyy-MM-dd HH:mm:ss"/></td>
		<s:if test='#session.username == topicinfo.author'>
			<td><a href="<%=request.getContextPath()%>/communityAction/DeleteTopic.action?topicId=<s:property value="#topic.topicinfo.topicId"/>&communityId=<s:property value="#topic.communityId"/>">删除</a>
			</td>
		</s:if>
	</tr>
</s:iterator>
</table>
<s:if test="maxItem>=0">
<s:property value="'共'+{maxItem+1}+'条'"/>
<s:property value="'当前第'+{beginItem+1}+'到'+{endItem+1}+'条'"/>
<s:property value="'当前第'+cuP+'页'"/>
<s:if test="beginItem>0">
<a href="<s:url action="InCommunity" namespace="/com/action"/>?username=
	<s:property value="#session.username"/>&page=<s:property value="-1"/>
	&cuPage=<s:property value="cuP"/>&communityId=<s:property value="currentCommunity.communityId"/>">上一页</a>
</s:if>
<s:else>首页</s:else>

<s:if test="endItem<maxItem">
<a href="<s:url action="InCommunity" namespace="/com/action"/>?username=
	<s:property value="#session.username"/>&page=<s:property value="1"/>
	&cuPage=<s:property value="cuP"/>&communityId=<s:property value="currentCommunity.communityId"/>">下一页</a>
</s:if>
<s:else>末页</s:else>	</s:if>
</div>
</s:form>

<div id="page">
<span class="strong">1</span>
<a href="#" >2</a>
<a href="#" >3</a>
<a href="#" >4</a>
<a href="#" >5</a>
<a href="#" >6</a>
<a href="#" >7</a>
<a href="#" >8</a>
<a href="#" >9</a>
<a href="#" >10</a>
<a href="#" >尾页</a>
</div>
</div>


<div id="community_right"><!--右边部分-->
<div id="master">
<h2>创建者</h2>
<div id="master_information">

<div id="master_name"><a>
<s:iterator id="owner" value="@com.action.InCommunity@userList">
 		<s:if test='currentCommunity.ownerId == userId'>
 			<div id="master_pic"><img src="<s:property value="#owner.getPicpath()"/>" /></div>
			<s:property value="#owner.getUsername()"/>
		</s:if>
	</s:iterator>

</a></div>
</div>
</div>

<div class="clear"></div>
<br>
<br>
<br>
<br>
<br>

<h2>成员</h2>
<dl class="obu">
<s:iterator value="@com.action.InCommunity@userList">
	<dt><img src="<s:property value="picpath"/>" /></dt>

	<dd><a><s:property value="username"></s:property></a></dd>
	</dl>
</s:iterator>
<div id="all">
<p>所有成员<p>
</div>

</div>
</div>
</body>
</html>
