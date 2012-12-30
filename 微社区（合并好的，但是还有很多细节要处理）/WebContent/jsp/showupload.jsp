<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>cut</title>
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


<table border="2">
	<tr>
		<td align="center">原图</td><td align="center">剪裁图</td>
	</tr>
	<tr>
		<td align="center"><div id="crop_container2"></div></td><td align="center"> <div id="result_image"></div></td>
	</tr>

</table>


   <div class="btn"> 
      <input type="button" class="btn" id="crop" value="剪裁" /> 
     <a href="<s:url action="CommunityPager" namespace="/com/action"/>?username=<s:property value="#session.username"/>&cuPage=1&page=0&cuPage2=1&page2=0&ty=<s:property value="1"/>">返回我的天地</a>
     
   </div> 
</body>
</html>
