// la gaby provoca movimientos diagonales en su sketch usando boolean
// variables para el movimiento del objeto

// VER SI O SI: VARIABLE.IO
Figura a;

boolean di,dd,da,

int k;
int l;
int dirX;
int dirY;

float que = 5;


void setup(){
size(800, 800);
// Inicializacion de clase
a = new Figura();
}

void draw(){

fill(255,20);        // Color fondo
rect(0,0,800,800);   // Fondo

pushMatrix();
translate(width/2, height/2);
a.forma(mouseX);
popMatrix();
a.mov(k,l);
k += dirX;
l += dirY;
}


void keyPressed(){
// Gatilladores de la interaccion
if (key == 'q' || key == 'Q') { dirX = -1;
}
if (key == 'w' || key == 'W'){
    dirX = 1;
}
if (key == 'e' || key == 'E') {
    //l++;
    dirY = -1;
}


if (key == 'r' || key == 'R') {
    dirY = 1;
    //l--;
}
if (key == 'a' || key == 'Q') {
    que=0;
}
if (key == 's' || key == 'W'){
    que=1;
}
if (key == 'd' || key == 'E') {
    que=2;
}
}



/*

// variables
boolan i, d, a, ab;

agrgando otra variable de velocidad al movimiento booleano,
se le van sumando para generar otras direcciones. la velocidad
al final le permite frenar y cambiar de direccion.

if (a){ velx+= 0,1}     // si el boolenao es verdadero
if (b){ velx-= 0,1}     // si el boolenao es verdadero
if (c){ vely+= 0,1}     // si el boolenao es verdadero
if (d){ vely-= 0,1}     // si el boolenao es verdadero

tambien se puede cambiar a int: " se hace otra funcion que se llame movint" con nuevas variables y todo

if (a){ velx+= 0,1}     // si el boolenao es verdadero
if (b){ velx-= 0,1}     // si el boolenao es verdadero
if (c){ vely+= 0,1}     // si el boolenao es verdadero
if (d){ vely-= 0,1}     // si el boolenao es verdadero

Encargo:
- Hacer un segundo objeto
- Crear dos objetos distintos "Figura o, p"
- Las modificaciones de inicio se hacen en el constructor, al igual que en
  en el video de schieffman.
- Se tienen que hacer las modificaciones de inicio ahora
- Ver el video de schiefmannnn!!!  CTM
- 

*/
