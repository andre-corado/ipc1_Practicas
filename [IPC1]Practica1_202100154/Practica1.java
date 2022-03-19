import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;



public class Practica1 {

    public static void limpiarConsola(){
        int i = 0;
        while(i < 25){
            System.out.println();
            i++;
        }
    }


    public static void imprimirPunteo(String datosPuntuaciones[][]){

        //Se imprimen los cabezales del tablero
        System.out.println(" NO.     NOMBRE        PUNTEO      MOVIMIENTOS         MARCA DE TIEMPO");
        System.out.println("----|--------------|------------|----------------|-------------------------|");
        for(int i = 0; i < 5; i++){
            System.out.println(" " + String.valueOf(i+1) + "\t" + datosPuntuaciones[i][0] + "\t\t" + datosPuntuaciones[i][1] + "\t\t" + datosPuntuaciones[i][2] + "\t\t" + datosPuntuaciones[i][3] + " - " + datosPuntuaciones[i][4]);
            System.out.println("----|--------------|------------|----------------|-------------------------|");
        }

        System.out.println("\n\t INGRESE 'M' PARA REGRESAR AL MENU PRINCIPAL");




    }


    public static String obtenerHora(){
        LocalTime hora_actual = LocalTime.now();
        String hora = "";
        if(hora_actual.getMinute() >= 10){
            hora = (hora_actual.getHour() + ":" + hora_actual.getMinute());
        } else {
            hora = (hora_actual.getHour() + ":0" + hora_actual.getMinute());
        }
        return hora;
    }



    public static void actualizarPuntero(int movimientos, int  fruta, int punteo, int xcasilla, char tablero[][]){
        //convertimos los enteros a strings
        char[] movimiento = String.valueOf(movimientos).toCharArray();
        char[] frutas = String.valueOf(fruta).toCharArray();
        char[] puntos = String.valueOf(punteo).toCharArray();



        int ycasilla = 5;
        // Actualizamos el array del tablero con los movimientos
        if(movimiento.length != 1){
            for(int i = 0; i < movimiento.length; i++){
                tablero[xcasilla + i][ycasilla] = movimiento[i];
            }
        } else{
            tablero[xcasilla][ycasilla] = movimiento[0];
        }

        ycasilla = 2;
        // Actualizamos el array del tablero con los puntos
        if(puntos.length != 1){
            tablero[xcasilla][ycasilla] = puntos[0];
            tablero[xcasilla + 1][ycasilla] = puntos[1];

        } else{
            tablero[xcasilla][ycasilla] = puntos[0];
        }

        ycasilla = 8;
        // Actualizamos el array del tablero con las frutas
        tablero[xcasilla][ycasilla] = frutas[0];






    }

