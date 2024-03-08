const nameProdotto = document.getElementById("name");
const brandProdotto = document.getElementById("brand");
const priceProdotto = document.getElementById("price");
const urlProdotto = document.getElementById("url");
const descriptionProdotto = document.getElementById("description");
const submit = document.getElementById("save");
const reset = document.getElementById("reset");

const baseUrl = "https://striveschool-api.herokuapp.com/api/product/";
const KEY =
  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZDU5MDJkN2IxMTAwMTkwZTZkY2MiLCJpYXQiOjE3MDk4ODg5MTIsImV4cCI6MTcxMTA5ODUxMn0.jru2zUmCeGFbBWxER1VOVHqY3wrttGuck5V0I-JcuIE";
// let list=[];
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
function visualizza(lista) {
  console.log(lista.price);
  console.log(lista);
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
     
    try {
     
      let put = await fetch(baseUrl+lista._id, {
        method: "PUT",
        body: JSON.stringify(baseListPut),
        headers: {
          "Content-Type": "application/json",
          Authorization: KEY,
        },
      }).then(elem=>{
        console.log(elem);
        if (elem.ok) {
            location.href = "index.html";
        }
      })
    } catch (error) {
      console.log(error);
      // location.href = "index.html";
    }
  });
  
}
settingDelete=(id)=>{/* FUNZIONE DELETE E allinizio crea il bottone elimina */
const button=`<button type="button" class="btn btn-primary" id="deleteBtn">Cancella</button>`;
document.getElementById('inserisciDelete').innerHTML+=button;

    const btnCancella = document.getElementById("deleteBtn");
    btnCancella.addEventListener('click',async()=>{
        try {
            let post = await fetch(baseUrl+id, {
              method: "DELETE",
              headers: {
                "Content-Type": "application/json",
                Authorization: KEY,
              },
            }).then(elem=>{
              console.log(elem);
              if (elem.ok) {
                  location.href = "index.html";
              }
            });
          } catch (error) {
            console.log(error);
          }


        
    })
    

}
async function modifiedProduct(id) {
  // console.log(id);
  

  document.querySelector("legend").innerText = "Modifica Prodotto";
  
  try {
    let load = await fetch(baseUrl, {
      headers: {
        Authorization: KEY,
      },
    });
    list = await load.json();
    
    // console.log(list);
    /* se è uguale a zero dopo che ho pasato id prova a rinserire un nuovo articolo */
    if (list.length === 0) {
      location.href = "back-office.html";
    } else{
     settingDelete(list[0]._id);
     visualizza(list[0]);}
  } catch (error) {
    console.log(error);
    // location.href = "";
  }
}
function addProduct() {
  document.querySelector("legend").innerText = "Aggiungi prodotto";
  submit.addEventListener("click", async function (e) {
    e.preventDefault();

    baseListPost = {
      name: nameProdotto.value,
      description: descriptionProdotto.value,
      brand: brandProdotto.value,
      imageUrl: urlProdotto.value,
      price: priceProdotto.value,
    };
    try {
      console.log(JSON.stringify(baseListPost));
      let post = await fetch(baseUrl, {
        method: "POST",
        body: JSON.stringify(baseListPost),
        headers: {
          "Content-Type": "application/json",
          Authorization: KEY,
        },
      }).then(elem=>{
        console.log(elem);
        if (elem.ok) {
            location.href = "index.html";
        }
      });
    } catch (error) {
      console.log(error);
    }
  });
}

contrlUrl = () => {
  let params = new URLSearchParams(document.location.search);
  // const id = params.get("foto");
  params.size === 0 ? addProduct() : modifiedProduct(params.get("id"));
};

window.addEventListener("load", init);
function init() {
  /* controllo url*/
  contrlUrl();
}
