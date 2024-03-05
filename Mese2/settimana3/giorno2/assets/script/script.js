const btnAgiunggi=document.getElementById('aggiungi');
const btnDelete=document.getElementById('delete');
const formName=document.getElementById('nome');
const formCognome=document.getElementById('cognome');
let tempo,i=0;
btnAgiunggi.addEventListener('click', e=>{
  i=0;
  localStorage.setItem('nome',formName.value,'cognome',formCognome.value);
  localStorage.setItem('cognome',formCognome.value);
  if (formName!='' && formCognome!='') {
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
if(sessionStorage.getItem('time')!=null){
  i=sessionStorage.getItem('time')
  time();
}

