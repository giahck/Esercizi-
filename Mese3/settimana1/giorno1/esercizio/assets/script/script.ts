const nome = document.getElementById('nome') as HTMLInputElement
const cognome=document.getElementById('cognome') as HTMLInputElement;
const btnregister=document.getElementById('register') as HTMLButtonElement;
const ricarica = document.querySelector('.ricarica') as HTMLInputElement;
const btnRicarica = document.getElementById('btnricarica') as HTMLButtonElement;

interface Abbonamento{
    credito:number,
    numeroChiamate:number
  
}
type Person={
    nome:string;
    cognome:string;
}


class Utente implements Abbonamento{
    persona:Person
    credito: number=0;
    numeroChiamate:number=0
    constructor(_persona:Person){
        this.persona=_persona;
    }
    getAbbonamento(ricarica:number):void { 
        this.credito=ricarica;
     
    }
}
let nuovoAbbonato: Utente

    btnregister.addEventListener('click', function(e) {
    e.preventDefault();
    if (nome.value!=='' && cognome) {
        
      nuovoAbbonato=new Utente({nome:nome.value,cognome:cognome.value})
      console.log(nuovoAbbonato.persona);
      
    }else console.log('non inserito');
  
    
});


btnRicarica.addEventListener('click', (e) => {
    e.preventDefault();
    console.log(ricarica.value);
    nuovoAbbonato.getAbbonamento(Number(ricarica.value))
    console.log(nuovoAbbonato.credito)
});

