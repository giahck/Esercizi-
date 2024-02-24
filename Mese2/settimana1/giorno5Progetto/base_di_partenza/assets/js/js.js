window.addEventListener('scroll', (scrollY) => {
    const block1=document.getElementById('header');
    const aColor=document.getElementById('aColor');
    //  console.log(block1);
    if(window.scrollY>300){
        block1.style.backgroundColor='white';
        aColor.classList.remove('aColor');
        aColor.classList.add('gColor');
    }
    else  
    {
    block1.style.backgroundColor='#ffc017';
    aColor.classList.remove('gColor');
    aColor.classList.add('aColor')
}
})

window.addEventListener('load', function() {
    const g = document.querySelectorAll('g[stroke-linejoin=round]')
    const block = document.querySelectorAll('g g[style]')

    // console.log(g[3].getAttribute('opacity'))
    
    setInterval(elem => {
        let ran = Math.floor(Math.random() * (g.length-1))
        if (g[ran].getAttribute('opacity') === "0") {
            g[ran].setAttribute('opacity', "1")
        } else {
            g[ran].setAttribute('opacity', "0")
        }
        if (block[ran].getAttribute('style')==='display: block') {
            // console.log(block[ran].getAttribute('style'));
            block[ran].setAttribute('style', "display: block")
        }
    }, 100)
})