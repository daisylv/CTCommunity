<%@page import="org.hns.user.dao.UserHibDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="cn.zh.utils.*" %>
<%@page import="java.io.*" %>
<%@page import="org.apache.struts2.ServletActionContext" %>
<%
String path = "/upload/image";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String fileWebroot =pageContext.getServletContext().getRealPath("/upload")+"\\";


String imageSource = request.getParameter("imageSource");//ͼƬԴ
int position=imageSource.lastIndexOf("/");
String fileName=imageSource.substring(position+1,imageSource.length());
System.out.println("!!!!!fileWebroot = " +fileWebroot);
System.out.println("!!!!!fileName = " + fileName);
//request.setAttribute("picpath", fileWebroot+fileName);

String imageW = request.getParameter("imageW");//ͼƬ��
String imageH = request.getParameter("imageH");//ͼƬ��
String imageX = request.getParameter("imageX");//ͼƬXλ��
String imageY = request.getParameter("imageY");//ͼƬYλ��

String imageRotate = request.getParameter("imageRotate");
String viewPortW = request.getParameter("viewPortW");
String viewPortH = request.getParameter("viewPortH");

String selectorX =  request.getParameter("selectorX");//ѡ����λ��X
String selectorY = request.getParameter("selectorY");//ѡ����λ��Y
String selectorW = request.getParameter("selectorW");//ѡ����λ�ÿ�
String selectorH = request.getParameter("selectorH");//ѡ����λ�ø�

System.out.println("path = " + path);
System.out.println("basepath = " + basePath);
System.out.println("fileWebroot = " + fileWebroot);
System.out.println("imageSource = " + imageSource);
System.out.println("imageW = " + imageW);
System.out.println("imageH = " + imageH);
System.out.println("imageX = " + imageX);
System.out.println("imageY = " + imageY);
System.out.println("imageRotate = " + imageRotate);//ͼƬ�ķ�ת�Ƕ�
System.out.println("selectorX = " + selectorX);
System.out.println("selectorY = " + selectorY);
System.out.println("selectorW = " + selectorW);
System.out.println("selectorH= " + selectorH);
System.out.println("viewPortW = " + viewPortW);
System.out.println("viewPortH = " + viewPortH);
System.out.println("fileWebroot = " + fileWebroot);

String suffix = imageSource.substring(imageSource.lastIndexOf(".")+1);
String cutImg = System.currentTimeMillis()+"."+suffix;
System.out.println( "suffix = " +suffix );

int cutX = 0,cutY=0;
cutX = Math.abs(Integer.parseInt(imageX)-Integer.parseInt(selectorX));
cutY =  Math.abs(Integer.parseInt(imageY)-Integer.parseInt(selectorY));

ImageUtils img = ImageUtils.load(fileWebroot+fileName);//����Դͼ
img.zoomTo(Integer.parseInt(imageW),Integer.parseInt(imageH));//����Դͼ
img.cutTo(cutX,cutY,Integer.parseInt(selectorW),Integer.parseInt(selectorH));//�ü�ͼƬ
img.save(fileWebroot+ cutImg, suffix);//����ü����ͼƬ

File cutImgfile = new File(fileWebroot + cutImg); 
//�ڴ˴���ͼƬcutImgfile�������ݿ�
System.out.println( cutImg );
System.out.println( cutImgfile.toString() );
if(cutImgfile.exists()){
	out.print(cutImg);
}

org.hns.bean.User user = new org.hns.bean.User();
int id = Integer.parseInt(request.getSession().getAttribute("userid").toString());
user = UserHibDao.getuser(id);
String picpath = request.getContextPath()+"/upload/"+cutImg;
user.setPicpath(picpath);
UserHibDao.update(user);
System.out.println(user.getUserId());
System.out.println("������������������������"+user.getPicpath());
request.getSession().setAttribute("picpath", user.getPicpath());
%>
