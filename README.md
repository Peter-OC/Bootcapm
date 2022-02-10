# BootCamp 5
## Back End
### Ejercicios de Iniciación a la Programación Java
1 - Juego de “Adivina el número que estoy pensando”, un número del 0 al 100, 
ya te diré si es mayor o menor que el mío, pero tienes 10 intentos como mucho.
```
  Scanner teclado = new Scanner(System.in); cad = teclado.nextLine();  
  num = Integer.parseInt(cad);
  var rnd = new Random(); num = rnd.nextInt(10);  
```
2 - Opcional: Decodificar las cadenas con el siguiente formato:
```
  3+4+3,4-7*1=
```
en los siguientes componentes:
```
  3 +  
  4 +  
  3,4 -  
  7 *  
  1 =  
```
mostrando el resultado en la consola.

3 - Convertir el juego “Adivina el número que estoy pensando” en la clase JuegoDelNumero 
sin interfaz de usuario. Debe contar con los métodos inicializar y jugada, así como 
informar del número de intentos y el resultado de la última jugada. No debe dejar 
continuar si el juego ha terminado. Para probar el juego se debe implementar el interfaz de usuario.

4 - *Opcional: Crear la clase Calculadora que acumule y permita obtener los resultados 
parciales de las operaciones obtenidas en la decodificación anterior.*

5 - Crear las clases para implementar juegos que utilizan una baraja de naipes. Los naipes tienen dos propiedades distintivas: valor y palo. Probar la funcionalidad de barajar, repartir, comparar, … (Utilizar Enumeraciones, genéricos, colecciones …)

6 - Ficheros: Leer un fichero de entrada y generar un fichero de salida, realizando los cálculos necesarios, con los siguientes formatos:
FileIN: Entrada.txt
```
  3+4+3,4-7*1=
  ```
FileOUT: Salida.txt
```
  3  
  + 4  
  + 3,4  
  - 7  
  * 1  
  ----------  
  3,400000
  ```
Ampliaciones (ficheros):

Fichero de entrada con múltiples líneas.
Fichero de salida comprimido
Descompresor del fichero de salida: zip -> txt
Compresor del fichero de entrada: txt -> zip
Procesar entrada/salida comprimida
##Ejercicios de refuerzo
###Iniciación
http://puntocomnoesunlenguaje.blogspot.com/p/ejercicios.html
https://tutobasico.com/basicos-java/
https://tutobasico.com/basicos2-java/
https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-basicos-java/
https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-metodos-y-funciones-de-java/
###Intermedio:###
https://tutobasico.com/basicos3-java/
http://ejerciciosresueltosprogramacion.blogspot.com/
https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-programacion-orientado-a-objetos-java/
Front End
Proyecto
