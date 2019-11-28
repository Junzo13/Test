<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
</head>
<body>
	<h1>ログイン画面</h1>
	<s:form action="LoginAction">
	<table>
		<tr>
			<td>ユーザー名<s:textfield name="name"/></td>
		</tr>
		<tr>
			<td>パスワード<s:password name="password"/></td>
		</tr>
		<tr>
			<td><s:submit value="ログイン"/></td>
		</tr>
	</table>
	</s:form>
</body>
</html>