const baseUrl = "https://striveschool-api.herokuapp.com/api/product/";
const KEY =
  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDU5MDJkN2IxMTAwMTkwZTZkY2MiLCJpYXQiOjE3MDk4ODg5MTIsImV4cCI6MTcxMTA5ODUxMn0.jru2zUmCeGFbBWxER1VOVHqY3wrttGuck5V0I-JcuIE";
const container = document.getElementById("container");
let list = {};
reindirizzo = (error) => {
  container.innerHTML = `<h2 class='fw-bolder bg-Danger'>${error}Errore sul carricamento dell'id verai reindirizato alla home</h2>`;
  setTimeout(() => {
    location.href = "back-office.html";
  }, 2000);
};

function visualizza() {
  container.innerHTML = `<div class='row justify-content-center'></div>`;
  for (elem of list) {
    // console.log(elem);
    container.lastChild.innerHTML += `
    <div class='col-sm-6 col-md-4 col-lg-3 col-xxl-2'> 
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
        <div class="card-body d-flex justify-content-between">
        <a href="back-office.html?id=${elem._id}" class="card-link">Modifica</a>
        <a href="dettaglio.html?id=${elem._id}" class="card-link">INFO</a>
        </div>
    </div>
    </div>
`;
  }
}
async function visualProd() {
  document
    .querySelector(".spinner")
    .setAttribute("class", " spinner d-flex justify-content-center");
  try {
    let load = await fetch(baseUrl, {
      headers: {
        Authorization: KEY,
      },
    });
    list = await load.json();
    document.querySelector(".spinner").remove();
    console.log(list);
    /* se non c'è nessun articolo passa subito al Post */
    if (list.length === 0) {
      /* controllo esterno se per qualche motivo l'arry è vuoto rindirizza alla funzione di Post */
      reindirizzo("vuoto carica il prodotto non trovo nulla");
    } else visualizza();
  } catch (error) {
    console.log(error);
    reindirizzo(error);
  }
}
window.addEventListener("load", init);
function init() {
  /* visualizza prodotti */

  visualProd();
}
