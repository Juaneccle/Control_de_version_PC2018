// variables para el movimiento del objeto
int k;
int l;

Figura a;

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


// Gatilladores de la interaccion
if (key == 'q' || key == 'Q') {
    k++;
}
if (key == 'w' || key == 'W'){
    k--;
}
if (key == 'e' || key == 'E') {
    l++;
}

if (key == 'r' || key == 'R') {
    l--;
}

}
