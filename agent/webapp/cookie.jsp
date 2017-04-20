<!DOCTYPE HTML><%@page import="java.util.Date"%>
<%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>cookie</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>


<%=request.getCookies() %>

<%

String index=request.getParameter("index");
int i=Integer.parseInt(index);



if(i%2==0){
//response.addCookie(new Cookie("tokies",""));
response.addCookie(new Cookie("tokies",String.valueOf(new Date().getTime())));
}else{
response.addCookie(new Cookie("tokies","0099887765454321"));
}

 %>

<p>Cookie Test</p>

</body>
</html>