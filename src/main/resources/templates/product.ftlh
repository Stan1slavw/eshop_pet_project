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

<form action="/" method="get">
	Поиск по названию товара: <input type="text" name="title"><br>
	<input type="submit" value="Поиск"/>
</form>
<br><br>
<#list products as products>
    <div>
	    <p><b>${products.title}</b>${products.price} | <a href="/product/${products.id}">Подробнее...</a></p>
    </div>
	<#else>
		<h3>Товаров нет</h3>
</#list>
<br><br>

<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
	Название объявления: <input type="text" name="title"/><br><br>
	Описание объявления: <input type="text" name="description"/><br><br>
	Цена: <input type="number" name="price"/><br><br>
	Город: <input type="text" name="city"/><br><br>
	Имя автора: <input type="text" name="author"/><br><br>
	Первая фотография: <input type="file" name="file1"/><br><br>
	Вторая фотография: <input type="file" name="file2"/><br><br>
	Третья фотография: <input type="file" name="file3"/><br><br>

	<input type="submit" value="Добавить товар">
</form>
</body>
</html>