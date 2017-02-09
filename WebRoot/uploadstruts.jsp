<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传单个文件</title>
    

  </head>
  
  <body>
     <!-- 用struts2标签编写一个表单域 -->
     <s:form action="UploadAction" enctype="multipart/form-data">
          <s:file label="上传文件" name="upload"/>
          <s:textfield label="新文件名" name="filename"/>
          <s:submit value="上传"/>
     </s:form>
  </body>
</html>
