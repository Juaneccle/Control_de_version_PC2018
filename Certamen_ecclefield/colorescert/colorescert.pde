// VARILES DE POCISION

float x;
float y;
int f = 24;
// VARIABLE DE COLOR

color from = color(204, 102, 0);           // DESDE
color to = color(0, 102, 153);             // HASTA
color interA = lerpColor(from, to, .33);   // Pibote intermedio de color
color interB = lerpColor(from, to, .66);   // Pibote intermedio de color

color cObjeto, c1,c2;

color desde = color     (208,80,114);
color hasta = color     (96,151,158);
color medG  = lerpColor (desde, hasta, .33);
color medH  = lerpColor (desde, hasta, .66);


// POS

int x1 = 0;
int y1 = 400;
int x2 = 80;
int y2 = 90;

// COLOR

int r = 0;
int g = 0;
int b = 0;

// LISTAS
color [] lista;

void setup(){

 c1 = color(235,139,184);
 c2 = color(199,229,219);

 size(800,800);
 lista = new color[f];
 for(int i = 0; i < f/2; i ++){
 float amt = map(i,0,f/2,0,1);
 lista[i] = lerpColor(c1,c2,amt);
 }
}

void draw(){
//fill(0);
// for (int i = 0; i < 10; i ++){
// fill(cObjeto);
// fill(lista[i]);
//   ellipse(x + i *22, y + i*22,20,20);
// }
background(255);

  noStroke();
  translate(width/2, height/2);       // punto (0,0)/ ORIGEN en el centro del sketch
  for(int i = 0; i < f; i++){      // i = angulo de rotacion 0-360/ Separacion entre lineas
    // float x = sin(radians(i))*150;  // variable de rotacion
    //float y = cos(radians(i))*150;  // variable de rotacion

      //pushMatrix();
  if (i < 12){
    fill(lista[i]);
  }
else {
  fill(lista[(f-1)-i]);
}

      translate(x, y);
   rotate(radians(360/f));
      //rotate(radians(i));    // proporciona movimiento al sketch/ cambia los ejes/ direccion de rotacion
      noStroke();                    // sin bordes
    //  lerpColor(desde,hasta,medG);
      rect(20, 20, 120, 20, 25);

    //  popMatrix();

  }

//   stroke(255);
//   fill(desde);
//   ellipse(10,y, 50,50);
//   fill(medG);
//   ellipse(30,y, 50,50);
//   fill(medH);
//   ellipse(50,y, 50,50);
//   fill(hasta);
//   ellipse(80,y, 50,50);
//
//   noFill();
//   // EL ORDEN SI IMPORTA
//
// stroke(255);
// fill(from);
// rect(10, 20, 20, 60);
// fill(interA);
// rect(30, 20, 20, 60);
// fill(interB);
// rect(50, 20, 20, 60);
// fill(to);
// rect(70, 20, 20, 60);

}

////////////////////////// CORRECCION DE COLOR ////////////////////////////////
/*
void setup(){
size (500,500);
noStroke();
c1 = color(235,139,184);
c2 = color(199,229,219);
lista = new color[10];
for(int i = 0; i < 10; i ++){
float amt = map(i,0,0,1);
lista[i] = lerpColor(c1,c2,amt);
}


*/

/*
// APLICACION PARA HACER CAJITAS CHORAS
niceBox

CUD

PROCESO DE CAM

*/
