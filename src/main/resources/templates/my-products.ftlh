<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Мои товары</h1>
    <hr>
    <a class="custom-btn2 btn-2" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить новый товар
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/product/create" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="productName">Название товара</label>
                <input type="text" required class="form-control"
                       id="productName" name="title">
            </div>
            <div class="form-group">
                <label for="price">Цена товара</label>
                <div class="input-group mb-3">
                    <input type="number" required class="form-control" id="price" name="price">
                    <div class="input-group-append">
                        <span class="input-group-text">₴</span>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="searchCity">Город</label>
                <select id="searchCity" required name="city" class="form-control">
                    <option value="">Город не выбран</option>

                    <option value="Киев">Киев</option>
                    <option value="Харьков">Харьков</option>
                    <option value="Львов">Львов</option>

                </select>
            </div>
<#--///////////////////////-->
            <div class="form-group">
                <label for="searchCategory">Категория товара</label>
                <select id="searchCategory" required name="category" class="form-control">
                    <option value="">Категория не выбрана</option>

                    <option value="Компьютерная Техника">Компьютерная техника</option>
                    <option value="Аксессуары">Аксессуары</option>
                    <option value="Телефоны">Телефоны</option>

                </select>
            </div>
<#--     /////////////////////////////////       -->
            <div class="form-group">
                <label for="description">Описание товара</label>
                <textarea required class="form-control" id="description" name="description"></textarea>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file1" class="form-control" id="file1">
                    <label for="file1" class="form-label">Первая фотография к товару</label>
                </div>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file2" class="form-control" id="file2">
                    <label for="file2" class="form-label">Вторая фотография к товару</label>
                </div>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file3" class="form-control" id="file3">
                    <label for="file3" class="form-label">Третья фотография к товару</label>
                </div>
<#--                <div class="custom-file">-->
<#--                    <input type="file" name="file3" id="file3">-->
<#--                    <label class="custom-file-label" for="file3">Третья фотография к товару</label>-->
<#--                </div>-->
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
    </div>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <#list products as product>
            <a href="/product/${product.id}" class="product-link">
                <div class="card text-white bg-dark my-3 product" style="width: 20rem;">
                    <div class="card-top">
                        <form action="/product/delete/${product.id}" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button type="submit" class="btn btn-danger m-3">
                                Удалить
                            </button>
                        </form>
                    </div>
                    <img src="/images/${product.previewImageId}"
                         class="card-img-top img">
                    <div class="card-body">
                        <h5 class="card-title">${product.title}</h5>
                        <p class="card-text">${product.price} ₴</p>
                        <p class="card-text">${product.category}</p>
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
</@t.template>