<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/eltag" prefix="el" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页： miracle</title>
<base href="${el:basePath(pageContext.request) }" /> 
</head>
<body>
<jsp:forward page="/WEB-INF/views/page/list.jsp"></jsp:forward>
</body>
</html>