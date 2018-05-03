// VARILES DE POCISION

float x;
float y;

// VARIABLE DE COLOR

color from = color(204, 102, 0);           // DESDE
color to = color(0, 102, 153);             // HASTA
color interA = lerpColor(from, to, .33);   // Pibote intermedio de color
color interB = lerpColor(from, to, .66);   // Pibote intermedio de color

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

void setup(){
 size(800,800);
}

void draw(){
fill(0);
background(255);
line(x1, y1, x2, y2);

  noStroke();
  translate(width/2, height/2);       // punto (0,0)/ ORIGEN en el centro del sketch
  for(int i = 0; i < 360; i+=15.5){      // i = angulo de rotacion 0-360/ Separacion entre lineas
    // float x = sin(radians(i))*150;  // variable de rotacion
    //float y = cos(radians(i))*150;  // variable de rotacion

      pushMatrix();

      translate(x, y);
      rotate(radians(i));    // proporciona movimiento al sketch/ cambia los ejes/ direccion de rotacion
      noStroke();                    // sin bordes
      lerpColor(desde,hasta,medG);
      rect(20, 20, 120, 20, 25);

      popMatrix();

  }

  stroke(255);
  fill(desde);
  ellipse(10,y, 50,50);
  fill(medG);
  ellipse(30,y, 50,50);
  fill(medH);
  ellipse(50,y, 50,50);
  fill(hasta);
  ellipse(80,y, 50,50);

  noFill();
  // EL ORDEN SI IMPORTA

stroke(255);
fill(from);
rect(10, 20, 20, 60);
fill(interA);
rect(30, 20, 20, 60);
fill(interB);
rect(50, 20, 20, 60);
fill(to);
rect(70, 20, 20, 60);

}



/*
// APLICACION PARA HACER CAJITAS CHORAS
niceBox

CUD

PROCESO DE CAM

*/
