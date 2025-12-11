import pygame
from pygame.locals import *
import sys
import random

# Para el ejercicio intente extrapolar el propuesto con un laberinto en clase pero me daba errores con los movimientos introducidos por
# teclado asi que he seguido este tutorial he introducido las funcionalidades por mi cuenta https://www.youtube.com/watch?v=ebVV-6QMUIU
pygame.init() # Iniciamos pygame

ANCHO = 800
ALTO = 800
CASILLA = 50

PANTALLA = pygame.display.set_mode((ALTO, ANCHO)) # creamos una pantalla con el alto y ancho especificados
pygame.display.set_caption("SNAKE") # Establece el titulo de la ventana
RELOJ = pygame.time.Clock() # Esto crea un temporizador para eventos de tiempo en el juego

class Serpiente: # definimos la clase serpiente
    def __init__(self):
        self.x = CASILLA # posiciones ejes x e y con tamaño de la casilla
        self.y = CASILLA
        self.direccionx = 1 # direccion x sera 1 y la y 0 como en el ejercicio del laberinto
        self.direcciony = 0
        self.cabeza =  pygame.Rect(self.x,self.y,CASILLA, CASILLA) # para la cabeza creamos un rectangulo (posicion horizontal, posicion vertical, dimension horizontal, dimension vertical)
        self.cuerpo = [pygame.Rect(self.x-CASILLA,self.y,CASILLA, CASILLA)] # el cuerpo sera un array de rectangulos del mismo tipo
        self.muerto = False 

    def actualizar(self):
        global manzana # sin esto no podemos acceder a la manzana que ya esta creada fuera de la clase

        for cuadrado in self.cuerpo:
            if self.cabeza.x == cuadrado.x and self.cabeza.y == cuadrado.y:
                self.muerto = True # si la cabeza coincide con cualquier cuadrado del cuerpo morimos
            
        if self.cabeza.x > ANCHO: # si nuestra cabeza supera el ancho de la pantalla aparecemos en la posicion 0 del array x
            self.cabeza.x = 0
        if self.cabeza.y > ALTO: # si supera se sale por el borde inferior de la pantalla aparece arriba
            self.cabeza.y = 0
        if self.cabeza.x < 0: # si se sale por la izquierda aparecera por la derecha
            self.cabeza.x = ANCHO
        if self.cabeza.y < 0: # si se sale por la parte superior aparecera desde abajo
            self.cabeza.y = ALTO
    
        if self.muerto:
            # si morimos reiniciamos todos los valores a los iniciales del constructor y creamos una nueva manzana para que reaparezca en otro lugar random
            self.x, self.y = CASILLA, CASILLA
            self.cabeza = pygame.Rect(self.x, self.y, CASILLA, CASILLA)
            self.cuerpo = [pygame.Rect(self.x, self.y, CASILLA, CASILLA)]
            self.direccionx = 1
            self.direcciony = 0
            self.muerto = False
            manzana = Manzana()
                

        self.cuerpo.append(self.cabeza) # unimos la cabeza al array del cuerpo, esto porque la cabeza se comporta diferente al resto de casillas del cuerpo
        
        for i in range(len(self.cuerpo)-1): # cada rectangulo del cuerpo se movera a la posicion de su rectangulo anterior
            self.cuerpo[i].x, self.cuerpo[i].y = self.cuerpo[i+1].x, self.cuerpo[i+1].y

        self.cabeza.x += self.direccionx * CASILLA # la cabeza se mueve una casilla en la ultima direccion especificada cada vez que serpiente se actualice
        self.cabeza.y += self.direcciony * CASILLA
        self.cuerpo.remove(self.cabeza) # eliminamos la antigua cabeza
        

