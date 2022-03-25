import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {

  public displayPreviousValue: string;
  public displayCurrentValue: string;
  public operadores: string;
  public acumulado: number;
  public operadorPendiente: string;

    constructor() {
        this.displayPreviousValue = "";
        this.displayCurrentValue = "0";
        this.operadores = '+-*/=';
        this.acumulado = 0;
        this.operadorPendiente = '+';
    }

    get ACUMULADO() {
        return this.acumulado;

    }

    inicializa() {
      this.acumulado = 0;
      this.operadorPendiente = '+';
  }

    isOperacion(operacion: string) {
        return this.operadores.indexOf(operacion) != -1;
    }

    calcula(operando2: string, nuevoOperador: string){

        if (!this.isOperacion(nuevoOperador)) {
            throw new Error("Operación no soportada");
          }

        switch (this.operadorPendiente) {
            case '+':
                this.acumulado += parseFloat(operando2);
                break;
            case '-':
                this.acumulado -= parseFloat(operando2);
                break;
            case '*':
                this.acumulado *= parseFloat(operando2);
                break;
            case '/':
                this.acumulado /= parseFloat(operando2);
                break;
            case '=':
                break;
        }
        this.operadorPendiente = nuevoOperador;
        return this.ACUMULADO;
    }

    addNumero(value: string,) {
        if((this.displayCurrentValue == "0")){
            this.displayCurrentValue = value;
        } else {
            this.displayCurrentValue += value;
        }

    }

    mostrarOperador(btn: string) {
          this.copiarValor();
          this.valorAnterior(btn);
          this.deleteCurrentDisplay();
    }

    valorAnterior(operador: string) {
        if (operador == '='){
          this.displayPreviousValue = this.calcula(this.displayCurrentValue, operador).toString();
        } else{
          this.displayPreviousValue = this.calcula(this.displayCurrentValue, operador).toString();
          this.displayPreviousValue += ' ' + operador;
        }

      }

    copiarValor() {
        this.displayPreviousValue = this.displayCurrentValue;
    }


    deleteOne() {
        if (this.displayCurrentValue.length == 1){
            this.displayCurrentValue = "0";
        } else {
            this.displayCurrentValue = this.displayCurrentValue.slice(0,this.displayCurrentValue.length -1);
        }

    }

    deleteAll() {
        this.displayCurrentValue = "0";
        this.displayPreviousValue = "";
        this.inicializa();
    }

    deleteCurrentDisplay() {
        this.displayCurrentValue = "0";
      }

  ngOnInit(): void {
  }

}
