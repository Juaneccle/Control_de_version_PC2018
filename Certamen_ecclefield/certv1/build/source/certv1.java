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

public class certv1 extends PApplet {

//INSTRUCCIONES//
/*
1.-
2.-
3.-
4.-

*/


//////////////////////////////////// SKETCH ////////////////////////////////////

//OBJETIVOS: // HACER QUE CAMBIE DE COLOR CON ArrayList DE COLOR/
             // HACER QUE LA VELOCIDAD CAMBIE CON KEYPRESSED
             // INCORPORAR UNA INTERACCION CON EL MOUSE (¿GRADIENTES? ¿COS, SIN? ¿?)

float p;
float cg;   // color gradient
float f;
float d;

public void setup(){



}


public void draw(){
// COMPROBACIONES
//println(cg);

//VARIABLES DE MOVMIENTO
p = p + 10;
 cg = cg +10;

// Variables de contorno cambio de color
if (cg > 500){
 f = 1;
}

if (cg < -10){
 d = 1;
}
if (f == 1){
 cg = cg - 15;
}

if (d == 1){
 cg = cg + 15;
}
// ANILLO EXTERIOR 1
// ¿PALETA DE COLOR? vs ¿ARCOIRIS?
background(255);
//fill(255,200,80);
strokeWeight(30);
stroke(250,150,60);
fill(20,50,90);
ellipse(width/2, height/2, 300, 300);

 //strokeWeight(1);
noStroke();
  translate(width/2, height/2);       // punto (0,0)/ ORIGEN en el centro del sketch
  for(int i = 0; i < 360; i+=1.5f){      // i = angulo de rotacion 0-360/ Separacion entre lineas
      float x = sin(radians(i))*150;  // variable de rotacion
      float y = cos(radians(i))*150;  // variable de rotacion
      pushMatrix();
      translate(x, y);
  rotate(radians(-i+frameCount));    // proporciona movimiento al sketch/ cambia los ejes/ direccion de rotacion
      noStroke();                    // sin bordes
/////////////// ¿¿¿¿AGREGAR TRANSPARENCIA?????  /////////////////////
    //fill(sin(radians(i/2))*255, 50, sin(radians(i*3))*100);   // fill con gradiente R0-R255, b0-b255
    fill(sin(radians(p/2))*255, 150, 200);                    // esto hara que palpite el anillo
    //fill(sin(radians(i/2))*cg, 200, 150);                       // prueba gradientes cambiantes
      rect(0, 0, 120, 20, 25);
      popMatrix();

  }

// ANILLO CENTRAL.

for(int i = 0; i < 360; i+=20){
      float x = sin(radians(i))*150;
      float y = cos(radians(i))*150;
      pushMatrix();
      translate(x, y);
  rotate(radians(-i+frameCount+90));   // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
      stroke(255);                     // sin bordes
/////////////// ¿¿¿¿AGREGAR TRANSPARENCIA?????  /////////////////////
    fill(sin(radians(i/2))*255, 50, 100);
      rect(0, 0, 120, 20, 25);
      popMatrix();
  }

// ANILLO EXTERIOR 2

  for(int i = 0; i < 360; i+=10){
        float x = sin(radians(i))*150;  // suma al origen
        float y = cos(radians(i))*150;  // suma al origen // intenta sacarle a la multiplicacion
        pushMatrix();
        translate(x, y); // hace que no partan desde el punto (0,0)
    rotate(radians(-i+frameCount+90));   // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
        stroke(255);                     // sin bordes
  /////////////// ¿¿¿¿AGREGAR TRANSPARENCIA?????  /////////////////////
      fill(50, 50, 100);
        rect(0, 0, 120, 5, 15);
        popMatrix();
    }

}

/////////////////////////////////////                   ///////////////////////////////////
///////////////////////////////////// IDEAS ABANDONADAS ///////////////////////////////////
/////////////////////////////////////                   ///////////////////////////////////


/*
ArrayList<Vert1> lista = new ArrayList<Vert1>();

float p = 0;
float o = 0;
float i = 0;
Vert1 a;
*/
//void setup(){
  /*for (int i = 0; i < 20; i++){ // el numero 10 es la cantidad de figuras que aparecen
  a = new Vert1 (i,60);
  lista.add(a);
}
*/
// Inicializacion de la clase

//size(800,800);
//}


//void draw(){
/*for (Vert1 a : lista) {
a.bubls();
i = i +3;
}
*/

/*
p = p +3;
o = o +2;
background(200,150,190);
///////////////////////////////////////////////////
  pushMatrix();
  translate(width/2, height/2);
  rotate(radians(p));
  rect(-26, -26, 52, 52);
  popMatrix();
///////////////////////////////////////////////////
  pushMatrix();
  translate(50, 50);
  rotate(radians(p));
  a.bubls();
  rect(-26, -26, 52, 52);
  popMatrix();
///////////////////////////////////////////////////
//pushMatrix();
//a.lineas();
//popMatrix();
}



//////////////////////////////////////////////////////////////////////
//////////////////////// DOCUMENTACION Y AVANCE //////////////////////
//////////////////////////////////////////////////////////////////////

- Revisar el leerpColor();
-
*/

/*

class Vert1{
  float x;
  float y;
Vert1(float x, float y){

  this.x   = x  ;
  this.y   = y  ;
}


/*
void bubls(){
  //fill(50,80,100);
  translate(width/2, height/2);
  rotate(radians(p));
  rect(-26, -26, 52, 52);


}

}
*/
  public void settings() { 
size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "certv1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
