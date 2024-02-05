
/* ESERCIZIO 1
       Scrivi una funzione per cambiare il titolo della pagina in qualcos'altro
    */

       const changeTitle = function () {
     document.getElementsByTagName('h1')[0].innerHTML='Hello World';
     
       }
       changeTitle();
       /* ESERCIZIO 2
        Scrivi una funzione per aggiungere al titolo della pagina una classe "myHeading"
     */
 
       const addClassToTitle = function () {
        document.querySelector('div h1').setAttribute('class','myHeading');
       }
       addClassToTitle();
 
       /* ESERCIZIO 3
        Scrivi una funzione che cambi il testo dei p figli di un div
       */
 
       const changePcontent = function () {
        let divP=document.querySelectorAll('div p');
        for(let i = 0; i < divP.length; i++){
            document.querySelectorAll('div p')[i].innerHTML='il testo è cambiato';
        }
       }
       changePcontent();
 
       /* ESERCIZIO 4
        Scrivi una funzione che cambi la proprietà href di ogni link (tranne quello nel footer) con il valore https://www.google.com
       */

 
       const changeUrls = function () {
        let a=document.querySelectorAll('a');
        for(let i = 0; i < a.length; i++)
        if(document.querySelector('footer a')!==a[i])
        document.querySelectorAll('a')[i].setAttribute('href','https://www.google.com');
        
        
    
       }
       changeUrls();
  
       /* ESERCIZIO 5
        Scrivi una funzione che aggiunga un nuovo elemento lista alla seconda lista non ordinata
     */
 
       const addToTheSecond = function () {
            let secondList=document.getElementById('secondList');
           let li=document.createElement('li');
           li.innerText='4rd';
           secondList.appendChild(li);
           document.getElementById('secondList').innerHTML+='<li>5nd</li>';
       
           }
       addToTheSecond();
 
       /* ESERCIZIO 6
        Scrivi una funzione che aggiunga un paragrafo al primo div
     */
 
       const addParagraph = function () {
        let div=document.querySelector('div');
        let p=document.createElement('p');
           p.innerText='Qyuesto è u8n paragrafo aggiunto';
        //    div.appendChild(p);
           div.insertBefore(p, div.firstChild);/* l'ho inserisco all'inizio */
       }
       addParagraph();
 
       /* ESERCIZIO 7
        Scrivi una funzione che faccia scomparire la prima lista non ordinata
     */
 
       const hideFirstUl = function () {
        document.getElementById('firstList').style.visibility='hidden';
       }
       hideFirstUl();
 
       /* ESERCIZIO 8 
        Scrivi una funzione che renda verde il background di ogni lista non ordinata
       */
 
       const paintItGreen = function () {
        let ul=document.querySelectorAll('ul');
        for(let i = 0; i < ul.length; i++){
            document.querySelectorAll('ul')[i].classList.add('green');
        
       }}
       paintItGreen();
 
       /* ESERCIZIO 9
        Scrivi una funzione che rimuova l'ultima lettera dall'h1 ogni volta che l'utente lo clicca
       */

       const makeItClickable = function () {
        let on=document.querySelector('div h1');
        on.addEventListener('click',function(){
           let text= on.textContent;
           
           on.textContent=text.slice(0,-1);
            console.log(text)
        })
       }
       makeItClickable();
       /* ESERCIZIO 10
        Crea una funzione che, al click sul footer, riveli l'URL del link interno come contenuto di un alert()
       */
 
       const revealFooterLink = function () {
        const text=document.getElementsByTagName('footer');
       }
 
       /* ESERCIZIO 11
        Crea una funzione che crei una tabella nell'elemento con id "tableArea". 
        La tabella avrà 5 elementi e questa struttura: immagine, nome prodotto, quantità, prezzo
     */
 
       const generateTable = function () {}
 
       /* ESERCIZIO 12
        Crea una funzione che aggiunga una riga alla tabella precedentemente creata e fornisca i dati necessari come parametri
     */
 
       const addRow = function () {}
 
       /* ESERCIZIO 14
       Crea una funzione che nasconda le immagini della tabella quando eseguita
     */
 
       const hideAllImages = function () {}
 
       /* EXTRA ESERCIZIO 15
       Crea una funzione che cambi il colore del h2 con id "changeMyColor" con un colore random ad ogni click ricevuto
     */
 
       const changeColorWithRandom = function () {}