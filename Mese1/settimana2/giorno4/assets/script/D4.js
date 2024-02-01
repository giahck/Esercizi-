let text;
stampa=(stampa,ese)=>{document.querySelector("#ese"+ese).innerHTML += stampa;
 text='';}

/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
const area =function(l1,l2){
    text='<p>'+l1*l2+'</p>';
stampa(text,1);
}
area(15,20);


/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
function crazySum(p1,p2){
    if (p1===p2) {
        return (p1+p2)*3;
    }
    return p1+p2;
}
stampa('<p>'+crazySum(3,5)+'</p>',2);


/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
function crazyDiff(p1){
    const p2=19;
    if(p1>19){
        return Math.abs((p1-p2)*3)
    }
    return Math.abs(p1-p2);
    
}
stampa('<p>'+crazyDiff(21)+'</p>',3);

/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
const boundary=function(n){
if((n>=20&&n<=100)||n===400)
return true;
else
return false;
}
stampa('<p>'+boundary(parseInt(400.99))+'</p>',4);
/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
function epify(stringa){
    if(stringa.indexOf('EPICOD')===0)return true;
    else
    {
        // return 'EPICODE '.concat(stringa);
        return stringa.slice(0,0)+"EPICOD "+stringa.slice(0);
    }
    
    }
    stampa('<p>'+epify('EPISCOD DF')+'</p>',5);

/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/
/* SCRIVI QUI LA TUA RISPOSTA */
function check3and7(n){
    Math.abs(n);
    if((n%3)===0||(n%7)===0)
        stampa('<p>è multiplo'+n+'</p>',6);
    else
        stampa('<p>non è multiplo'+n+'</p>',6);
}
check3and7(49);

/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/
/* SCRIVI QUI LA TUA RISPOSTA */
function reverseString(str){
    return /*unito*/str.split().reverse().join('');
    /* caso 1 */
//     if (str === "") 
//     return "";  
//   else{
//     return reverseString(str.substr(1)) + str.charAt(0);}
/* caso 2 */
// let splitato=str.split('');
// console.log(splitato);
// let reversso=splitato.reverse();
// console.log(reversso);
// let unito=reversso.join('');
}
stampa('<p>'+reverseString('EPICOD')+'</p>',7)
/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
function upperFirst(stringa){
    if(stringa!==''&&stringa!==' ')
      stringa=stringa.charAt(0).toUpperCase() +stringa.substring(1)
    
    for (let i = 0; i < stringa.length; i++) {
        if(stringa[i]===" ")
          stringa= stringa.substring(0,i+1)+stringa[i+1].toUpperCase() + stringa.slice(i+2); 
       }
    return stringa;

}
stampa('<p>'+upperFirst('ciao gianluca come stai?')+'</p>',8)

/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/
/* SCRIVI QUI LA TUA RISPOSTA */
cutString=(stringa)=>{
    if(stringa!==''){/* trim mi cancella i spazzi non posso concatenarllo perche length diventa sballato*/
    // stringa=stringa.trim().substring(1).slice(0,(stringa.length-2));
        stringa=stringa.trim();
        stringa=stringa.substring(1).slice(0,(stringa.length-2));
        console.log(stringa);
    }
    return stringa;
}
stampa('<p>'+cutString('ciao gianluca come stai? ')+'</p>',9)


/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
function giveMeRandom(n){
    const array=[];
for (let i = 0; i < n; i++) {
    // array[i]=Math.floor(Math.random() * (11-5))+5; /* nel caso fosse da 5 a 10 */
    array[i]=Math.floor(Math.random() * (11-0));
}
return array;
}
stampa('<p>'+giveMeRandom(15)+'</p>',10);
