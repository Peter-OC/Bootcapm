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
function dameArray(elementos, valor){
    let miarray = [];
    for (let i = 0; i < elementos; i++){
        miarray[i] = valor;
    }
    return miarray; 
}

// Ejercicio 5
function validaNIF(num){
    if (num == null) return true;
    num = num.toUpperCase();

    if (!/^\d{1,8}[A-Za-z]$/.test(num)) return false;
    return "TRWAGMYFPDXBNJZSQVHLCKE".charAt(parseInt( num.substring(0, num.length - 1)) % 23) 
            == num.charAt(num.length - 1);
}

// Ejercicio 4
function numerosDivisores(num) {

    let divisores = [];

    num = parseInt(num);
  
    for (let i = 0; i < num; i++) {
      if (num%i === 0) {
        divisores.push(i);
      } 
    } 
    return divisores;
  }
  
// Ejercicio 6
function palindromo(cadena) {

    const cadenaInvertida = cadena.split("").reverse().join("");
  
    return cadenaInvertida === cadena ? "es palindromo" : "no es palindromo";   
  }