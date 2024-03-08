const baseUrl='https://striveschool-api.herokuapp.com/api/product/';
const KEY='Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDU5MDJkN2IxMTAwMTkwZTZkY2MiLCJpYXQiOjE3MDk4ODg5MTIsImV4cCI6MTcxMTA5ODUxMn0.jru2zUmCeGFbBWxER1VOVHqY3wrttGuck5V0I-JcuIE';
const container=document.getElementById('container');
let list={};
/* {
    "_id": "65eaf3562d7b1100190e7125",
    "name": "Alienware X17 R2",
    "description": "sdfsdf",
    "brand": "Dell",
    "imageUrl": "https://i.dell.com/sites/csimages/Product_Imagery/all/fp-aw-laptops-hero-a-1920x1440-v2.png",
    "price": 45,
    "userId": "65ead5902d7b1100190e6dcc",
    "createdAt": "2024-03-08T11:15:34.557Z",
    "updatedAt": "2024-03-08T11:15:34.557Z",
    "__v": 0
} */



function visualizza(){

container.innerHTML=`<div class='row justify-content-center'></div>`;
for(elem of list){
console.log(elem);



container.lastChild.innerHTML+=`
    <div class='col-sm-6 col-md-4 col-lg-3 col-xl-2'> 
        <div class="card mt-3" style="width: 100%;">
        <img class="card-img-top" src="${elem.imageUrl}" style="height: 250px;" alt="Card image cap">
        <div class="card-body">
        <h5 class="card-title">${elem.name}</h5>
        <p class="card-text">${elem.description}</p>
        </div>
        <ul class="list-group list-group-flush">
        <li class="list-group-item"><span class='fw-bold'>Brand: </span>${elem.brand}</li>
        <li class="list-group-item"><span class='fw-bold'>Price: </span>${elem.price}$</li>
        <li class="list-group-item"><span class='fw-bold'>Id Article: </span>${elem._id}</li>
        </ul>
        <div class="card-body d-flex">
        <a href="back-office.html?id=${elem._id}" class="card-link">modifica</a>
        <a href="dettaglio.html?id=${elem._id}" class="card-link">Scopri INFO</a>
        </div>
    </div>
    </div>
`
}
}
async function visualProd(){
    try {
       let load=await fetch(baseUrl, {
          headers: {
            Authorization:KEY,
          },
        });
        list =await load.json();
        console.log(list);
       /* se non c'è nessun articolo passa subito al Post */
        if(list.length===0){
        
        location.href = "back-office.html";
                }
        else
        visualizza();
      } catch (error) {
        console.log(error);
        // location.href = "";
      }
}
window.addEventListener("load", init);
function init(){
    /* visualizza prodotti */
    visualProd();
}
