console.log('hello');
let nome='Gianluca';
let cognome='Giacchetta';
let eta=28;
const sum =function(nm1: number,num2?:number):number{
return nm1*(num2||50);//foolback
}
sum(4)
const arr:string[]=[];
const arr1:Array<number>=[];

type customType= string|number;/* union */
let nomenumero:customType=50;
nomenumero='ciao'
const person:uomini={
    firstName:'gianni',
    surName:'morandi',
    skills:['cantante','tantecoseBelle'],
}
interface uomini{
    firstName:string
    surName:string
    skills?:string[]
}
const uomini2:uomini={
    firstName:'roberto',
    surName:'ciao',
skills:['nuoto']
}
const uomini3:uomini={
    firstName:'sandra',
    surName:'giardino'
}



