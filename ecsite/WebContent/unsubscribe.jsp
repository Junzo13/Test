<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>Unsubscribe画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>Unsubscribe</p>
		</div>
		<div>
			<s:if test="unsubscribeList==null">
			</s:if>
			<s:elseif test="message==null">
				<h3>退会情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>ユーザーID</th>
						<th>パスワード</th>
						<th>ユーザー名</th>
						<th>メールアドレス</th>
					</tr>
					<s:iterator value="unsubscribeList">
						<tr>
							<td><s:property value="loginId" /></td>
							<td><s:property value="loginPass" /></td>
							<td><s:property value="userName" /></td>
							<td><s:property value="userMail" /></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="UnsubscribeAction">
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="退会する" />
				</s:form>
			</s:elseif>
			<s:if test="message!=null">
				<h3><s:property value="message" /></h3>
			</s:if>
			<div id="text-right">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>