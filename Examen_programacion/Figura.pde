class Figura{

int px;
int py;
int vx;
int vy;

float diameter;
float tamX;
float moverX;
float moverY;
float ejeX;
float ejeY;

Figura (){

this.px = width/2;
this.py = height/2;
this.vx = vx;
this.vy = vy;

}

// movimiento del objeto
void forma(float tamano){
tamX = tamano;
for (int i = -375; i < 200; i = i+25) {
for (int j = 5; j < 500; j = j+55) {
fill(0,15);

// Interaccion tecla "a", cambia a forma rect
if (que == 0) {
rect(i-25,j-400, tamano, tamano);
}

// Interaccion tecla "s", cambia a circulos
if (que == 1) {
  ellipse(i-25,j-400, tamano, tamano);
}

// Interaccion tecla "d", cambia a lineas
if (que == 2 ) {
  line(i-25,j-400, tamano, tamano);
}
}
}
}

// Movimientos de la forma
void mov(float ejeX, float ejeY){
moverX = ejeX;
moverY = ejeY;
rect(ejeX, ejeY ,100,100);


// Bordes
if(ejeX > 800){
ejeX = 0;
ejeY = 0;
}

if(ejeX < -10){
ejeX = 0;
ejeY = 0;
}


if(ejeY < -10){
ejeX = 0;
ejeY = 0;
}

if(ejeY > 800 ){
ejeX = 0;
ejeY = 0;
}
}
}
