window.addEventListener('scroll', (scrollY) => {
    const block1=document.getElementById('header');
    // console.log(window.scrollY);
    if(window.scrollY>300)
        block1.style.backgroundColor='white';
    else  block1.style.backgroundColor='#ffc017';
})