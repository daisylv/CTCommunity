<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">
<title>topicHome</title>
<link href="<%=request.getContextPath()%>/jsp/css/home.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/top.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/community.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/menu.css"
	rel="stylesheet" media="screen" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/item.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/jsp/js/css/easydialog.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jsp/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jsp/js/easydialog.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jsp/js/guest.js"></script>
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

	function forward(_replyId) {
		var data = 'replyId=' + _replyId;
		$
				.ajax({
					type : "POST",
					url : "http://localhost:8080/CTCommunity/communityAction/Forward.action",
					data : data,
					success : function() {
						easyDialog.open({
							container : {
								header : '微博提示',
								content : '已转发至微博'
							}
						});
					}
				});
		return false;
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
	<script src="<%=request.getContextPath()%>/jsp/js/jquery-1.6.4.min.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/jsp/js/top.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/jsp/js/item-reply.js"
		type="text/javascript"></script>
	<div class="nav">
		<div class="logo">
			<a
				href="http://localhost:8080/CTCommunity/jsp/haslogin.jsp?username=<s:property value="#session.username"/>"><img
				src="<%=request.getContextPath()%>/jsp/res/logo.jpg" width="100"
				height="40" /></a>
		</div>


		<div class="userId">
			<ul id="jsddm">
				<li><a href="footprint.html"><s:property
							value="#session.username" /></a>
					<ul>
						<li><a href="#">登出</a></li>
						<li><a href="#">我的资料</a></li>
						<li><a href="#">我的足迹</a></li>
					</ul></li>
			</ul>
		</div>
		<div id="search">
			<table id="__01" width="181" height="40" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td colspan="3"><img
						src="<%=request.getContextPath()%>/jsp/images/search2_01.png"
						width="180" height="8" alt=""></td>
					<td><img src="" width="1" height="8" alt=""></td>
				</tr>
				<tr>
					<td rowspan="2"><img
						src="<%=request.getContextPath()%>/jsp/images/search2_02.png"
						width="13" height="27" alt=""></td>
					<td class="search_input">
						<form id="form1" name="form1" method="post" action="">
							<label for="search"></label> <input name="search_input"
								type="text" id="search_input" size="14" />
						</form>
					</td>
					<td><a href="#"><img
							src="<%=request.getContextPath()%>/jsp/images/search2_04.png"
							width="29" height="25" alt=""></a></td>
					<td></td>
				</tr>
				<tr>
					<td rowspan="2"><img
						src="<%=request.getContextPath()%>/jsp/images/search2_05.png"
						width="138" height="7" alt=""></td>
					<td rowspan="2"><img
						src="<%=request.getContextPath()%>/jsp/images/search2_06.png"
						width="29" height="7" alt=""></td>
					<td><img src="" width="1" height="2" alt=""></td>
				</tr>
				<tr>
					<td><img
						src="<%=request.getContextPath()%>/jsp/images/search2_07.png"
						width="13" height="5" alt=""></td>
					<td><img src="" width="1" height="5" alt=""></td>
				</tr>
			</table>
		</div>
	</div>

	<div id="location">
		<img src="<%=request.getContextPath()%>/jsp/res/home.gif"
			class="house" /> <em>></em> <a href="#">首页</a> <em>></em> <a
			href="#">社区</a> <em>></em> <a href="#">话题</a>
	</div>
	<%
		int floor = 2;
	%>

	<div id="apDiv1">
		<div id="com_pic">
			<img src="<%=request.getContextPath()%>/jsp/res/2.jpg" width="40"
				height="40" />
		</div>
		<div id="com_name">
			<p>社区名</p>
		</div>
	</div>
	<s:debug />
	<div id="item_body">
		<s:form action="Reply" namespace="communityAction" method="post">
			<div id="item_name">
				<h1>
					<s:property value="topic.tpTitle" />
				</h1>
			</div>
			<div id="reply_top">
				<a
					href="http://localhost:8080/CTCommunity/communityAction/Reply.action?topicId=<s:property value="topic.topicId"/>#btm_reply">回复</a>
			</div>
			<br>
			<div id="first_flour">
				<div id="author_info">
				<s:if test="topic.user.picpath == null">
					<img src="<%=request.getContextPath()%>/jsp/res/headpic.jpg" />
				</s:if>
				<s:else>
					<img src="<s:property value="topic.user.picpath" />" />
				</s:else>
				<br>
					<p>
						<span><s:property value="topic.user.username" /></span>
					</p>
				</div>
				<div id="main_thing" style="float: right;">
					<table width="800" height="121" class="flour_right">
						<tr>
							<td width="587" rowspan="2">

								<div class="main_text">
									<span>1L</span>
									<s:date name="topic.createTime" format="yyyy-MM-dd HH:mm:ss" />
									<p>
										<s:property value="topic.tpContent" />
									</p>
								</div>
							</td>
						</tr>

					</table>
				</div>
			</div>

			<div id="two_flour">
				<table width="920" border="0">
					<s:iterator value="replies" id="reply" begin="beginItem"
						end="endItem">
						<tr>
							<td width="105" class="bottomsolid">
								<div id="author_info">
								<s:if test="#reply.user.picpath == null">
									<img src="<%=request.getContextPath()%>/jsp/res/headpic.jpg" />
								</s:if>
								<s:else>
									<img src="<s:property value="#reply.user.picpath" />" />
								</s:else>
								<br>
								<p>
									<s:property value="#reply.username" />
								</p>
								</div>

							</td>
							<td width="815" class="bottomsolid">
								<table width="800" class="flour_right1">
									<tr>
										<td width="587" rowspan="2"><div class="main_text">
												<span><%=floor++%>L</span>
												<s:date name="#reply.createTime"
													format="yyyy-MM-dd HH:mm:ss" />
												<p>
													<s:property value="#reply.rpContent" />
													<br>
													<s:if test="#reply.rpPic != null">
														<img src='<s:property value="#reply.rpPic"/>' />
													</s:if>
												</p>
											</div></td>
										<td width="124">
											<div>
												<a
													href="<%=request.getContextPath()%>/communityAction/Reply.action?topicId=<s:property value="topic.topicId"/>&replyId=<s:property value="#reply.replyId"/>#btm_reply">回复</a>
												<span><a href="#"
													onclick="return forward(<s:property value="#reply.replyId"/>)">转发</a></span>
												<s:if
													test='#session.username == topicinfo.author || #session.username == #reply.username'>
													<span><a
														href="<%=request.getContextPath()%>/communityAction/DeleteReply.action?topicId=<s:property value="topic.topicId"/>&replyId=<s:property value="#reply.replyId"/>">删除</a>
													</span>
												</s:if>

											</div>
										</td>
									</tr>
								</table>

							</td>
						</tr>
					</s:iterator>
				</table>
				<s:property value="'共'+{maxItem+1}+'条'" />
				<s:property value="'当前第'+{beginItem+1}+'到'+{endItem+1}+'条'" />
				<s:property value="'当前第'+cuP+'页'" />
				<s:if test="beginItem>0">
					<a
						href="<s:url action="Reply" namespace="/communityAction"/>?username=
					<s:property value="#session.username"/>&page=<s:property value="-1"/>
					&cuPage=<s:property value="cuP"/>&topicId=<s:property value="topicId"/>">上一页</a>
				</s:if>
				<s:else>首页</s:else>

				<s:if test="endItem<maxItem">
					<a
						href="<s:url action="Reply" namespace="/communityAction"/>?username=
				<s:property value="#session.username"/>&page=<s:property value="1"/>
				&cuPage=<s:property value="cuP"/>&topicId=<s:property value="topicId"/>">下一页</a>
				</s:if>
				<s:else>末页</s:else>
			</div>
		</s:form>

		<s:form action="AddReply" namespace="communityAction"
			style="position: absolute; top: 1600px; left: 200px;"
			enctype="multipart/form-data">
			<%
				String replyId = request.getParameter("replyId");
					if (replyId == null)
						replyId = "0";
			%>

			<input type="hidden" name="topicId"
				value="<s:property value="topic.topicId" />" />
			<input type="hidden" name="replyId" value="<%=replyId%>" />

			<h2>我的回复</h2>
			<textarea name="rpContent" cols="80" rows="8" class="rpContent"></textarea>
			<s:file name="upload" label="选择图片"></s:file>
			<input type="submit" name="execute" value="回复"
				onclick="return checkGuest(<s:property value="#session.username"/>)" />
			<a name="btm_reply" id="btm_reply"></a>
			<span class="error"></span>
		</s:form>
		<div id="crop_container2"></div>
	</div>

</body>
</html>
