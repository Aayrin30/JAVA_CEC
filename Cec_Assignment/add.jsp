<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
	input{
		border: none;
		border-bottom: 1px solid black;
		outline: none;
		margin-bottom: 10px;
	}
</style>

<body>
<form method="POST" action="add">
	<table>
		<tr>
			<td>Product id:</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>Product Name:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Product Quantity:</td>
			<td><input type="text" name="quantity"></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" ></td>
		</tr>
		<tr>
			<td><input type="submit" value="submit"></td>
		</tr>
	</table>
</form>
</body>
</html>