// la gaby provoca movimientos diagonales en su sketch usando boolean
// variables para el movimiento del objeto
int k;
int l;
float que = 5;
Figura a;

int dirX;
int dirY;

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
k+dirX;
l+dirY;
}


void keyPressed(){
// Gatilladores de la interaccion
if (key == 'q' || key == 'Q') {
    dirX = -1;
}
if (key == 'w' || key == 'W'){
    dirX = 1;
}
if (key == 'e' || key == 'E') {
    l++;
}

if (key == 'r' || key == 'R') {
    l--;
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

agrgando otra variable de velocidad al movimiento booleano,
se le van sumanod
