<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>ItemListDeleteComplete画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>ItemListDeleteComplete</p>
		</div>
		<div>
			<s:if test="message!=null">
				<h3><s:property value="message" /></h3>
			</s:if>
			<div id="text-right">
				<p><a href='<s:url action="AdminAction" />'>管理者画面へ</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>