    public static int[] moverPacman(char tecla_ingresada, int xpacman, int ypacman, char tablero[][], int x, int y, int frutaAnterior){

        //Creamos el array que regresará todos los datos
        int punteo = 0, movimiento = 0, fruta = 0;
        int[] Pacman = {xpacman, ypacman, punteo, movimiento, fruta};

        // Variable para indicar si puede avanzar
        boolean puedeMoverse = false;

        // Objeto para números al azar
        Random random = new Random();


        if(tecla_ingresada == 'a' || tecla_ingresada == 'A'){

            xpacman --; //Se moverá a la izquierda
            if(tablero[xpacman][ypacman] == '\u2584'){ //Si es un límite
                xpacman = x-2; //Lo enviamos a la última columna
                // Se analiza si del otro lado hay algún obstáculo
                if(tablero[xpacman][ypacman] != '\u25A0'){
                    puedeMoverse = true;
                }
            } else if (tablero[xpacman][ypacman] == '\u25A0'){ //Sí es un obstáculo
            } else { //Si es una casilla libre o con fruta
                puedeMoverse = true;
            }

        } else if(tecla_ingresada == 'd' || tecla_ingresada == 'D'){
            xpacman ++; // Se moverá a la derecha
            if(tablero[xpacman][ypacman] == '\u2584'){ //Si es un límite
                xpacman = 1; //Lo enviamos a la última columna
                // Se analiza si del otro lado hay algún obstáculo
                if(tablero[xpacman][ypacman] != '\u25A0'){
                    puedeMoverse = true;
                }
            } else if (tablero[xpacman][ypacman] == '\u25A0'){ //Sí es un obstáculo
            } else { //Si es una casilla libre o con fruta
                puedeMoverse = true;
            }

        } else if(tecla_ingresada == 's' || tecla_ingresada == 'S'){
            ypacman ++; // Se moverá para abajo
            if(tablero[xpacman][ypacman] == '\u2584'){ //Si es un límite
                ypacman = 1; //Lo enviamos a la última columna
                // Se analiza si del otro lado hay algún obstáculo
                if(tablero[xpacman][ypacman] != '\u25A0'){
                    puedeMoverse = true;
                }
            } else if (tablero[xpacman][ypacman] == '\u25A0'){ //Sí es un obstáculo
            } else { //Si es una casilla libre o con fruta
                puedeMoverse = true;
            }

        } else if(tecla_ingresada == 'w' || tecla_ingresada == 'W'){
            ypacman --; // Se moverá para arriba
            if(tablero[xpacman][ypacman] == '\u2584'){ //Si es un límite
                ypacman = y-2; //Lo enviamos a la última columna
                // Se analiza si del otro lado hay algún obstáculo
                if(tablero[xpacman][ypacman] != '\u25A0'){
                    puedeMoverse = true;
                }
            } else if (tablero[xpacman][ypacman] == '\u25A0'){ //Sí es un obstáculo
            } else { //Si es una casilla libre o con fruta
                puedeMoverse = true;
            }
        }

        // Si puede moverse actualizamos su posición
        if(puedeMoverse){

            if(tablero[xpacman][ypacman] == '\u00F0'){ // Si hay una fruta
                Pacman[2]= (random.nextInt(5) + 1); // Añadimos su punteo
                while(true){
                    fruta = (random.nextInt(5) + 1); // Asignamos un valor a la fruta
                    if(fruta != frutaAnterior){ // Si es distinto a la fruta anterior
                        Pacman[4] = fruta;
                        break;
                    }
                }


                fruta = (random.nextInt(5) + 1); // Asignamos un número a la fruta
                if(fruta == frutaAnterior){ //Si el número al azar es equivalente a la fruta anterior
                    fruta = fruta --;
                    if(fruta == 0){
                        fruta = frutaAnterior ++;
                    }
                }
                Pacman[4] = fruta;
            }

            tablero[xpacman][ypacman] = 'C'; //Movemos al pacman
            tablero[Pacman[0]][Pacman[1]] = ' '; //Borramos la casilla anterior
            Pacman[0] = xpacman; // Actualizamos su posición
            Pacman[1] = ypacman;
            Pacman[3] = 1; // Almacenamos que se movió
        }



        return Pacman;
    }

    public static void imprimirmatriz(char[][] tablero, int x2){

        // Obtenemos el tamaño de la matriz
        int y = tablero[0].length;

        // Para cada casilla de la matriz
        for(int a = 0; a < y; a++){
            for(int b = 0; b < x2; b++){
                System.out.print(tablero[b][a]+" "); // Se imprime y se añaden la cantidad de espacios deseados entré los chars
                //Se imprime
            }
            System.out.println(); // Se da un salto a la siguiente fila
        }




    }

    public static void menu(){

        System.out.println("\t MENU PRINCIPAL");
        System.out.println("1.  Iniciar nuevo juego.");
        System.out.println("2.  Ver las últimas 5 puntuaciones.");
        System.out.println("3.  Salir.");
        System.out.print("\n \t Ingrese una opción válida:  ");

    }


    public static void main (String[] args){

        // Iniciamos el array donde se almacenan las puntuaciones
        String[][] datosPuntuaciones = new String[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                datosPuntuaciones[i][j] = "---";
            }
        }

        // Variables y objetos a utilizar
        int menu = 0;
        Scanner leer = new Scanner(System.in);
        Random random = new Random();

