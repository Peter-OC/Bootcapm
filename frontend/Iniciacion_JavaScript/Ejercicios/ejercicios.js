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
  
// Ejercicio 4 de los números primos (^_^)
function esPrimo(numero) {
    for (let i = 2; i < numero ; i++) {
        if (numero % i === 0) {
            return false;
        }
    }
    return true;
}

function damePrimos(cuantos) {
    let primos = [];
    for (let x = 2; x; x++) {
      if (esPrimo(x)) {
        primos.push(x);
        if (primos.length >= cuantos) return primos;
      }
    }
  }


// Ejercicio 5
function validaNIF(num){
    if (num == null) return true;
    num = num.toUpperCase();

    if (!/^\d{1,8}[A-Za-z]$/.test(num)) return false;
    return "TRWAGMYFPDXBNJZSQVHLCKE".charAt(parseInt( num.substring(0, num.length - 1)) % 23) 
            == num.charAt(num.length - 1);
}

// Ejercicio 6
function palindromo(cadena) {

    const cadenaInvertida = cadena.split("").reverse().join("");
  
    return cadenaInvertida === cadena ? "es palindromo" : "no es palindromo";   
  }

// Ejercicio 1 de Objetos
class juegoDelNumero{
    constructor(){
        this.inicializar();
    }

    inicializar(){
        this.cont = 10;
		this.random = rnd.nextInt(101);
		this.mensaje = "";
		this.terminado = false;
    }

    jugada(num){
        if (num > this.random) {
			this.mensaje = "El número secreto es MENOR que " + num + " ,\n" + "te quedan " + (this.cont - 1) + " intentos.\n";
		} else if (num < this.random) {
			this.mensaje = "El número secreto es MAYOR que " + num + " ,\n" + "te quedan " + (this.cont - 1) + " intentos.\n";
		} else {
			this.mensaje = "¡CORRECTO!" + " Solo has necesitado " + (10 - (this.cont - 1)) + " intentos.";

			this.terminado = true;
			return;
		}
		this.cont--;

		if (this.cont == 0) {
			this.mensaje = "¡HAS PERDIDO!," + " ¡ERES MÁS MALO QUE LA PESTE!. El número secreto era: " + num;

			this.terminado = true;
		}
	}
    
    getMessage() {
		return this.mensaje;
	}
    
    getTerminado() {
		return this.terminado;
	}


}