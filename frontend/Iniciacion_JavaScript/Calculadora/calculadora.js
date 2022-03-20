class Calculadora {
       
    constructor(displayPreviousValue, displayCurrentValue) {
        this.displayPreviousValue = displayPreviousValue;
        this.displayCurrentValue = displayCurrentValue;
        this.operadores = '+-*/=';
        this.inicializa();
    }
    
    inicializa() {
        this.acumulado = 0;
        this.operadorPendiente = '+';
    }
    
    get ACUMULADO() {
        return this.acumulado;

    }

    isOperacion(operacion) {
        return this.operadores.indexOf(operacion) != -1;
    }
             
    calcula(operando2, nuevoOperador){

        if (!this.isOperacion(nuevoOperador)) {
            throw new Error("Operación no soportada");
          }
          operando2 = parseFloat(operando2);

        switch (this.operadorPendiente) {
            case '+':
                this.acumulado += operando2;
                break;
            case '-':
                this.acumulado -= operando2;
                break;
            case '*':
                this.acumulado *= operando2;
                break;
            case '/':
                this.acumulado /= operando2;
                break;
            case '=':
                break;
        }
        this.operadorPendiente = nuevoOperador;
        return this.ACUMULADO;
    }

    addNumero(value) {
        if((this.displayCurrentValue.textContent == 0)){
            this.displayCurrentValue.textContent = value;
        } else {
            this.displayCurrentValue.textContent += value;
        }
        
    }

    valorAnterior(operador) {
        if (operador == '='){
          this.displayPreviousValue.textContent = this.calcula(
            this.displayCurrentValue.textContent,
            operador
          );
        } else{
          this.displayPreviousValue.textContent = this.calcula(
            this.displayCurrentValue.textContent,
            operador
          );
          this.displayPreviousValue.textContent += ' ' + operador;
        }
        
      }
    
    copiarValor() {
        this.displayPreviousValue.textContent = this.displayCurrentValue.textContent;
    }


    deleteOne() {
        if (this.displayCurrentValue.textContent.length == 1){
            this.displayCurrentValue.textContent = "0";
        } else {
            this.displayCurrentValue.textContent = this.displayCurrentValue.textContent.slice(0,this.displayCurrentValue.textContent.length -1);
        }
       
    }

    deleteAll() {
        this.displayCurrentValue.textContent = "0";
        this.displayPreviousValue.textContent = "";
        this.inicializa();
    }

    deleteCurrentDisplay() {
        this.displayCurrentValue.textContent = "0";
      }

}