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
        id:id,
    };
    arrayDati.push(persona);
}
console.log(arrayDati);

/* creo struttura visualizzazione per ogni persona un articolo*/
function view(idI,id){
    let articolo=document.createElement('article');
    let nomeV=document.createElement('h1');
    let cognomeV=document.createElement('h2'); 
    let textV=document.createElement('p'); 
    console.log(idI+'   '+id);
    articolo.setAttribute('class','articol')
    articolo.setAttribute('id',idI)

    nomeV.innerText=arrayDati[id].name;
    cognomeV.innerText=arrayDati[id].cognome;
    textV.innerText=arrayDati[id].text;

    articolo.appendChild(nomeV);
    articolo.appendChild(cognomeV);
    articolo.appendChild(textV);
    
    contenitore.appendChild(articolo);
};
/* seleziono una persona ed ise vieni clicato compare il botonne elimina*/
function selected(id,arrId){
    let arrM='a'+arrId
   document.getElementById(arrId).addEventListener('click',function(){
                const rem=document.getElementById(arrM);/* controllo se esiste il bottone */
        if(rem===null){
            articolo[arrId].style.backgroundColor='rgb(226, 155, 155)';
            remuve(arrId);/* dopo selezionato mi cancelli */
        }else{
            articolo[arrId].style.backgroundColor='white';
            document.getElementById(arrM).remove();
        }
   });

}
function remuve(arrId){
    let arrM='a'+arrId
    articolo[arrId].innerHTML+=`<button type="button" id="${arrM}" >cancella</button>`;
    document.getElementById(arrM).addEventListener('click',function(){
        document.getElementById(arrId).remove();
       
    })
  
}

/* bottone crea e visualizza */
btnSubmit.addEventListener('click',function() {
    let lunghezza='a'+arrayDati.length;/* id tag di ogni articolo che equivale al numero di oggetto*/
    insertDati(lunghezza);
     view(lunghezza,lunghezza.slice(1));
   selected(length,lunghezza);

    
});



