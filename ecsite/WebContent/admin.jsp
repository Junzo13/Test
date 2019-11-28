<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.admin.css">
	<title>Admin画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>Admin</p>
		</div>
		<div>
			<div class="a">
				<h3>商品</h3>
				<s:form action="ItemCreateAction">
						<li>
							<s:submit value="新規登録" />
						</li>
				</s:form>
				<s:form action="ItemListAction">
						<li>
							<s:submit value="一覧表示" />
						</li>
				</s:form>
			</div>
			<div class="b">
				<h3>ユーザー</h3>
				<s:form action="UserCreateNewAction">
						<li>
							<s:submit value="新規登録" />
						</li>
				</s:form>
				<s:form action="UserListAction">
						<li>
							<s:submit value="一覧表示" />
						</li>
				</s:form>
			</div>
			<br>
			<div id="text-link">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>