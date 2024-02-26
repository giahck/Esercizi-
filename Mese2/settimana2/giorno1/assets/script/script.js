 let unit = document.documentElement.scrollHeight /100;
window.addEventListener('scroll', (scrollY) => {
    const scrollT=document.getElementById('scrollT');
    scrollT.setAttribute('class',`progress-bar w-${window.scrollY/100}`)
     console.log((window.scrollY/100)*unit);
})