<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>ItemList画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>
		<div>
			<s:if test="itemList==null">
				<h3>登録商品はありません。</h3>
			</s:if>
			<s:elseif test="message==null">
				<h3>登録商品は以下になります。</h3>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>在庫個数</th>
					</tr>
					<s:iterator value="itemList">
						<tr>
							<td><s:property value="itemName" /></td>
							<td><s:property value="itemPrice" /><span>円</span></td>
							<td><s:property value="itemStock" /><span>個</span></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="ItemListDeleteConfirmAction">
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