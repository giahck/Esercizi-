let elenco = [];

window.addEventListener("load", init);
function init() {
  patch(); //lo faccio sotto e non a cascata cosi provo la Promise
}

async function patch() {
  await fetch("https://striveschool-api.herokuapp.com/books")
    .then((element) => {
      return element.json();
    })
    .then((element) => {
      elenco = element; //attendo 10m per carico elenco anche se non seriverebbe visto che la paggiana la iniziio diretamente dal load
      console.log(elenco);
      setTimeout(() => {
        caricoCard();
      }, 100);
    })
    .catch((err) => {
      console.log("Errore nel recupero dei dati: ", err);
    });
}

function caricoCard() {
  const container = document.getElementById("container");
  const row = document.createElement("div");
  row.setAttribute("class", "row");
  container.appendChild(row);
  for (let elem of elenco) {
    const col = document.createElement("div");
    col.setAttribute("class", "col-3 col-xl-2");
    col.innerHTML = `<div class="card pb-2 mb-3">
    <img src="${elem.img}" class="card-img-top w-100"  alt="${elem.title}">
    <div class="card-body">
      <h2 class="card-title ">${elem.title}</h2>
      <span class="card-text d-flex justify-content-between align-items-center">
        <span class='d-grid gap-1 text-center p-2' ><h3 class='m-0'>Category:</h3><h4 class='m-0'>${elem.category}</h4>
      </span>
      <span>
        <p>price $${elem.price}</p>
      </span>
      </div>
      <div class="d-flex justify-content-center ">
      <button type="button" class=" add btn btn-light mx-2" id='add' value='${elem.asin}'>Aggiungi</button>
      <button type="button" class="btn btn-danger mx-2">Elimina</button>
      </div>
  </div>`;
    row.appendChild(col);
  }
  aggiungi();
}

aggiungi = () => {
  const btnAdd = document.getElementsByClassName('add'); 

   for(const element of btnAdd){
    element.addEventListener('click',function () {
        const libro=elenco.find((elemento)=>elemento.asin===this.value);
        localStorage.setItem(`carrello${this.value}`,JSON.stringify(libro));
    })
  };
 

};
