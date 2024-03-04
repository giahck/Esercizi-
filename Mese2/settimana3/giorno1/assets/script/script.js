class Form {
  bool = true;
  constructor(_eta = 0, _FirstName = "", _secondName = "", _location = "") {
    this.eta = _eta;
    this.firstName = _FirstName;
    this.seconName = _secondName;
    this.location = _location;
  }
  controlInsert() {
    if (
      this.firstName === "" ||
      this.seconName === "" ||
      this.location === "" ||
      this.eta === 0
    ) {
      return false;
    } else {
      return true;
    }
  }
}
class controlEta extends Form {
  constructor(_etaAccess = 18, ...formArgs) {
    super(...formArgs);
    this.etaAccess = _etaAccess;
  }
  calcoloEta() {
    return this.eta < this.etaAccess;
  }
}
class pet {
  constructor(_petNome, _ownerName, _speces, _bread) {
    this.petNome = _petNome;
    this.ownerName = _ownerName;
    this.speces = _speces;
    this.bread = _bread;
  }
  controlInsertPet() {
    if (
      this.petNome === "" ||
      this.ownerName === "" ||
      this.speces === "" ||
      this.bread === ''
    ) {
      return false;
    } else {
      return true;
    }
  }
  controlPadrone(padrone) {
  }
}

const btnForm = document.getElementById("aggiungi");
const btnCane = document.getElementById("aggiungiCane");
const form = document.getElementById("formPersona");

const forms2 = document.getElementById("forms2");

let padrone=[];
btnForm.addEventListener("click", (e) => {
  e.preventDefault();
    
  let firstName = document.getElementById("firstName");
  let secondName = document.getElementById("secondName");
  let location = document.getElementById("location");
  let eta = document.getElementById("eta");
  let person = new Form(
    eta.value,
    firstName.value,
    secondName.value,
    location.value
  );
  // person.controlInsert(firstName,secondName,location,eta); passo come parametrima non serve l'ho gia inizializato le 4 var
  let etaControllato = new controlEta(18, person.eta);
  if (!person.controlInsert()) {
    firstName.setAttribute("class", "placeholder col-12 bg-warning");
    firstName.value = "";
    firstName.setAttribute("placeholder", "write name");
    secondName.setAttribute("class", "placeholder col-12 bg-warning");
    secondName.setAttribute("placeholder", "write Surname");
    secondName.value = "";
    eta.setAttribute("class", "placeholder col-12 bg-warning");
    eta.setAttribute("placeholder", "write eta");
    eta.value = "";
    location.setAttribute("class", "placeholder col-12 bg-warning");
    location.setAttribute("placeholder", "location");
    location.value = "";
  } else if (etaControllato.calcoloEta()) {
    console.log("ciao");
    eta.setAttribute("class", "placeholder col-F12 bg-info");
    eta.setAttribute("placeholder", "write eta");
  } else {
    
    padrone.push(person);
    location.setAttribute("class", "placeholder bg-white");
    forms2.setAttribute('class','col-4 offset-sm-2 bg-warning d-flex justify-content-center visibile');
   
    firstName.value = "";
    secondName.value = "";
    eta.value = "";
    location.value = "";
  }
});
    btnCane.addEventListener('click',(e)=>{
    e.preventDefault();
    let petNome = document.getElementById("petNome");
  let ownerName = document.getElementById("ownerName");
  let speces = document.getElementById("speces");
  let bread = document.getElementById("bread");
  let cani=new pet(petNome,ownerName,speces,bread);
  if(cani.controlInsertPet()){
    petNome.setAttribute("class", "placeholder col-12 bg-warning");
    petNome.value = "";
    petNome.setAttribute("placeholder", "write name pet");
    ownerName.setAttribute("class", "placeholder col-12 bg-warning");
    ownerName.setAttribute("placeholder", "write beard");
    ownerName.value = "";
    speces.setAttribute("class", "placeholder col-12 bg-warning");
    speces.setAttribute("placeholder", "speces");
    speces.value = "";
    bread.setAttribute("class", "placeholder col-12 bg-warning");
    bread.setAttribute("placeholder", "beard");
    bread.value = "";
  }else{
    
  }
})

