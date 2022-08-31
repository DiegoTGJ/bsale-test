const getData = (url) => {
  $("#products").empty()
  $("#pagination").empty()
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
    for(let i = 0; i < data.totalPages; i++) {
      $(`<li class="page-item" id="page-${i}"><a class="page-link" >${i+1}</a></li>`).on("click",(event) => {
        const pageNumber = event.currentTarget.id.split("-")[1]
        if(url.includes("pageNumber")){
          getData(url.slice(0,-1)+pageNumber)
        }else{
          if(url.includes("categoryId")){
            getData(url+"&pageNumber="+pageNumber)
          }else{
            getData(url+"?pageNumber="+pageNumber)
          }
        }
      }).appendTo("#pagination")
    }
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
