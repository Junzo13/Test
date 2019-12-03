<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>UserList画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>
		<div>
			<s:if test="userList==null or userList.size() == 0">
				<h3>ユーザー情報はありません。</h3>
			</s:if>
			<s:elseif test="message==null">
				<h3>ユーザー情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>ログインID</th>
						<th>パスワード</th>
						<th>ユーザー名</th>
						<th>メール</th>
					</tr>
					<s:iterator value="userList">
						<tr>
							<td><s:property value="loginId" /></td>
							<td><s:property value="loginPass" /></td>
							<td><s:property value="userName" /></td>
							<td><s:property value="userMail" /></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="UserListDeleteConfirmAction">
					<s:submit value="削除" />
				</s:form>
			</s:elseif>
			<s:if test="message!=null">
				<h3><s:property value="message" /></h3>
			</s:if>
			<div id="text-right">
				<p>管理者画面へ戻る場合は<a href='<s:url action="AdminAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>