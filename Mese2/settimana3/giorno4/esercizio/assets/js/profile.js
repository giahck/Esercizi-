const baseURL = "https://api.pexels.com/v1/photos/";
window.addEventListener("load", imgLoaded);
function imgLoaded() {
  let params = new URLSearchParams(document.location.search);
  const id = params.get("foto");
  try {
    fetch(baseURL + id, {
      headers: {
        Authorization:
          "TXAl4tsq0AH939vI13rKvpyMo7xSgfkSwtTUiEnLKjjvEI0zqABAVoL5",
      },
    })
      .then((foto) => {
        console.log(foto);
        if (foto.status === 200) {
          return foto.json();
        } else {
          throw new Error("Errore img caricato");
        }
      })
      .then((foto) => {
        caricaImg(foto);
      });
  } catch (error) {
    console.log(error);
    location.href = "pexels-start.html";
  }
}
caricaImg = (foto) => {
    console.log(foto);
  const div = document.querySelector(".row.text-center.justify-content-center");
  div.innerHTML = `<div class='col-2'>
                <a href=${foto.photographer_url}><h3>foto di ${foto.photographer}</h3></a>
                <a href="./pexels-start.html">INDIETRO</a>
                </div>
                <div class='col-10'>
                    <img src="${foto.src.large}" class="img-fluid" alt="${foto.photographer}">
                </div>`;
};
