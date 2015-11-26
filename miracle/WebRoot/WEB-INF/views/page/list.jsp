<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/eltag" prefix="el" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
<base href="${el:basePath(pageContext.request) }" /> 

<link rel="stylesheet" type="text/css" href="resource/css/main.css">

<script type="text/javascript" src="resource/js/jquery.js"></script>
<script type="text/javascript" src="resource/js/utils.js"></script>
<script type="text/javascript" src="resource/js/main.js"></script>

</head>
<body>
<div id="content">

	<div id="queryDiv">
		<div id="query-params">
			<input type="text" id="id" class="field" placeholder="ID" /> 
			<input type="text" id="name" class="field"  placeholder="名称" /> 
			<input type="text" id="age" class="field"  placeholder="年龄" /> 
			<button id="query-btn" class="query-btn">查询</button>
		</div>
		
		<div id="queryReqult">
			<span>每页</span><input type="text" id="pageSize" /><span>条记录！</span>
			<span style="margin-left:15px;">共 <span id="totalRecords"></span> 条记录， <span id="totalPages"></span> 页！</span> 
			<span style="margin-left:15px;">显示 第 <span id="currentPage"></span> 页，第 <span id="startRecord"></span> 至	<span id="endRecord"></span> 条记录！</span>
		</div>
	</div>

	<div id="listDiv">
		<table>
			<thead>
				<tr><th>ID</th><th>用户名</th><th>年龄</th></tr>
			</thead>
			<tbody id="list">
				
			</tbody>
		</table>
	</div>
		
	<div id="pageNav">
	</div>
</div>
</body>
</html>