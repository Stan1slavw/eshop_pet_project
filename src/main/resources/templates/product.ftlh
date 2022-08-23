<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
	<meta charset="UTF-8">
	<title>Books</title>
	<link rel="stylesheet" th:href="@{/css/generalStyle.css}">
</head>
<body>

<center><h1>All Products</h1></center>

<#list products as products>
    <div>
	    <p><b>${products.title}</b>${products.price} | <a href="/product/${products.id}">Подробнее...</a></p>
    </div>
</#list>

<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
	Название объявления: <input type="text" name="title"/><br><br>
	Описание объявления: <input type="text" name="description"/><br><br>
	Цена: <input type="number" name="price"/><br><br>
	Город: <input type="text" name="city"/><br><br>
	Имя: <input type="text" name="author"/><br><br>
	<input type="submit" value="Добавить товар">
</form>
</body>
</html>