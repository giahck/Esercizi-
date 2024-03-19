const nome = document.getElementById('nome');
const cognome = document.getElementById('cognome');
const btnregister = document.getElementById('register');
const ricarica = document.querySelector('.ricarica');
const btnRicarica = document.getElementById('btnricarica');
class Utente {
    constructor(_persona) {
        this.credito = 0;
        this.numeroChiamate = 0;
        this.persona = _persona;
    }
    getAbbonamento(ricarica) {
        this.credito = ricarica;
    }
}
let nuovoAbbonato;
btnregister.addEventListener('click', function (e) {
    e.preventDefault();
    if (nome.value !== '' && cognome) {
        nuovoAbbonato = new Utente({ nome: nome.value, cognome: cognome.value });
        console.log(nuovoAbbonato.persona);
    }
    else
        console.log('non inserito');
});
btnRicarica.addEventListener('click', (e) => {
    e.preventDefault();
    console.log(ricarica.value);
    nuovoAbbonato.getAbbonamento(Number(ricarica.value));
    console.log(nuovoAbbonato.credito);
});
