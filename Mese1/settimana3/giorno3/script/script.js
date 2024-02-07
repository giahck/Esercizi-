const btnSubmit = document.getElementById('crea');
const  text= document.getElementById('text');
const  nome= document.getElementById('nome');
const  cognome= document.getElementById('cognome');
const  contenitore= document.getElementById('contenitor');
const articolo=document.getElementsByTagName('article');
/* funzione riempimento oggetto: nome, cognome,text, id*uso il numero di arrey per il tempo che forse non ho* */
const arrayDati=[];
function insertDati(id){
    let persona={
        name:nome.value,
        cognome:cognome.value,
        text:text.value,
        id:'a'+id,
    };
    arrayDati.push(persona);
}
console.log(arrayDati);

/* creo struttura visualizzazione per ogni persona un articolo*/
function view(id){
    let articolo=document.createElement('article');
    let nomeV=document.createElement('h1');
    let cognomeV=document.createElement('h2'); 
    let textV=document.createElement('p'); 
    
    articolo.setAttribute('class','articol')
    articolo.setAttribute('id','a'+id)

    nomeV.innerText=arrayDati[id].name;
    cognomeV.innerText=arrayDati[id].cognome;
    textV.innerText=arrayDati[id].text;

    articolo.appendChild(nomeV);
    articolo.appendChild(cognomeV);
    articolo.appendChild(textV);
    
    contenitore.appendChild(articolo);
};
/* seleziono una persona */
function selected(id,arrId){
    
   document.getElementById(id).addEventListener('click',function(){
        if(articolo[arrId].style.backgroundColor!=='white'){
            articolo[arrId].style.backgroundColor='white'}
            else{console.log('sda');
            articolo[arrId].style.backgroundColor='rgb(226, 155, 155)';
        }
            
    
   });

}
function remuve(){
    
}

/* bottone crea e visualizza */
btnSubmit.addEventListener('click',function() {
    let lunghezza=arrayDati.length;
    insertDati(lunghezza);
    view(lunghezza);
  selected('a'+lunghezza,lunghezza);
  remuve();
    
});




/* evento in attesa se cliccki su una persona */
