"use strict";
const utente = {
    name: 'giovanni',
    surname: 'Rossi',
    eta: 5
};
class superUser {
    data;
    constructor(_data) {
        this.data = _data;
    }
}
const myAdmin = new superUser({ name: 'allseandra', surname: 'bianchi', eta: 60, privileges: ['write', 5], level: 4 });
console.log(myAdmin.data.privileges[0]);
//# sourceMappingURL=main.js.map