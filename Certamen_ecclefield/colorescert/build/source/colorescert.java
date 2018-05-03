import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class colorescert extends PApplet {

// VARILES DE POCISION

float x;
float y;
int f = 24;
// VARIABLE DE COLOR

int from = color(204, 102, 0);           // DESDE
int to = color(0, 102, 153);             // HASTA
int interA = lerpColor(from, to, .33f);   // Pibote intermedio de color
int interB = lerpColor(from, to, .66f);   // Pibote intermedio de color

int c1,c2;

int desde = color     (208,80,114);
int hasta = color     (96,151,158);
int medG  = lerpColor (desde, hasta, .33f);
int medH  = lerpColor (desde, hasta, .66f);


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
int [] lista;

public void setup(){

 c1 = color(235,139,184);
 c2 = color(199,229,219);

 
 lista = new int[f];                  // f represenata el total de los objetos en lista
 for(int i = 0; i < f/2; i ++){         //  f/2 para que el maximo del for se manifieste justo en la mitad
 float amt = map(i,0,f/2,0,1);          // mapear el valor de i para incorporarlo al lerp ("solo acepta 1 - 0")
 lista[i] = lerpColor(c1,c2,amt);       // Esta lista es la que describe los limites de colores (En el lerp)
 }
}

public void draw(){
//fill(0);
// for (int i = 0; i < 10; i ++){
// fill(cObjeto);
// fill(lista[i]);
//   ellipse(x + i *22, y + i*22,20,20);
// }
  background(255);
  fill(c1);

    rect(10,10,50,50);

  //noStroke();
  stroke(0);
  strokeWeight(3);
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
  //    noStroke();                    // sin bordes
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
  public void settings() {  size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "colorescert" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
