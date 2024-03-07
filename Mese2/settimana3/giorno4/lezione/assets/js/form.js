const nome = document.getElementById('nome');
const cognome = document.getElementById('cognome');
const btnSubmit = document.getElementById('submit');
const form = document.getElementById('form');
const errore = document.getElementById('errore');
const vuoto = document.getElementById('vuoto');
const elenco = document.getElementById('elenco');
const btnCancella = document.getElementById('reset');
const dataURL = 'http://localhost:3000/elenco';
let lista = [];

window.addEventListener('load', init);

function init() {
	readList();
}

async function readList() {
	try {
		let read = await fetch(dataURL);
		let response = await read.json();
		lista = response;
        if (lista.length > 0) {
            printData();
        } else {
            errore.innerText = 'Nessun elemento presente';
            return;
        }
	} catch (error) {
		console.log(error);
        location.href = '404.html';
	}
}

const printData = () => {
    errore.innerText = '';
    lista.forEach((element) => {
        let li = document.createElement('li');
        let btnElimina = document.createElement('button');
        btnElimina.classList.add('btn', 'btn-danger', 'nero', 'ms-3');
        btnElimina.innerText = 'X';
        btnElimina.setAttribute('onClick', `deleteItem(${element.id})`);
        li.innerText = `${element.nome} ${element.cognome}`;
        li.appendChild(btnElimina);
        elenco.appendChild(li);
    });
}
btnSubmit.addEventListener('click', function(e) {
    e.preventDefault();
    let checkValidity = (nome.value != '' && cognome.value != '') ? true : false;
    if (checkValidity) {
        errore.innerText = '';
        addItem();
    } else {
        errore.innerText = 'Riempire correttamente tutti i campi';
    }
});

const addItem = async () => {
    
    let item = {
        nome: nome.value,
        cognome: cognome.value
    }

    try {
        let response = await fetch(dataURL, {
            method: 'POST',
            body: JSON.stringify(item),
            headers: {
                'Content-Type': 'application/json'
            }
        });
    } catch (error) {
        console.log(error);
    }
};

const deleteItem = async id => {
	try {
		let response = await fetch(dataURL + id, {
			method: 'DELETE',
		});
	} catch (error) {
		console.log(error);
	}
};