        // Se elabora el menú
        while(true){
            // Se despliega el menú y se solicita la opción
            limpiarConsola();
            menu();
            menu = leer.nextInt();  leer.nextLine();

            if (menu == 1){ //Se inicia el juego

                limpiarConsola(); //Se limpia la consola

                // Hacemos un espacio para los datos del jugador en los datos de puntuaciones, en [0]
                for(int i = 3; i > -1 ; i--){
                    for(int j = 4; j > -1; j--){
                        datosPuntuaciones[i+1][j] = datosPuntuaciones[i][j];
                    }
                }

                // Se definen el tamaño del tablero
                final int x =  42, y = 17, x2 = (x + 17);     // Se añaden más columnas para el puntero  -
                char[][] tablero = new char[x2][y]; // Hasta la columna x-1 se ocupará para el tablero de juego


                // Para cada casilla del tablero de juego
                for(int a = 0; a < x; a++){
                    for(int b = 0; b < y; b++){
                        if(a == 0 || a == (x-1) || b == (y-1) || b == 0){
                            tablero[a][b] = '\u2584'; // Se definen los bordes
                        } else {
                            tablero[a][b] = ' '; // Se deja vacío el centro
                        }
                    }
                }

                int x3 = x + 3;
                // Para cada casilla del tablero de puntos
                for(int a = 0; a < 10; a++){
                    for(int b = x3 ; b < x2; b++){    //Se dejan columnas vacías entre ambos tableros
                        if(b == x3 || a == 0 || a == 3 || a == 6 || a == 9 ){
                            tablero[b][a] = '\u00B0'; // Se definen los bordes
                        }
                    }
                }

                // Se añaden los títulos del tablero de punteo
                int ycasilla , xcasilla, contadorinterno;

                // Para el primer bloque
                ycasilla = 1; contadorinterno = 0;
                for(xcasilla = (x3 + 2); xcasilla < ((x3 + 2) + 6); xcasilla ++){
                    char[] mensaje = {'P','U','N','T','O','S'};
                    tablero[xcasilla][ycasilla] = mensaje[contadorinterno];
                    contadorinterno ++;
                }

                // Para el segundo bloque
                ycasilla = 4; contadorinterno = 0;
                for(xcasilla = (x3 + 2); xcasilla < ((x3 + 2) + 11); xcasilla ++){
                    char[] mensaje = {'M','O','V','I','M','I','E','N','T','O','S'};
                    tablero[xcasilla][ycasilla] = mensaje[contadorinterno];
                    contadorinterno ++;
                }

                // Para el tercer bloque
                ycasilla = 7; contadorinterno = 0;
                for(xcasilla = (x3 + 2); xcasilla < ((x3 + 2) + 12); xcasilla ++){
                    char[] mensaje = {'U','L','T','I','M','A',' ','F','R','U','T','A'};
                    tablero[xcasilla][ycasilla] = mensaje[contadorinterno];
                    contadorinterno ++;
                }

                // Construimos el laberinto con algunas estructuras a razón del tablero de juego con el valor ascii 254
                ycasilla = y/2;
                for(xcasilla = x/3; xcasilla < x*57/100; xcasilla ++){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }
                ycasilla = y*2/3;
                for(xcasilla = 1; xcasilla < x/5; xcasilla ++){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }
                ycasilla = y/3;
                for(xcasilla = x-2; xcasilla > x*4/5; xcasilla --){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }
                ycasilla = y*7/10;
                for(xcasilla = x/3; xcasilla < x*2/3; xcasilla ++){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }
                xcasilla = x/2;
                for(ycasilla = 1; ycasilla < y/3; ycasilla ++){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }
                xcasilla = x/3;
                for(ycasilla = 1; ycasilla < y/2; ycasilla ++){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }
                xcasilla = x/6;
                for(ycasilla = 1; ycasilla < y/3; ycasilla ++){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }
                xcasilla = x*3/4;
                for(ycasilla = y-2; ycasilla > y/2; ycasilla --){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }
                xcasilla = x*1/4;
                for(ycasilla = y-2; ycasilla > y/2; ycasilla --){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }
                xcasilla = x*7/10;
                for(ycasilla = 1; ycasilla < y*37/100; ycasilla ++){
                    tablero[xcasilla][ycasilla] = '\u25A0';
                }

                // Hacemos variables para la posicion del pacman y lo colocamos en el tablero
                int punteo = 0, movimientos = 0, fruta = 0;
                int[] Pacman = {1,1}; // xpacman, ypacman

                while(true){
                    Pacman[0] = (random.nextInt(x-2) + 1); Pacman[1] = (random.nextInt(y-2) + 1);
                    if(tablero[Pacman[0]][Pacman[1]] == ' '){ // Si la casilla se encuentra vacía
                        tablero[Pacman[0]][Pacman[1]] = '\u00F0';
                        break;
                    }
                }

                tablero[Pacman[0]][Pacman[1]] ='C';




                // Colocamos las frutas al azar

                for(int i = 0; i < 5 ; i++){
                    while(true){
                        int xfruta = (random.nextInt(x-2) + 1), yfruta = (random.nextInt(y-2) + 1);
                        if(tablero[xfruta][yfruta] == ' '){ // Si la casilla se encuentra vacía
                            tablero[xfruta][yfruta] = '\u00F0';
                            break;
                        }
                    }
                }






                //Imprimimos el tablero entero por primera vez
                actualizarPuntero(movimientos, fruta, punteo, (x3 + 2), tablero);
                imprimirmatriz(tablero, x2);


                //Obtenemos la hora de inicio
                String hora_inicial = obtenerHora();

                //Entramos a un loop mientras el usuario juega
                boolean juegoGanado = false;
                while(true){


                    // Solicitamos la instrucción como un char
                    System.out.println("\nMueva al pacman con las teclas A,W,S,D. \t Presione M para finalizar el juego.\n");
                    String instruccion = leer.nextLine().trim();
                    char tecla_ingresada = ' ';


                    if(instruccion.length() != 1){ //Si se ingresa una opción inválida
                        System.out.println("Ingrese una instrucción válida. A, W, S, D ó M");
                    } else {
                        tecla_ingresada = instruccion.charAt(0);
                    }

                    // Salir con M
                    if(tecla_ingresada == 'm' || tecla_ingresada == 'M'){
                        break;
                    }

                    // Enviamos la instrucción y almacenamos los datos
                    int Datos[] = moverPacman(tecla_ingresada, Pacman[0], Pacman[1], tablero, x, y, fruta);

                    // Si se movió
                    if(Datos[3] == 1){
                        //Actualizamos la posición del pacman
                        Pacman[0] = Datos[0];
                        Pacman[1] = Datos[1];

                        //Actualizamos los datos del tablero
                        movimientos = Datos[3] + movimientos;
                        punteo = Datos[2] + punteo;
                        if(Datos[4] != 0){ // Si comió una fruta actualizamos el puntero
                            fruta = Datos[4];

                            while(true){ //Generamos una nueva fruta instantáneamente
                                int xfruta = (random.nextInt(x-2) + 1), yfruta = (random.nextInt(y-2) + 1);
                                if(tablero[xfruta][yfruta] == ' '){ // Si la casilla se encuentra vacía
                                    tablero[xfruta][yfruta] = '\u00F0';
                                    break;
                                }
                            }

                        }

                        actualizarPuntero(movimientos, fruta, punteo, (x3 + 2), tablero);
                        limpiarConsola();
                        imprimirmatriz(tablero, x2);

                        if(punteo >= 30){ //Si se alcanzan los 30 pts se termina el juego
                            juegoGanado = true;
                            break;
                        }

                    } else { // Si no se movió
                        limpiarConsola();
                        imprimirmatriz(tablero, x2);
                        System.out.print("\t¡El Pacman no puede moverse en esa dirección!");
                    }



                }

                // Inmediatamente al salir del juego se toma la hora
                String hora_final = obtenerHora();

                // Se piden los datos para almacenarlos
                limpiarConsola();
                System.out.println("\t\t JUEGO FINALIZADO!");
                if(juegoGanado){
                    System.out.println("FELICITACIONES, HAS GANADO");
                } else{
                    System.out.println("HAS SALIDO DEL JUEGO.");
                }



                // Solicitamos el nombre al usuario
                while(true){
                    System.out.println("Porfavor ingresa tu nombre: (Máximo 7 carácteres)");
                    String nombre = leer.nextLine().trim().toUpperCase();
                    if(nombre.length() > 0 && nombre.length() < 8){
                        datosPuntuaciones[0][0] = nombre;
                        break;
                    }
                }

                // Almacenamos el resto de datos
                datosPuntuaciones[0][1] = String.valueOf(punteo);
                datosPuntuaciones[0][2] = String.valueOf(movimientos);
                datosPuntuaciones[0][3] = hora_inicial;
                datosPuntuaciones[0][4] = hora_final;


            } else if (menu == 2){ // Se visualizan las últimas 5 puntuaciones


                while(true){

                    limpiarConsola(); //Se limpia la consola
                    imprimirPunteo(datosPuntuaciones);

                    // Solicitamos la instrucción para regresar al menú
                    String instruccion = leer.nextLine().trim();
                    char tecla_ingresada = ' ';
                    if(instruccion.length() != 1){ //Si se ingresa una opción inválida
                        System.out.println("Ingrese M para volver al menú.");
                    } else {
                        tecla_ingresada = instruccion.charAt(0);
                    }

                    // Salir con M
                    if(tecla_ingresada == 'm' || tecla_ingresada == 'M'){
                        break;
                    }
                }



            }else if (menu == 3){
                break; //Se deja de ejecutar el código
            }


        }

    }

}
