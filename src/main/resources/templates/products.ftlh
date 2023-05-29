<#import "blocks/template.ftlh" as t>
<@t.template user>
	<div class="bgcolor">
		<hr>
		<a class="custom-btn2 btn-2" style="text-align: center; width: 100px"
		   data-toggle="collapse" href="#collapseExample" role="button"
		   aria-expanded="true" aria-controls="collapseExample">
		<img class="lupa" src="/static/images/lupa.png"></a> <h1 style="text-align: center">Объявления</h1>

		<div class="collapse mb-3" id="collapseExample" style="">
			<form method="get" action="/">
				<div class="form-row">
					<div class="form-group col-md-2">
						<label for="searchCity"><b>Город</b></label>
						<select id="searchCity" name="searchCity" class="form-control">
							<option value="">${searchCity} </option>
							<option value="">Любой</option>
							<option value="Киев">Киев</option>
							<option value="Харьков">Харьков</option>
							<option value="Львов">Львов</option>
						</select>

						<br>

						<label for="searchCategory"><b>Категория</b></label>
						<select id="searchCategory" name="searchCategory" class="form-control">
							<option value="">${searchCategory} </option>
							<option value="">Любой</option>
							<option value="Компьютерная Техника">Компьютерная техника</option>
							<option value="Аксессуары">Аксессуары</option>
							<option value="Телефоны">Телефоны</option>
						</select>

						<br>

						<label for="searchPrice"><b>Максимальная сумма товара</b></label>
						<select id="searchPrice" name="searchPrice" class="form-control">
							<option value="">${searchPrice}</option>
							<option value="">Любой</option>
							<option value="1000">1000</option>
							<option value="5000">5000</option>
							<option value="15000">15000</option>
							<option value="20000">20000</option>
							<option value="50000">50000</option>
						</select>


<#--						<label for="searchPrice">Цена2.0</label>-->
<#--						<div>-->
<#--							<p><input type="range" min="0" max="50000" onchange="document.getElementById('rangeValue').innerHTML = this.value;" list="rangeList"> <span id="rangeValue">0</span></p>-->
<#--							<datalist id="searchPrice">-->
<#--								<option value="">${searchPrice}</option>-->
<#--								<option value="0" label="0">-->
<#--								<option value="2000" label="2000">-->
<#--								<option value="6000" label="6000">-->
<#--								<option value="10000" label="10000">-->
<#--								<option value="15000" label="15000">-->
<#--								<option value="25000" label="25000">-->
<#--								<option value="30000" label="30000">-->
<#--								<option value="35000" label="35000">-->
<#--								<option value="40000" label="40000">-->
<#--								<option value="45000" label="45000">-->
<#--								<option value="50000>" label="50000">-->
<#--							</datalist>-->
<#--						</div>-->


					</div>

					<div class="form-group mx-sm-3 mb-3">
						<label for="searchWord"><b>Поиск по объявлениям</b></label>
						<input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if>
						       class="form-control" id="searchWord">
						<button class="custom-btn2 btn-2">Поиск</button>
                        <#--					<button style="width: 30%" type="submit" class="btn btn-dark">Поиск</button>-->
					</div>
				</div>
			</form>
		</div>
		<hr>
		<div class="row row-cols-1 row-cols-md-3 g-4">
            <#list products as product>
				<a href="/product/${product.id}" class="product-link">
					<div class="card text-white bg-primary my-3 product" style="width: 20rem;">

						<img src="/images/${product.previewImageId}"
						     class="card-img-top img">
						<div class="card-body">
							<h5 class="card-title">${product.title}</h5>
							<p class="card-text">${product.price} ₴</p>
							<p>${product.category}</p>
							<p>Дата создания: ${product.dateOfCreated}</p>
						</div>
						<div class="card-footer">
                            ${product.city}
						</div>
					</div>
				</a>
            <#else>
				<h1 style="text-align: center">Не найдено</h1>
            </#list>
		</div>
	</div>
</@t.template>