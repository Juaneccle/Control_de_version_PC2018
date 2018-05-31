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

public class Examen_programacion extends PApplet {

// variables para el movimiento del objeto
int k;
int l;
float que = 5;
Figura a;

public void setup(){

// Inicializacion de clase
a = new Figura();
}

public void draw(){

fill(255,20);        // Color fondo
rect(0,0,800,800);   // Fondo

pushMatrix();
translate(width/2, height/2);
a.forma(mouseX);
popMatrix();
a.mov(k,l);
}


public void keyPressed(){
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
public void forma(float tamano){
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
public void mov(float ejeX, float ejeY){
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
  public void settings() { 
size(800, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Examen_programacion" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
