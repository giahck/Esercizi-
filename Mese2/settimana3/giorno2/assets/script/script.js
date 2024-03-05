const btnAgiunggi=document.getElementById('aggiungi');
const btnDelete=document.getElementById('delete');
const formName=document.getElementById('nome');
const formCognome=document.getElementById('cognome');
let tempo,i=0;
btnAgiunggi.addEventListener('click', e=>{
  i=0;/* salva il nome e il cognme sul local */
  localStorage.setItem('nome',formName.value,'cognome',formCognome.value);
  localStorage.setItem('cognome',formCognome.value);/* se metto il time qui posso dire che mi prende il timer totale dal primo accesso creato dell'utente */
  if (formName!='' && formCognome!='') {/* dopo il click attivo la session  con nome e cognome */
    sessionStorage.setItem('name',localStorage.getItem('nome'))
    sessionStorage.setItem('cognome',localStorage.getItem('cognome'))
    sessionStorage.setItem('time',0)
    
    time();
  }
})
btnDelete.addEventListener('click',e=>{
  localStorage.removeItem('nome');
  localStorage.removeItem('cognome');
})
function time(){
  tempo=setInterval(function () {
    sessionStorage.setItem('time',i)
    timeDiv.innerHTML=`<p>${ sessionStorage.getItem('time')}</p>`;
    
    i++;
  },1000)
}
if(sessionStorage.getItem('time')!=null){/* unavolta avviato se riavvio il time continua */
  i=sessionStorage.getItem('time')
  time();
}

