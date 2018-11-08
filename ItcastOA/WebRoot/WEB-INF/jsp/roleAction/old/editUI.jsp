<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    
    <s:form action="role_edit">
    	<s:hidden name="id"></s:hidden>
    	<s:textfield name="name">角色名:</s:textfield><br/>
    	<s:textarea name="description">描　述:</s:textarea><br/>
    	<s:submit value="提交"></s:submit><br/>
    </s:form>
    
  </body>
</html>
