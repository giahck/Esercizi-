const nameProdotto = document.getElementById("name");
const brandProdotto = document.getElementById("brand");
const priceProdotto = document.getElementById("price");
const urlProdotto = document.getElementById("url");
const descriptionProdotto = document.getElementById("description");
const submit = document.getElementById("save");
const reset = document.getElementById("reset");
const linkRegex =
  /https?:\/\/(?:www\.)?[a-zA-Z0-9-]+\.[a-zA-Z]{2,}(?:\/[^\s]*)?/; /* controllo il link */
const baseUrl = "https://striveschool-api.herokuapp.com/api/product/";
const KEY =
  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDU5MDJkN2IxMTAwMTkwZTZkY2MiLCJpYXQiOjE3MDk4ODg5MTIsImV4cCI6MTcxMTA5ODUxMn0.jru2zUmCeGFbBWxER1VOVHqY3wrttGuck5V0I-JcuIE";

reindirizzo = (error) => {
  container.innerHTML = `<h2 class='fw-bolder bg-Danger'>${error}Errore sul carricamento dell'id verai reindirizato alla home</h2>`;
  setTimeout(() => {
    location.href = "index.html";
  }, 2000);
};
function visualizza(lista) {
  nameProdotto.value = lista.name;
  brandProdotto.value = lista.brand;
  urlProdotto.value = lista.imageUrl;
  priceProdotto.value = lista.price;
  descriptionProdotto.value = lista.description;
  submit.addEventListener("click", async (e) => {
    e.preventDefault();
    baseListPut = {
      name: nameProdotto.value,
      description: descriptionProdotto.value,
      brand: brandProdotto.value,
      imageUrl: urlProdotto.value,
      price: priceProdotto.value,
    };
    let conferma = window.confirm(
      "sei sicuro di modificare il prodotto"
    ); /* allert sul put */
    if (conferma)
      try {
        let put = await fetch(baseUrl + lista._id, {
          method: "PUT",
          body: JSON.stringify(baseListPut),
          headers: {
            "Content-Type": "application/json",
            Authorization: KEY,
          },
        }).then((elem) => {
          if (elem.ok) {
            location.href = "index.html";
          }
        });
      } catch (error) {
        //   console.log(error);
        reindirizzo(" non è valido");
      }
  });
}
settingDelete = (id) => {
  /* FUNZIONE DELETE E allinizio crea il bottone elimina */
  const button = `<button type="button" class="btn btn-primary" id="deleteBtn">Cancella</button>`;
  document.getElementById("inserisciDelete").innerHTML += button;

  const btnCancella = document.getElementById("deleteBtn");
  btnCancella.addEventListener("click", async () => {
    let conferma = window.confirm("sei sicuro di voler cancellare il prodotto");
    if (conferma)
      try {
        let post = await fetch(baseUrl + id, {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json",
            Authorization: KEY,
          },
        }).then((elem) => {
          if (elem.ok) {
            location.href = "index.html";
          }
        });
      } catch (error) {
        console.log(error);
        reindirizzo("delete not work ");
      }
  });
};
async function modifiedProduct(id) {
  controlloCampi();
  document
    .querySelector(".spinner")
    .setAttribute("class", " spinner d-flex justify-content-center");
  document.querySelector("legend").innerText = "Modifica Prodotto";
  try {
    let load = await fetch(baseUrl + id, {
      headers: {
        Authorization: KEY,
      },
    });
    list = await load.json();
    document.querySelector(".spinner").remove();
    /* se è uguale a zero dopo che ho pasato id prova a rinserire un nuovo articolo */
    if (list.length === 0) {
      location.href = "back-office.html";
    } else {
      settingDelete(list._id);
      visualizza(list);
    }
  } catch (error) {
    console.log(error);
    reindirizzo("modifiche non è valido");
  }
}

