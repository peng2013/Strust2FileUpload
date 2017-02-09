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
    
    <title>上传多个文件</title>
    <script type="text/javascript">
    //实现动态添加文件域功能
   function addFile()
   {
        var uploadHTML = document.createElement( "INPUT");
        uploadHTML.setAttribute("type", "file");
        uploadHTML.setAttribute("name","upload");
        document.body.appendChild(uploadHTML);
        var uploadHTML=document.createElement("TR");
        document.form.appendChild(uploadHTML);
   }
    </script>

  </head>
  
  <body>
     <s:fielderror>
        <input type="button" onclick="addFile();" value="添加文件">
        <!-- form表单 -->
        <s:form action="UploadMoreListAction" enctype="multipart/form-data">
           <span id="files"><input type="file" name="upload"></span>
           <input type="submit" value="上传" style="width: 50px">
        </s:form>
     </s:fielderror>
  </body>
</html>
