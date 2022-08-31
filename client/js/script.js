const getData = (url) => {
  $.getJSON(url).done((data) => {
    $.each(data.content, (index, item) => {
     $(`<div class="card product-card p-0" style="width: 18rem;">
     <img class=" card-img-top product-img" src=${item.urlImage ? item.urlImage : "./img/image-not-found-icon.png"}></img>
     <div class="card-body">
       <h5 class="card-title">${item.name}</h5>

     </div>
     <div class="card-footer m-0">
     <small class="text-muted ">$${item.price}</small>
         <small class="text-muted "><i class="fa-solid fa-2x fa-cart-arrow-down cart-product-icon float-end"></i></small>
       </div>
   </div>`).appendTo("#products")
    })
  }).fail(() => {
    alert("Fallo la conexion con el servidor")
   })
}

$(() => {
  const productsApiURL = "http://localhost:8080/api/v1/products"
  const categoriesApiUrl = "http://localhost:8080/api/v1/categories"
  // Obtiene todos los productos y crea un card para cada producto
  getData(productsApiURL)
  // Obtiene las categorias disponibles y las agrega al dropdown de categorias
  $.getJSON(categoriesApiUrl).done((data) => {
   $.each(data, (index, item) => {
     $(`<li class="categories-item" id="category-${item.id}"><a class="dropdown-item">${item.name.toUpperCase()}</a></li>`).on("click",(event) => {
      const categoryId = event.currentTarget.id.split("-")[1]
      $("#products").empty()
      const filteredUrl = productsApiURL+"?categoryId="+categoryId
      getData(filteredUrl)
     }).appendTo("#categories-dropdown")
   })
 }).fail(() => {
   alert("Fallo la conexion con el servidor")
 })

 $("#cart-icon").on("click",(event) => {
   alert("Not Implemented")
 })

 $(document).on("click", ".cart-product-icon", () => {
  alert("Not Implemented")
 })

 })