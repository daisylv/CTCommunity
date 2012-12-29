　　　<%@ page contentType="text/html;charset=UTF-8" %>
　　　<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>upload</title>
<link href="js/jquery-ui-1.8.12.custom.css" rel="Stylesheet" type="text/css" />  
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.12.custom.min.js"></script> 
<script type="text/javascript" src="js/jquery.cropzoom.js"></script>
<link href="css/home.css" rel="stylesheet" type="text/css"> 
<link href="css/community.css" rel="stylesheet" type="text/css"> 
<link href="css/top.css" rel="stylesheet"  type="text/css"/>
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
<script>
function viewImage(imgObj, imgBoxId, width, height) {
//检查文件格式
if(!imgObj.value.match(/.jpg|.gif|.png|.bmp/i)){ 
alert('图片格式无效！'); 
return false; 
}
//alert(imgObj.value);
var imgBox = document.getElementById(imgBoxId);
if (window.navigator.userAgent.indexOf("MSIE") > 0) {
//IE内核浏览器
viewImgForIE(imgObj, imgBox, width, height);
} else {
//其他内核浏览器使用html5预览
viewImgForOther(imgObj, imgBox, width, height);
}
}

function viewImgForIE(imgObj, imgBox, width, height) {
if (navigator.appVersion.match(/6./i)=="6.") {
//IE6.0 直接显示
imgBox.innerHTML = "<img src=\"file:\\\\" + imgObj.value + "\" width=\"80 \" height=\"60\" /> " ;
} else {
//IE6.0以上版本 使用滤镜
if (typeof width === 'undefined') {
imgBox.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image)";
imgBox.style.width = '100px'; //无效值，但若不赋值IE不显示，暂时没找到原因
imgBox.style.height = '100px';
} else {
imgBox.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
imgBox.style.width = width;
imgBox.style.height = height;
}
imgBox.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgObj.value;
}
}

function viewImgForOther(imgObj, imgBox, width, height) {
//其他内核浏览器使用HTML5进行预览
if (typeof FileReader === 'undefined') {
alert('Your browser does not support FileReader...');
return;
}

var reader = new FileReader();
reader.onload = function(e) {
var imgHtml = '<img src="' + this.result + '"';
if (typeof width != 'undefined') imgHtml += ' width="' + width + '" height="' + height + '"';
imgHtml += '>';

imgBox.innerHTML = imgHtml;
}
reader.readAsDataURL(imgObj.files[0]);

 
}



       
</script>

</head>
<body>
<a id="returnTop" href="javascript:;">回到顶部</a> 
<script src="js/jquery-1.6.4.min.js" type="text/javascript"></script> 
<script src="js/top.js" type="text/javascript"></script>
<div class="nav">
<div class="logo"> <a href="home.html"><img src="res/logo.jpg" width="100" height="40" /></a> </div>


<div class="userId">
<ul id="jsddm">
	<li><a href="footprint.html">用户名</a>
		<ul>
	    <li><a href="#">登出</a></li>
			<li><a href="#">我的资料</a></li>
			<li><a href="#">我的足迹</a></li>
		</ul>
	</li>
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
<a href="#">上传头像</a>
</div>
<div class="upload_div">
 <h2>上传头像：</h2>
　　　   <s:form action="fileUpload"  namespace="/com/action" method="post" enctype="multipart/form-data"> 
<br>
<s:file name="upload" label="文件1"></s:file>
<s:submit label="上传"/>
</s:form> 


　　　<s:fielderror fieldName="file"/>
</div>　　　 
　　　 </body>
</html>