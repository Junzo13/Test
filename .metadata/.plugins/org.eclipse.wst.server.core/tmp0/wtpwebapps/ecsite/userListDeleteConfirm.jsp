<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>UserListDeleteConfirm画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>UserListDeleteConfirm</p>
		</div>
		<h3>ユーザー情報を削除しますか。</h3>
		<div>
			<s:if test="userList==null">
				<s:form action="UserListDeleteCompleteAction">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="OK" />
				</s:form>
				<s:form action="UserListAction">
					<s:submit value="CANCEL" />
				</s:form>
			</s:if>
			<s:if test="message!=null">
				<h3><s:property value="message" /></h3>
			</s:if>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>