<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
	<meta charset="UTF-8">
	<title>Product</title>
	<link rel="stylesheet" th:href="@{/css/generalStyle.css}">
</head>
<body>

<center><h1>Product №${product.id}</h1></center>
<br><br>
<h3>Сведения о товаре</h3>
<#list images as img>
	<img src="/images/${img.id}" height="60px"/><br><br>
</#list>

<b>Название товара: ${product.title}</b><br>
<b>Полное описание товара: ${product.description}</b><br>
<b>Цена товара: ${product.price}</b><br>
<b>Автор объявления: ${product.author}</b><br>
<b>Город отправителя: ${product.city}</b><br>

<br><br>
<form action="/product/delete/${product.id}" method="post">
	<input type="submit" value="Удалить товар">
</form>
</body>
</html>