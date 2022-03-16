// Ejercicio 1
function random(){

    let numRandom = Math.floor(Math.random() * 99 + 1); 
    return numRandom;
}

// Ejercicio 2
function adivinaElNumero(){

    let num; 
    let contador = 10;
    numRandom = random();

    do { 
        num = prompt("Escribe un numero del 0 al 100", '');    
        
        if (num > numRandom){
            alert("El número es menor!");
            alert(`Te quedan ${contador-1}`);
        } else if(num < numRandom){
            alert("El número es mayor!");
            alert(`Te quedan ${contador-1}`);
        } else{
            alert("¡HAS ACERTADO!");
        }
        contador --;
    } while (numRandom != num && contador > 0);

    if (contador === 0){
        alert("¡HAS PERDIDO!");
    } 
}

// Ejercicio 3


// Ejercicio 4
function numerosPrimos() {

    let num;
    let primos = [];
    let noPrimos = [];

    num = prompt("¿Cuantos números primos quieres mostrar?", '');
  
    for (let i = 0; i < num; i++) {
      if (i%2 === 0) {
        primos.push(i);
      } else {
        noPrimos.push(i);
      }
    } 
    console.log(primos); 
    alert(primos);
  }
  
  