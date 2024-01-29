/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
 Elenca e descrivi i principali datatype in JavaScript. Prova a spiegarli come se volessi farli comprendere a un bambino.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let liStringa='<li>stringa= una variabile di tipo stringa è un contenitore che contiene parole(char)</li>';
let liNumber='<li>Number= una variabile di tipo numerico è un contenitore che contiene numeri, può essere identificato in diversi modi come intero(integer)=2000 o come float=n^<sup>n</sup></li>';
let liBoolean='<li>bool= è una variabile che puo essere o vera o falsa</li>';
let liUndefinied='<li>è una variabile non definita cioe la scatola ha una etichetta ma non un valore</li>';
let liNull='<li>è una variabile come undefinied però è messa dal programmatore</li>';
let liObject='<li>è un contenitore di propieta, cioè contiene elementi formati da un nome e un valore comunemente chiamate key:value</li>';
let liArrey='<li>consente di memorizzare una raccolta di più elementi sotto un singolo nome di variabile, e possono contenere tipi di variabili differenti</li>'

document.getElementById('dataType').innerHTML=liStringa+liNumber+liBoolean+liUndefinied+liNull+liObject+liArrey;

/* ESERCIZIO 2
 Crea una variable chiamata "myName" e assegna ad essa il tuo nome, sotto forma di stringa.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let myName='Gianluca';
document.getElementById('myName').innerHTML=myName;
/* ESERCIZIO 3
 Scrivi il codice necessario ad effettuare un addizione (una somma) dei numeri 12 e 20.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
let prev=12+20;
let pAdizzione=document.getElementById('addizione');
pAdizzione.addEventListener('click',function(){
  let num1= prompt('inserisci il primo numero: ');
let num2= prompt('inserisci il secondo numero: ');
let totale=+num1+ +num2;
document.getElementById('addizioneP').innerHTML=(prev===totale)?'è uguale a quello inserito '+prev:'non è uguale a quello inserito';
});

// console.log(' questo è il risultato della somma ',totale, (prev===totale)?'è uguale a quello inserito '+prev:'non è uguale a quello inserito');


/* ESERCIZIO 4
 Crea una variable di nome "x" e assegna ad essa il numero 12.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let x=12;

/* ESERCIZIO 5
  Riassegna un nuovo valore alla variabile "myName" già esistente: il tuo cognome.
  Dimostra l'impossibilità di riassegnare un valore ad una variabile dichiarata con il costrutto const.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
myName='Rossi';
const COGNOME='giacchetta';
let result=console.log(COGNOME===myName)?'il cognome è uguale':"il cognome non è uguale";
console.log(result);
try{
  COGNOME=myName;
  console.log('la variabile è '+COGNOME)
}catch{
  console.log('La costante non può essere riasegnata,'+COGNOME+' posso fare un uguaglianza ma non posso riasegnare');
}

/* ESERCIZIO 6
 Esegui una sottrazione tra i numeri 4 e la variable "x" appena dichiarata (che contiene il numero 12).
*/
/* SCRIVI QUI LA TUA RISPOSTA */
x -=4;
document.getElementById('sotrazzione').innerHTML='la sotrazione risulta: '+x;

/* ESERCIZIO 7
 Crea due variabili: "name1" e "name2". Assegna a name1 la stringa "john", e assegna a name2 la stringa "John" (con la J maiuscola!).
 Verifica che name1 sia diversa da name2 (suggerimento: è la stessa cosa di verificare che la loro uguaglianza sia falsa).
 EXTRA: verifica che la loro uguaglianza diventi true se entrambe vengono trasformate in lowercase (senza cambiare il valore di name2!).
*/

/* SCRIVI QUI LA TUA RISPOSTA */
let name1='jhon',name2='Jhon';
if(name1!==name2)
console.log((name1.toLowerCase(name1)===name2.toLowerCase(name2)?name1+' è uguale a '+name2.toLowerCase(name2)+' usando lowercase':'non sono uguali neanche con il lowercase'));
else
console.log('name1:'+name1+' e uguale a name1 '+name2);