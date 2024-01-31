/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
let button=document.getElementById('es1');
button.addEventListener('click',function(){
let num1= prompt('inserisci il primo numero: ');
let num2= prompt('inserisci il secondo numero: ');

if(num1>num2)
  document.getElementById('p1').innerHTML='il numero più grande inserito è: '+num1;
else if(num2>num1)
document.getElementById('p1').innerHTML='il numero più grande inserito è: '+num2;
else
document.getElementById('p1').innerHTML=num1+'e uguale '+num2;

console.log(Math.max(num1,num2));
 });

/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
let esercizio2=6;
if(esercizio2!==5)console.log('not equal');

let button2=document.getElementById('es2');
button2.addEventListener('click',function(){
let numF= prompt('inserisci il primo numero: ');

if(+numF!==5)
  document.getElementById('p2').innerHTML='il numero è diverso da 5: '+numF;
else
  document.getElementById('p2').innerHTML='il numero è uguale a 5: '+numF;

 });

/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let button3=document.getElementById('es3');
button3.addEventListener('click',function(){
let numD= prompt('inserisci il primo numero: ');

if((numD%5)===0)
  document.getElementById('p3').innerHTML=numD+' è divisibile per 5' ;
else
document.getElementById('p3').innerHTML=numD+' non è divisibile';
});
/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
let button4=document.getElementById('es4');
button4.addEventListener('click',function(){
  let numO= prompt('inserisci il primo numero: ');
  let numO2= prompt('inserisci il secondo numero: ');
let sotrazzione=+numO- +numO2;
  if(+numO===8 || +numO2===8){
    // console.log(numO+' '+numO2);
      document.getElementById('p4').innerHTML=(numO===8)?'val 1 è uguale a 8':'val 2 è uguale a 8';
    }else if((+numO+ +numO2)===8){
      document.getElementById('p4').innerHTML='la somma è uguale a 8'/*+ (+numO+ +numO2) */;
    }else if(sotrazzione===8){
      document.getElementById('p4').innerHTML='la sotrazzione è uguale a 8'/*+ (+numO+ +numO2) */;
    }else  document.getElementById('p4').innerHTML='8 non esiste';
});
/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const carrello=[
  {
    nome:'lampada',
    prezzo:25,
  },
  {
    nome:'letto',
    prezzo:100,
  },
  {
    nome:'armadio',
    prezzo:55,
  },
  totalShoppingCart={
    totale: 0,
  },
];
let button5=document.getElementById('es5');
button5.addEventListener('click',function(){
  let numE= prompt('inserisci tipo prodotto da 1 a 3: ');
    if(carrello[+numE-1].prezzo<50){
      totalShoppingCart.totale=carrello[+numE-1].prezzo+10;
      document.getElementById('p5').innerHTML='il costo totale è di '+totalShoppingCart.totale;
    }else{
    totalShoppingCart.totale=carrello[+numE-1].prezzo;
     document.getElementById('p5').innerHTML='il costo totale è di '+totalShoppingCart.totale+'spedizione gratis';
    }

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/
/* SCRIVI QUI LA TUA RISPOSTA  continuo la parte di sopra(mi vengono inmente troppe cose)*/
console.log(totalShoppingCart.totale);
totalShoppingCart.totale=totalShoppingCart.totale-((20/100)*totalShoppingCart.totale);
let button6=document.getElementById('es6');
button6.addEventListener('click',function(){
document.getElementById('p6').innerHTML=totalShoppingCart.totale+' questo è scontato del 20%';

});
});


/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let ordina = document.getElementById("p7");
let var1 = 1005, var2 = 550, var3 = 1500;
if (var1 > var2 && var1 > var3) {
  (var2>var3)?
          ordina.innerHTML = "ordinato var1=" + var1 + " var 2=" + var2 + " var 3=" + var3:
          ordina.innerHTML='ordinato var1='+var1+' var 3='+var3+' var 2='+var2;
}
  if(var2>var1&&var2>var3){
    (var1>var3)?
          ordina.innerHTML='ordinato var2='+var2+' var1='+var1+' var3='+var3:
          ordina.innerHTML='ordinato var2='+var2+' var3='+var3+' var1='+var1;
  }
  if(var3>var1&&var3>var2){
    (var2>var1)?
          ordina.innerHTML='ordinato var3='+var3+' var2='+var2+' var3='+var1:
          ordina.innerHTML='ordinato var3='+var3+' var3='+var1+' var1='+var2;
  }
/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let box=1;
  if(typeof(box)==='number'){
    document.getElementById('p8').innerHTML=box+' è un numero';
  }else if(typeof(box)==='string')
  document.getElementById('p8').innerHTML=box+' è una stringa';


/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/
/* SCRIVI QUI LA TUA RISPOSTA */
let button9=document.getElementById('es9');
button9.addEventListener('click',function(){
  let numP= prompt('inserisci il primo numero: ');
   if((+numP%2)===0)
     document.getElementById('p9').innerHTML=numP+' è pari';
  else
      document.getElementById('p9').innerHTML=numP+' è dispari';
});
/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  let val = 7
  if (val < 10) {
      console.log("Meno di 10");
    } else if (val < 5) {
      console.log("Meno di 5");
    } else {
      console.log("Uguale a 10 o maggiore");
    }
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let val = 10;
if (val < 10&&val>=5) {
    console.log("Meno di 10");
  } else if (val < 5) {
    console.log("Meno di 5");
  } else {
    console.log("Uguale a 10 o maggiore");
  }
/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
  name: 'John',
  lastName: 'Doe',
  skills: ['javascript', 'html', 'css'],
}
/* SCRIVI QUI LA TUA RISPOSTA */
me.city='toronto';
console.log(me);

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/
/* SCRIVI QUI LA TUA RISPOSTA */
delete me.lastName;
console.log(me);
/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/
/* SCRIVI QUI LA TUA RISPOSTA */
 me.skills.pop();
console.log(me);
/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
  */
 /* SCRIVI QUI LA TUA RISPOSTA */
 let ar=[];
 for (let i = 1; i <= 10; i++) {
  ar[i] = i;
 }
 document.getElementById('p14').innerHTML=ar;
/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
ar[9]=100;
console.log(ar[9]);
