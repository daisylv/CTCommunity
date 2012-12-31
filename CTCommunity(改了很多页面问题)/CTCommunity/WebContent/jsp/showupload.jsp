<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>cut</title>
<link href="<%=request.getContextPath()%>/jsp/css/home.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/community.css" rel="stylesheet" type="text/css"> 
<link href="<%=request.getContextPath()%>/jsp/css/top.css" rel="stylesheet"  type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/footprint.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/modify-info.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/jsp/css/menu.css" rel="stylesheet" media="screen" type="text/css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/jsp/js/jquery-ui-1.8.12.custom.css" rel="Stylesheet" type="text/css" />  
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/js/jquery.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/js/jquery-ui-1.8.12.custom.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/js/jquery.cropzoom.js"></script> 
<script type="text/javascript">

$(document).ready(function(){
	var picName='<%=request.getContextPath()%>/upload/<s:property value="fileInfo.targetfilename" />';
          var cropzoom = $('#crop_container2').cropzoom({
            width:500,
            height:380,
            bgColor: '#CCC',
            enableRotation:false,
            enableZoom:false,
            zoomSteps:5,
            rotationSteps:10,
            selector:{        
              centered:true,
              w:80,
              h:80,
              borderColor:'blue',
              borderColorHover:'red',
			  showPositionsOnDrag: false,
              showDimetionsOnDrag: false
            },
            image:{
                source:picName,
                width:850,
                height:700,
                minZoom:100,
                maxZoom:300,
	            startZoom:60,
                snapToContainer:true
            }
        });
        
       $('#crop').click(function(){ 
            cropzoom.send('<%=request.getContextPath()%>/jsp/crop.jsp','POST',{},function(rta){
            	
            	var pathName='<%=request.getContextPath()%>/upload/'+rta;
            
                $('#result_image').find('img').remove();
                var img = $('<img />').attr('src',pathName);
                $('#result_image').append(img);
            });
        });
        
});
       

</script>

<script type="text/javascript">

function savedb(str)
{
var xmlhttp;
if (str.length==0)
  {
  document.getElementById("txtHint").innerHTML="";
  return;
  }
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","gethint.asp?q="+str,true);
xmlhttp.send();
}
</script>
</head>
<%

	//String picpath = request.getAttribute("picpath").toString();
	//request.setAttribute("picpath", picpath);
%>
<body>
<div class="nav">
<div class="logo"> <a href="http://localhost:8080/CTCommunity/jsp/haslogin.jsp?username=<s:property value="#session.username"/>"><img src="<%=request.getContextPath()%>/jsp/res/logo.jpg" width="100" height="40" /></a> </div>



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
<a href="#">首页</a>
<em >></em>
<a href="#">上传头像</a>
</div>
<div style="position:absolute;left:15%;"> 
<table border="1">
	<tr>
		<td align="center">原图</td><td align="center">剪裁图</td>
	</tr>
	<tr>
		<td align="center"><div id="crop_container2"></div></td><td align="center"> <div id="result_image"></div></td>
	</tr>

</table>


   <div class="btn1"> 
      <input type="button" class="btn" id="crop" value="剪裁" /> 
     <a href="<s:url action="CommunityPager" namespace="/com/action"/>?username=<s:property value="#session.username"/>&cuPage=1&page=0&cuPage2=1&page2=0&ty=<s:property value="1"/>">返回我的天地查看效果</a>
     
   </div> 
   
   </div>
</body>
</html>
