/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
    Dato il seguente array, scrivi del codice per stampare ogni elemento dell'array in console.
*/
const pets = ["dog", "cat", "hamster", "redfish"];
stampaArray = (stampa, ese) => {
  console.log("esercizio numero:" + ese);
  console.log(stampa);
  for (let i = 0; i < pets.length; i++) {
    console.log(stampa[i]);
  }
};
stampaArray(pets, 1);
/* ESERCIZIO 2
    Scrivi del codice per ordinare alfabeticamente gli elementi dell'array "pets".
*/
ordina = () => {
  pets.sort();
  stampaArray(pets, 2);
};
ordina();
/* ESERCIZIO 3
    Scrivi del codice per stampare nuovamente in console gli elementi dell'array "pets", questa volta in ordine invertito.
*/
reversso = () => {
  pets.reverse();
  stampaArray(pets, 3);
};
reversso();
/* ESERCIZIO 4
    Scrivi del codice per spostare il primo elemento dall'array "pets" in ultima posizione.
*/
primoUltimo = () => {
  pets.push(pets.splice(0, 1).join());
  stampaArray(pets, 4);
};
primoUltimo();

/* ESERCIZIO 5
    Dato il seguente array di oggetti, scrivi del codice per aggiungere ad ognuno di essi una proprietà "licensePlate" con valore a tua scelta.
*/
const cars = [
  {
    brand: "Ford",
    model: "Fiesta",
    color: "red",
    trims: ["titanium", "st", "active"],
  },
  {
    brand: "Peugeot",
    model: "208",
    color: "blue",
    trims: ["allure", "GT"],
  },
  {
    brand: "Volkswagen",
    model: "Polo",
    color: "black",
    trims: ["life", "style", "r-line"],
  },
];
function addProp(arr) {
  for (let i = 0; i < cars.length; i++) {
    // cars[i].licensePlate=+prompt('inserisci valore licensa:');
    cars[i].licensePlate = arr[i];
  }
}
addProp([2, 3, 4]);
// console.log(cars);
/* ESERCIZIO 6
    Scrivi del codice per aggiungere un nuovo oggetto in ultima posizione nell'array "cars", rispettando la struttura degli altri elementi.
    Successivamente, rimuovi l'ultimo elemento della proprietà "trims" da ogni auto.
*/
// add={
//   brand: "alfa romeo",
//   model: "Giulietta",
//   color: "black-blue",
//   trims: ["td200", "sportiv"],
// } nel caso fosse pronto, ho fatto una funzione in modo che se dovessi aggiungerli li farei passo passo senza aprire il db faccio solo il pusch anche se a grandi numeri probabbilmente non ha senso
function updateClone(clone /* dati in ingresso*/) {
  clone.brand = "alfa romeo";
  clone.model = "Gulietta";
  clone.color = "white-blue";
  clone.trims = ["td200", "sportiv"];
}
remuveTrimsElement = () => {
  for (let i = 0; i < cars.length; i++) {
    cars[i].trims.pop(cars[i].trims.length);
  }
  console.log(cars);
};
function insertObj() {
  let clone;
  if (cars[0] !== null) {
    clone = { ...cars[0] };
    cars.push(clone);
    clone = updateClone(clone);
  }
  remuveTrimsElement();
}
insertObj();
/* ESERCIZIO 7
    Scrivi del codice per salvare il primo elemento della proprietà "trims" di ogni auto nel nuovo array "justTrims", sotto definito.
*/
const justTrims = [];
function addJustTrims() {
  for (let i = 0; i < cars.length; i++) {
    justTrims.unshift(
      cars[i].trims[0]
    ); /* li inserisco dalla testa perche al quizone li ho invertiti e ho sbagliato 4 domande per sta cosa quindi li uso tutti oggi cosi imparo a non confondermi */
  }
  console.log(justTrims);
}
addJustTrims();
/* ESERCIZIO 8
    Cicla l'array "cars" e costruisci un if/else statament per mostrare due diversi messaggi in console. Se la prima lettera della proprietà
    "color" ha valore "b", mostra in console "Fizz". Altrimenti, mostra in console "Buzz".
*/
cicla = () => {
  let letter = "";
  for (let i = 0; i < cars.length; i++) {
    letter = cars[i].color;
    if (letter.indexOf("b")) console.log("Fizz");
    else console.log("Buzz");
  }
};
cicla();
/* ESERCIZIO 9
    Utilizza un ciclo while per stampare in console i valori del seguente array numerico fino al raggiungimento del numero 32.
*/
const numericArray = [
  6, 90, 45, 75, 84, 98, 35, 74, 31, 2, 8, 23, 100, 32, 66, 313, 321, 105,
];
let index = 0;
while (numericArray[index] !== 32) {
  console.log(numericArray[index]);
  index++;
}

/* ESERCIZIO 10
    Partendo dall'array fornito e utilizzando un costrutto switch, genera un nuovo array composto dalle posizioni di ogni carattere all'interno
    dell'alfabeto italiano.
    es. [f, b, e] --> [6, 2, 5]
*/
const charactersArray = ["g", "n", "u", "z", "d"];
const arrayNew = [];
for (let i = 0; i < charactersArray.length; i++) {
  switch (charactersArray[i]) {
    case "a":
      arrayNew.push(1);
      break;
    case "b":
      arrayNew.push(2);
      break;
    case "c":
      arrayNew.push(3);
      break;
    case "d":
      arrayNew.push(4);
      break;
    case "e":
      arrayNew.push(5);
      break;
    case "f":
      arrayNew.push(6);
      break;
    case "g":
      arrayNew.push(7);
      break;
    case "h":
      arrayNew.push(8);
      break;
    case "i":
      arrayNew.push(9);
      break;
    case "l":
      arrayNew.push(10);
      break;
    case "m":
      arrayNew.push(10);
      break;
    case "n":
      arrayNew.push(11);
      break;
    case "o":
      arrayNew.push(12);
      break;
    case "p":
      arrayNew.push(13);
      break;
    case "q":
      arrayNew.push(14);
      break;
    case "r":
      arrayNew.push(15);
      break;
    case "s":
      arrayNew.push(16);
      break;
    case "t":
      arrayNew.push(17);
      break;
    case "u":
      arrayNew.push(18);
      break;
    case "v":
      arrayNew.push(19);
      break;
    case "z":
      arrayNew.push(20);
      break;

    default:
      break;
  }
}
console.log(arrayNew);
/* prova altra maniera ma è da finire  */
// const alfabeto=["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"];
// const arrayNew = [];

// for (arr2 of charactersArray) {
//   for (let i = 0; i < alfabeto.length; i++){
//     switch (arr2===alfabeto[i]) {
//       case alfabeto[i]:
//         arrayNew=i++;
//         break;

//       default:
//         break;
//     }
//   }
// }
// console.log(arrayNew);