class Manzana: # creamos una clase manzana
    def __init__(self):
        self.x = int(random.randint(0,ANCHO)/CASILLA)*CASILLA # la posicion la generamos con randint un in aleatorio, como esto puede colocarnos en posiciones que no cuadran con el tablero
        self.y = int(random.randint(0,ALTO)/CASILLA)*CASILLA # lo dividimos entre el tamaño de la casilla y lo volvemos a multiplicar por tamaño de casilla, esto redondeara el numero a uno valido para el tablero
        self.rect = pygame.Rect(self.x, self.y, CASILLA, CASILLA) # creamos el rectangulo
    
    def actualizar(self):
        pygame.draw.rect(PANTALLA, "red" , self.rect ) # cada vez que se actualice la manzana se coloreara en la pantalla de color rojo

def dibujarMapa():
    for i in range(0, ANCHO, CASILLA): # recorre todo el ancho de la pantalla en incrementos del tamaño de la casilla
        for j in range(0, ALTO, CASILLA):
            rect = pygame.Rect(i,j,CASILLA,CASILLA) # dibuja una casilla por cada hueco de 50 que quepa en el mapa
            pygame.draw.rect(PANTALLA, "#454545", rect, 1) # Con esto dibuja en pantalla, del color especificado, el rect en una proporcion de a 1

# creamos las variables que utilizaremos y llamamos al metodo dibujar mapa
dibujarMapa()
serpiente = Serpiente() 
manzana = Manzana()
velocidad = 2 
sonido = pygame.mixer.Sound("snakePython/comer.mp3") # esto carga un sonido de un archivo mp3

while True:
    for event in pygame.event.get():
        if event.type == QUIT: # Si pulsamos el boton de cerrar parara el juego
            pygame.quit()
            sys.exit()
        if event.type == pygame.KEYDOWN: # esto indica que una tecla ha sido pulsada
            if event.key == pygame.K_DOWN: # si la tecla pulsada es flecha hacia abajo indicamos que la direccion vertical sera 1
                if serpiente.direcciony != -1: # siempre que la direccion anterior no fuera hacia arriba
                    serpiente.direcciony = 1
                    serpiente.direccionx = 0
            if event.key == pygame.K_UP: # flecha arriba = -1 en el eje y siempre que el movimiento ultimo no fuera hacia abajo
                if serpiente.direcciony != 1:
                    serpiente.direcciony = -1
                    serpiente.direccionx = 0
            if event.key == pygame.K_LEFT: # flecha izquierda = -1 en el eje x siempre que el ultimo movimiento no fuera el contrario
                if serpiente.direccionx != 1:
                    serpiente.direcciony = 0
                    serpiente.direccionx = -1
            if event.key == pygame.K_RIGHT: # flecha derecha = 1 en el eje x
                if serpiente.direccionx != -1:
                    serpiente.direcciony = 0
                    serpiente.direccionx = 1
                

       
    serpiente.actualizar() # por cada vuelta del bucle while actualizaremos serpiente y manzana 
    PANTALLA.fill('black') # pintaremos la pantalla de negro para que se descoloreen las casillas por donde ha pasado el cuerpo
    dibujarMapa() # redibujarmos el mapa
    manzana.actualizar() 
    

    pygame.draw.rect(PANTALLA, "green", serpiente.cabeza) 

    for cuadro in serpiente.cuerpo: # pintamos de verde los cuadros del cuerpo y la cabeza
        pygame.draw.rect(PANTALLA, "green", cuadro)

    if serpiente.cabeza.x == manzana.x and serpiente.cabeza.y == manzana.y:  # si la casilla de la cabeza pasa por la casilla de manzana
        serpiente.cuerpo.append(pygame.Rect(cuadro.x, cuadro.y, CASILLA, CASILLA)) # añadimos al cuerpo la casilla en la que nos encontramos
        sonido.play() # ejecutamos el efecto de sonido
        manzana = Manzana() # generamos otra manzana en un lugar random del mapa
        velocidad *= 1.1 # cada vez que comamos una manzana la velocidad aumetara un 10 %

    pygame.display.update() 
    RELOJ.tick(velocidad) # hace un evento de tiempo en funcion a la velocidad introducida



    