controlloCampi = () => {
  /* ho fatto in modo che se non c'è il valore correto diventa il bordo rosso e non sblocca la casella di sotto scrivi sul nome e si sblocca il bordo e cosi via*/
  nameProdotto.addEventListener("blur", function () {
    if (!this.value) {
      brandProdotto.disabled = true;
      nameProdotto.setAttribute("class", "border border-danger form-control");
    } else {
      brandProdotto.disabled = false;
      nameProdotto.setAttribute("class", "form-control");
    }
  });
  brandProdotto.addEventListener("blur", function () {
    if (!this.value) {
      priceProdotto.disabled = true;
      brandProdotto.setAttribute("class", "border border-danger form-control");
    } else {
      priceProdotto.disabled = false;
      brandProdotto.setAttribute("class", "form-control");
    }
  });
  priceProdotto.addEventListener("blur", function () {
    if (+priceProdotto.value === 0) {
      priceProdotto.setAttribute("class", "border border-danger form-control");
      urlProdotto.disabled = true;
    } else {
      priceProdotto.setAttribute("class", "form-control");
      urlProdotto.disabled = false;
    }
  });

  urlProdotto.addEventListener("blur", function () {
    if (!linkRegex.test(urlProdotto.value)) {
      descriptionProdotto.disabled = true;
      urlProdotto.setAttribute("class", "border border-danger form-control");
    } else {
      descriptionProdotto.disabled = false;
      urlProdotto.setAttribute("class", "form-control");
    }
  });
  descriptionProdotto.addEventListener("blur", function () {
    if (!this.value) {
      submit.disabled = true;
      descriptionProdotto.setAttribute(
        "class",
        "border border-danger form-control"
      );
    } else {
      submit.disabled = false;
      descriptionProdotto.setAttribute("class", "form-control");
    }
  });

  /* ho risscritto tutto il conrollo perche in questa maniera non aveva senso, complicato inutilmente 10 min */
  // for(let obj in lista){

  //         switch (obj) {
  //             case 'name':
  //                 if (lista[obj]==='') nameProdotto.setAttribute('class','border border-danger form-control');
  //                 document.getElementById('name').addEventListener('blur', function() {
  //                 if(!this.value){
  //                     nameProdotto.setAttribute('class','border border-danger form-control');
  //                 }
  //                     else
  //                     nameProdotto.setAttribute('class','form-control');
  //                 })
  //                 break;
  //             case 'brand':
  //                 if (lista[obj]==='')     brandProdotto.setAttribute('class','border border-danger form-control');
  //                 document.getElementById('brand').addEventListener('blur', function() {
  //             (!this.value)? brandProdotto.setAttribute('class','border border-danger form-control'): brandProdotto.setAttribute('class','form-control');
  //                     })
  //                 break;
  //             case 'price':/* faccio un controllo del prezzo se sta a zero non va bene  */
  //                 document.getElementById('price').addEventListener('blur', function() {

  //                 if (+this.value===0)
  //                 priceProdotto.setAttribute('class','border border-danger form-control');
  //                         else
  //                 priceProdotto.setAttribute('class','form-control');
  //             });
  //                 break;
  //             case 'imageUrl':
  //                if(!linkRegex.test( document.getElementById('url').value)){
  //                 submit.disabled=true;
  //                urlProdotto.setAttribute('class','border border-danger form-control');
  //                document.getElementById('url').addEventListener('blur', function() {
  //                 submit.disabled=false;
  //                })
  //             }
  //                else{
  //               urlProdotto.setAttribute('class','form-control');
  //             }
  //                 break;
  //             case 'description':
  //                 /* l'ho lascio opzionale */
  //                 break;

  //             // default:
  //             //     break;
  //         }
  // }
};
function addProduct() {
  /* non c'è id quindi modifico il testo della legend del form*/
  document.querySelector("legend").innerText = "Aggiungi prodotto";
  /* attivo il tasto slva assicrono*/
  controlloCampi();
  submit.addEventListener("click", async function (e) {
    e.preventDefault();

    baseListPost = {
      name: nameProdotto.value,
      description: descriptionProdotto.value,
      brand: brandProdotto.value,
      imageUrl: urlProdotto.value,
      price: priceProdotto.value,
    };

    document
      .querySelector(".spinner")
      .setAttribute("class", " spinner d-flex justify-content-center");

    try {
      /* doppio controllo */ let post = await fetch(baseUrl, {
        method: "POST",
        body: JSON.stringify(baseListPost),
        headers: {
          "Content-Type": "application/json",
          Authorization: KEY,
        },
      }).then((elem) => {
        if (!elem.ok) {
          document.querySelector(".spinner").remove();
          reindirizzo("aggiungi non è valido");
        } /* buon fine */ else location.href = "index.html";
      });
    } catch (error) {
      console.log(error);
    }
  });
}

contrlUrl = () => {
  /* se url ha id allora modifico se no aggiungo */
  let params = new URLSearchParams(document.location.search);
  // const id = params.get("foto");
  console.log(params.size);
  params.size === 0 ? addProduct() : modifiedProduct(params.get("id"));
};

window.addEventListener("load", init);
function init() {
  /* controllo url*/
  contrlUrl();
}
