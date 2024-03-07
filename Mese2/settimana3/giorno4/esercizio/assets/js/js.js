const btnLoad = document.getElementById("loadImgPrimary");
const btnLoadSecond = document.getElementById("loadImgSecondary");
const btnSearch = document.getElementById("search");

const form = document.getElementById("form");
const container = document.getElementById("container");
const baseURL = "https://api.pexels.com/v1/search?query=";

let foto = [];





async function loadImg(quantita, nomeFoto) {
  try {
    let lod = await fetch(baseURL + `${nomeFoto}&per_page=${quantita}`, {
      headers: {
        Authorization:
          "TXAl4tsq0AH939vI13rKvpyMo7xSgfkSwtTUiEnLKjjvEI0zqABAVoL5",
      },
    });
    let response = await lod.json();
    foto = response;
    console.log("buon fine img");
    setTimeout(() => {
      html();
    }, 100);
  } catch (error) {
    /* se inerore riapri la pagina iniziale */
    console.log(error);
    //  location.href = 'pexels-start.html';
  }
}

/* se spingo load */
btnLoad.addEventListener("click", (e) => {
  e.preventDefault();
  const album = document.getElementById("none");
  // console.log(this.value);
  if (foto.length <= 9)
   loadImg(9, "tree");
  else {
    foto = [];
    loadImg(9, "tree");
  }
  album.remove();
});
/* secondo load */
btnLoadSecond.addEventListener("click", (e) => {
  e.preventDefault();
  // console.log(this.value);
  if (foto.length <= 9) loadImg(9, "pc");
  else {
    foto = [];
    loadImg(9, "pc");
  }

  const album = document.getElementById("none");
  album.remove();
});

function html() {
  const row = document.createElement("div");
  row.setAttribute("class", "row");
  row.setAttribute("id", "none");
  container.appendChild(row);
  console.log(foto.photos);
  for (elem of foto.photos) {
    const url = new URL(`http://127.0.0.1:5500/pexels-start.html/profile?${elem.id}`);
    // const card=document.createElement('div')
    row.innerHTML += ` <div class="col-md-4">
   <div class="card mb-4 shadow-sm">
   <a href="${url.href}"><img 
     src="${elem.src.original}"
       class="bd-placeholder-img card-img-top"
     /></a>
     <div class="card-body">
       <h5 class="card-title">Lorem Ipsum</h5>
       <p class="card-text">
         This is a wider card with supporting text below as a natural
         lead-in to additional content. This content is a little bit
         longer.
       </p>
       <div
         class="d-flex justify-content-between align-items-center"
       >
         <div class="btn-group">
           <button
             type="button"
             class="btn btn-sm btn-outline-secondary"
           >
             View
           </button>
           <button
             type="button"
             class="btn btn-sm btn-outline-secondary "
             onclick="deleteCard(${elem.id})"
                      >
             Hide
           </button>
         </div>
         <small class="text-muted">${elem.id}</small>
       </div>
     </div>
   </div>
 </div>`;
  }
}

function deleteCard(id) {
  let num = foto.photos.findIndex((elem) => elem.id === id);
  foto.photos.splice(num,1);
  container.innerHTML='';
  html();
}
btnSearch.addEventListener('click',function(e){
    e.preventDefault();
    let value = document.getElementById('val').value;
    console.log(value);
    if(value!==''){
        container.innerHTML='';
        foto=[];
        loadImg(9,value)
    }
})