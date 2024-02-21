const sottoMenu=document.getElementById('sottoMenu');
const sottoLista=document.getElementById('sottoLista');

sottoMenu.addEventListener('mouseenter',function(){
sottoLista.style.display='block';
})
sottoMenu.addEventListener('mouseleave',function(){
sottoLista.style.display='none';
})