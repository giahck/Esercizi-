const container=document.getElementById('container');
const baseUrl = "https://striveschool-api.herokuapp.com/api/product/";
const KEY =
  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDU5MDJkN2IxMTAwMTkwZTZkY2MiLCJpYXQiOjE3MDk4ODg5MTIsImV4cCI6MTcxMTA5ODUxMn0.jru2zUmCeGFbBWxER1VOVHqY3wrttGuck5V0I-JcuIE";
  let list={};
  /* funzione errore con indirizamento alla home*/
reindirizzo=(error)=>{
  container.innerHTML=`<h2 class='fw-bolder bg-Danger'>${error}Errore sul carricamento dell'id verai reindirizato alla home</h2>`
  setTimeout(()=>{
  location.href = "index.html";
  },2000);
};


createProfil=()=>{
  console.log(list);
container.innerHTML=`<div class='row'>
  <h2>Details</h2>
  <hr>
  <div class='col-sm-6 d-flex justify-content-center'>
   <img src="${list.imageUrl}" class="img-fluid" alt="...">
  </div>
  <div class='col-sm-6'>
      <div class='d-flex flex-column'>
        <h5>${list.brand}</h5>
        <h4>${list.name}</h4>
        <span class='price'><p>${list.price}$</p></span>
        <p>${list.description}</p>
      </div>
  </div>
</div>`;
}

/* carico id */
visualizza=async(id)=>{
  try {
    let load = await fetch(baseUrl+id, {
      headers: {
        Authorization: KEY,
      },
    });
    list = await load.json();
    
    // console.log(list);
    /* se list e vuoto verrai rendirizato controllo esterno se no visualizza il prodotto*/
    if (list.length === 0) {
      reindirizzo('id inesistente');
    } else{
      createProfil();
    }
  } catch (error) {
    // console.log(error);
    // reindirizzo(error);
  }
}

  window.onload=()=>{
    let params = new URLSearchParams(document.location.search);
    console.log(params.value);
    (params.size===0)? reindirizzo('id inesistente'):visualizza(params.get("id"));
    

  }

