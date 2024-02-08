const divTabella = document.getElementById("tabella");
const conteinerSchede = document.getElementById("conteinerSchede");
const tabelloneArrayNumeri = [];
const cartelle = [];

const fineGioco = () => {
  console.log("finegioco");
};
function ran(numeroEstratto) {
  for (let i = 0; i < tabelloneArrayNumeri.length; i++) {
    if (tabelloneArrayNumeri[i] === numeroEstratto) {
      return true;
    }
  }
}
const visualizzaNum = (numeroEstratto) => {
  document.getElementById("visualizza").innerText =
    "Estratto il numero:" + numeroEstratto;
  document.getElementById(`a${numeroEstratto}`).classList.add("selected");
};
const verificaschede = function (numeroEstratto) {
  let t=0;
  cartelle.forEach((element, i) => {
    for (let j = 0; j < element.length; j++) {
      if (numeroEstratto === cartelle[i][j]) {
        document.getElementById('j'+i+j).classList.add('selected')
        
      }
    }
  });
};
function estrazioneNum() {
  let numeroEstratto = Math.floor(Math.random() * 90) + 1;

  if (ran(numeroEstratto)) {
    estrazioneNum();
  } else if (!ran(numeroEstratto)) {
    tabelloneArrayNumeri.push(numeroEstratto);
    visualizzaNum(numeroEstratto);
    verificaschede(numeroEstratto);
  }
}
/* funzione estrazzione */
const estrazione = () => {
  if (tabelloneArrayNumeri.length < 89) {
    estrazioneNum();
  } else if (tabelloneArrayNumeri.length === 89) {
    estrazioneNum();
    fineGioco();
  }
};
/* tabbellone iniziale */
const tabellone = () => {
  for (let i = 0; i < 90; i++) {
    divTabella.innerHTML += `<p id='a${i + 1}' class="numero">${i + 1}</p>`;
  }
  divTabella.innerHTML += `<button id="btnPesca" onclick='estrazione()'>PESCA!</button>`;
  divTabella.innerHTML += `<p id='visualizza'></button>`;
};
tabellone();
/* schede giocatori */
const schede = () => {
    let t=0;
  for (let i = 0; i < 3; i++) {
    cartelle.push([]);
    const schedaGiocatore = document.createElement("div");
    schedaGiocatore.setAttribute(
      "class",
      "giocatori"
    ); /* qui si protrebbe mettere il valore id del nome del giocatore */
    schedaGiocatore.setAttribute("id", "i" + (i + 1));
    for (let j = 0; j < 15; j++) {t++;
      const numeriScheda = document.createElement("p");
      numeriScheda.setAttribute("class", "numeri");
      numeriScheda.setAttribute("id", "j" +i+ j);
      const random = Math.floor(Math.random() * 90) + 1;
      cartelle[i].push(random);
      numeriScheda.innerText = cartelle[i][j];
      schedaGiocatore.appendChild(numeriScheda);
    }
    conteinerSchede.appendChild(schedaGiocatore);
  }
  console.log(cartelle);
};
schede();
