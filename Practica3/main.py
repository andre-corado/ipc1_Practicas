# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

import os
import random

class Fruta:
    def __init__(self):
        self.punteo = random.randint(1, 5)
        while True:
            columna = random.randint(1, 40)
            fila = random.randint(1, 15)
            if tablero[fila][columna] == ' ':
                self.columna = columna
                self.fila = fila
                tablero[fila][columna] = 'ð'
                break

class Pacman:
    def __init__(self):
        while True:
            self.char = 'C'
            columna = random.randint(1, 40)
            fila = random.randint(1, 15)
            if tablero[fila][columna] == ' ':
                self.columna = columna
                self.fila = fila
                tablero[fila][columna] = self.char
                break

def printTablero():
    limpiarConsola()
    updatePuntero()

    for i in range(6):
        print()
    for fila in tablero:
        print('\t', end=" ")
        for valor in fila:
            print(valor, end=" ")
        print()
    pass

def crearTablero():
# Tablero de juego
    # Bordes externos
    for fila in range(filas):
        for columna in range(42):
            if columna == 0 or columna == 41 or fila == filas - 1 or fila == 0:
                tablero[fila][columna] = '▄'

    # Bordes internos
    for columna in range(8, 31):
        tablero[8][columna] = '\u25A0'
    for columna in range(1, 7):
        tablero[11][columna] = '\u25A0'
    for columna in range(34, 41):
        tablero[5][columna] = '\u25A0'
    for columna in range(5, 13):
        tablero[4][columna] = '\u25A0'
    for columna in range(26, 34):
        tablero[12][columna] = '\u25A0'
    for fila in range(1, 13):
        tablero[fila][13] = '\u25A0'
    for fila in range(14, 16):
        tablero[fila][7] = '\u25A0'
    for fila in range(4, 15):
        tablero[fila][31] = '\u25A0'
    for fila in range(8, 12):
        tablero[fila][36] = '\u25A0'
    for fila in range(5, 16):
        tablero[fila][21] = '\u25A0'

    # Se añaden frutas
    for i in range(5):
        frutas.append(Fruta())

# Tablero de Punteo
    for fila in range(10):
        for columna in range(44, columnas):
            if columna == 44 or columna == 61 or fila == 0 or fila == 3 or fila == 6 or fila == 9:
                tablero[fila][columna] = '°'

    for columna in range(46,52):
        mensaje = ['P', 'U', 'N', 'T', 'O', 'S']
        tablero[1][columna] = mensaje[columna- 46]

    for columna in range(46, 57):
        mensaje = ['M', 'O', 'V', 'I', 'M', 'I', 'E', 'N', 'T', 'O', 'S']
        tablero[4][columna] = mensaje[columna - 46]

    for columna in range(46, 58):
        mensaje = ['Ú', 'L', 'T', 'I', 'M', 'A', ' ', 'F', 'R', 'U', 'T', 'A']
        tablero[7][columna] = mensaje[columna - 46]
    pass

def limpiarConsola():
    os.system("cls")
    pass

def printDespedida():
    print("\n" * 8)
    print("\t" * 9 + " GAME OVER\n\n")
    print("\t" * 8 + "¿Deseas jugar de nuevo?\n\n")
    print("\t" * 2 + "\u25A0 Ingrese 1 para jugar de nuevo.\n\n\n")
    print("\t" * 5 + "Para salir presione cualquier letra seguido de Enter.")
    pass

def updatePuntero():
    puntos = [str(int(punteo/10)), str(int(punteo % 10))]
    noMovimiento = [str(int(movimientos / 100)), str(int(movimientos / 10) - int(movimientos / 100) * 10), str(int(movimientos % 10))]

    for columna in range(58, 60):
        tablero[2][columna] = puntos[columna - 58]
    for columna in range(57, 60):
        tablero[5][columna] = noMovimiento[columna - 57]
    tablero[8][59] = str(ultFruta)
    pass

def moverPacman():
    futuraFila = -1
    futuraColumna = -1
# Según la instrucción
    if instruccion == 'W' or instruccion == 'w':
        futuraFila = pacman.fila - 1
        futuraColumna = pacman.columna
    elif instruccion == 'S' or instruccion == 's':
        futuraFila = pacman.fila + 1
        futuraColumna = pacman.columna
    elif instruccion == 'D' or instruccion == 'd':
        futuraFila = pacman.fila
        futuraColumna = pacman.columna + 1
    elif instruccion == 'A' or instruccion == 'a':
        futuraFila = pacman.fila
        futuraColumna = pacman.columna - 1


    if futuraFila == 0:
        futuraFila = 15
    elif futuraFila == 16:
        futuraFila = 1

    if futuraColumna == 0:
        futuraColumna = 40
    elif futuraColumna == 41:
        futuraColumna = 1

# Si es movimiento válido

    if tablero[futuraFila][futuraColumna] != '\u25A0':
        tablero[pacman.fila][pacman.columna] = ' '
        pacman.fila = futuraFila
        pacman.columna = futuraColumna

        # Si es una fruta
        if tablero[pacman.fila][pacman.columna] == 'ð':
            for fruta in frutas:
                if fruta.fila == pacman.fila and fruta.columna == pacman.columna:
                    global ultFruta
                    ultFruta = fruta.punteo
                    global punteo
                    punteo += fruta.punteo
                    frutas[frutas.index(fruta)] = Fruta()
                    break
        tablero[pacman.fila][pacman.columna] = pacman.char
        global movimientos
        movimientos += 1
        printTablero()
    else:
        printTablero()
        print("\t¡El pacman no puede moverse en esa dirección!")
    pass


if __name__ == '__main__':
    filas = 17
    columnas = 62
    opcion = '1'


    while True:
        frutas = []
        tablero = []

        for i in range(filas):
            tablero.append([' '] * columnas)
        crearTablero()

        # Se añade el pacman
        pacman = Pacman()

        # Se reinician los valores del tablero de puntuaciones
        punteo = 0
        movimientos = 0
        ultFruta = 0

        printTablero()
        while True:
            print("\n\nMueva al pacman con las teclas A,W,S,D.\t Presione M para finalizar el juego.")
            instruccion = str(input()).strip()

            while True:
                if len(instruccion) != 1:
                    printTablero()
                    print("Ingrese una instrucción válida. A, W, S, D ó M")
                    instruccion = str(input())
                elif instruccion == 'M' or instruccion == 'm' or instruccion == 'A' or instruccion == 'a' or instruccion == 'W' or instruccion == 'w' or instruccion == 'S' or instruccion == 's' or instruccion == 'D' or instruccion == 'd':
                    break
                else:
                    printTablero()
                    print("Ingrese una instrucción válida. A, W, S, D ó M")
                    instruccion = str(input())

            if instruccion == 'm' or instruccion == 'M':
                break
            moverPacman()
            if punteo >= 30:
                break

        limpiarConsola()
        printDespedida()
        if str(input().strip()) != '1':
            break





