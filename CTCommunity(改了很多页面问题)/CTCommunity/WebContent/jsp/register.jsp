<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome your joining!</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/jsp/js/css/validationEngine.jquery.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/jsp/js/css/template.css" type="text/css"/>
    
	<script src="<%=request.getContextPath()%>/jsp/js/js/jquery-1.8.2.min.js" type="text/javascript">
	</script>
	<script src="<%=request.getContextPath()%>/jsp/js/js/languages/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8">
	</script>
    
	<script src="<%=request.getContextPath()%>/jsp/js/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
	</script>
    <link href="<%=request.getContextPath()%>/jsp/css/home.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/community.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/top.css" rel="stylesheet"  type="text/css"/>
<link href="<%=request.getContextPath()%>/jsp/css/footprint.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/modify-info.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/register.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/menu.css" rel="stylesheet" media="screen" type="text/css"/>

	<script>
		jQuery(document).ready(function(){
			// binds form submission and fields to the validation engine
			jQuery("#formID").validationEngine('attach');
		});
	</script>

</head>
<body>
<div class="nav">
<div class="logo"> <a href="http://localhost:8080/CTCommunity"><img src="res/logo.jpg" width="100" height="40" /></a> </div>


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

</div >

<div id="location">
<img src="res/home.gif" class="house" />
<em >></em>
<a href="http://localhost:8080/CTCommunity">首页</a>
<em >></em>
<a href="http://localhost:8080/CTCommunity/jsp/register.jsp">注册</a>
</div>

	<s:form action="AddUser" namespace="/com/action" method="post" theme="simple" id="formID" cssClass="formular">
		 <fieldset>
			<legend>用户名</legend>
				<label>
					<s:textfield cssClass="validate[required,custom[userName]] text-input" name="User.username" id="userName"></s:textfield>
				</label>
	  	</fieldset>
	  	<fieldset>
			<legend>性别</legend>
				<p class="sex">
					<s:radio name="User.usergender" list="%{#{'1':'男','2':'女'}}" ></s:radio>
				</p>
	  	</fieldset>
		<fieldset>
			<legend>
				密码
			</legend>
				<label>
					<s:password cssClass="validate[required,custom[passWord]] text-input" name="User.password"></s:password>
				</label>
		</fieldset>
			<s:submit value="submit"></s:submit>
			
	</s:form>
</body>
</html>