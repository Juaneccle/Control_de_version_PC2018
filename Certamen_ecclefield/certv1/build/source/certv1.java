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

/*
//INSTRUCCIONES//

1.-
2.-
3.-
4.-



//////////////////////////////////// SKETCH ////////////////////////////////////

//OBJETIVOS: // HACER QUE CAMBIE DE COLOR CON ArrayList DE COLOR/
             // HACER QUE LA VELOCIDAD CAMBIE CON KEYPRESSED
             // INCORPORAR UNA INTERACCION CON EL MOUSE (¿GRADIENTES? ¿COS, SIN? ¿?)

//////////////////////////////////// SKETCH ////////////////////////////////////

             //OBJETIVOS: // HACER QUE CAMBIE DE COLOR CON ArrayList DE COLOR/
                          // HACER QUE LA VELOCIDAD CAMBIE CON KEYPRESSED
                          // INCORPORAR UNA INTERACCION CON EL MOUSE (¿GRADIENTES? ¿COS, SIN? ¿?)

*/


// LISTAS
int[] colores;

//CLASES
Vert1 a;     // SE DEFINE LA CLASE

// COLOR CONTORNOS
int c1   = color(50,77,92);         // Original
int c1_c = color(0);                // cambio otro color stroke pequeño
int c2   = color(240,67,58);        // Original
int c2_c = color(255);              // cambio otro color stroke grande
int ef   = color(240, 202, 77);     // color ellipse del fondo
int ef_c = color(240, 202, 77);     // Cambia el color ellipse del fondo
int f1_c = color(0);                // Cambia color a negro: Afecta a lerp color
int t1_c = color(0);                // Cambia color a negro: Afecta a lerp color

// Cuarta paleta de colores

int c1_v = color(64, 21, 42);                                   // Afecta lado sombreado cambio otro color stroke pequeño
int c2_v = color(0);                                            // cambio otro color stroke grande
int c3_v = color(244, 205, 165);                                // Afecta al color de fondo
int ef_v = color(255, 82, 51);                                  // Afecta lado no sombreado color ellipse del fondo cambio
int efRandom = color(random(255),random(255),random(255));      // Definicion de un color random: se activa con la interaccion de la tecla "m"
int c1Random = color(random(255),random(255),random(255));      // Definicion de un color random: se activa con la interaccion de la tecla "m"

// Definición RGB para el lerp color
int cf1 = 237;
int cf2 = 82 ;
int cf3 = 118;
int ct1 = 70 ;
int ct2 = 179;
int ct3 = 157;

// VARIABLES GRADIENTES
int f1 = color(cf1,cf2, cf3);        // Inicio del lerp color
int t1 = color(ct1,ct2,ct3);         // Final del lerp color
int i1 = lerpColor(f1,t1,.15f);       // un punto intermedio dentro de estos dos colores
int i2 = lerpColor(f1,t1,.30f);       // un punto intermedio dentro de estos dos colores
int i3 = lerpColor(f1,t1,.45f);       // un punto intermedio dentro de estos dos colores
int i4 = lerpColor(f1,t1,.60f);       // un punto intermedio dentro de estos dos colores
int i5 = lerpColor(f1,t1,.75f);       // un punto intermedio dentro de estos dos colores
int i6 = lerpColor(f1,t1,.85f);       // un punto intermedio dentro de estos dos colores

float l = 0;                           // Para disminuir el movimiento en la interaccion con el mouse
float p;                               // Variable para cambiar de color (Palpitaciones)

// Variables de cambio permanente (Booleanas)
int k = 1;     // Variable permanente del Mouse
int j = 1;     // Variable permanente de la tecla b
int h = 1;     // Variable permanente de la tecla n
int g = 1;     // Variable permanente de la tecla m

public void setup(){

  colores = new int[3];
  colores[0] = color(random(255),random(255),random(255));      // Primer color random de la lista
  colores[1] = color(random(255),random(255),random(255));      // Segundo color random de la lista
  colores[2] = color(random(255),random(255),random(255));      // Tercer color random de la lista
  a = new Vert1();         // Incializacion de clases
             // Tamaño del sketch en pixeles
  background(255);         // Fondo global
}


public void draw(){

  p = p + 10;              // Variable para hacer que el fondo cambie de color constantemente
  background(255);         // Fondo permamente
  a.lerpcc();              //Gradiente usando lerp: Cargar una funcion desde la clase

///////////////////////////////// ELLIPSE CENTRAL ///////////////////////////////////

   noStroke();                                   // Sin Bordes
   fill(ef);                                     // Color de ellipse del centro
   ellipse(width/2, height/2, 300, 300);         // Ellipse del centro

/////////////////////////////////// ANILLO FONDO //////////////////////////////////

   strokeWeight(30);
   noStroke();                                      // Sin bordes
   translate(width/2, height/2);                    // punto (0,0)/ ORIGEN en el centro del sketch
   for(int i = 0; i < 360; i+=1.5f){                 // For que define: angulo máximo de rotación, cantidad de figuras y su separación
       float x = sin(radians(i))*150;               // variable de rotacion
       float y = cos(radians(i))*150;               // variable de rotacion
       pushMatrix();                                // Abriendo propiedades independientes
       translate(x, y);                             // Se traslada el origen, que al mismo tiempo esta en movimiento
       rotate(radians(-i+frameCount));              // proporciona movimiento al sketch/ cambia los ejes/ direccion de rotacion
       fill(sin(radians(p/2))*2*70, 179, 157);      // Se rellena la figura con el color original, pero es alterado en el canal R. (P.127) esto hara que palpite el anillo
       rect(0, 0, 120, 20, 25);                     // Se dibujan las figuras que se encuentran en el fondo
       popMatrix();                                 // Cerrando propiedades independientes
}

//////////////////////////////// INTERACCIÓN TECLA "M" /////////////////////////////////

  if(g == 2){                               // Condicion para interacción tecla "m"
    fill(colores[0]);                       // Se rellena con el primer color de la lista
    ellipse(0,0,1500,1500);                 // Se crea una elipse que cubre el sketch
    for(int i = 0; i < 360; i+=20)  {       // Forloop que define: angulo máximo de rotación, cantidad de figuras y su separación
       float x = sin(radians(i))*150;       // variable de rotación
       float y = cos(radians(i))*150;       // variable de rotación
       pushMatrix();                        // Abriendo propiedades independientes
       translate(x,y);                      // Se traslada el origen, que al mismo tiempo esta en movimiento
       rotate(radians(-i-frameCount+90));   // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
       noStroke();                          // Sin bordes
       fill(colores[1]);                    // Se rellena con el segundo color de la lista
       rect(0,50,120,20, 25);               // Se crean las figuras que estaran rotando
       popMatrix();                         // Cerrando propiedades independientes
  }

    for(int i = 0; i < 360; i+=15)  {       // Segundo forloop que define: angulo máximo de rotación, cantidad de figuras y su separación
       float x = sin(radians(i))*150;       // Variable de rotación
       float y = cos(radians(i))*150;       // Variable de rotación
       pushMatrix();                        // Abriendo propiedades independientes
       translate(x,y);                      // Se traslada el origen, que al mismo tiempo esta en movimiento
       rotate(radians(-i+frameCount+90));   // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
       noStroke();                          // Sin bordes
       fill(colores[1]);                    // Se rellena con el segundo color de la lista
       rect(0,30,20,20, 25);                // Se crean rectangulos pequeños con vertices suavisados
       rect(0,50,20,20, 25);                // Se crean rectangulos pequeños con vertices suavisados
       rect(0,70,20,20, 25);                // Se crean rectangulos pequeños con vertices suavisados
       rect(0,90,20,20, 25);                // Se crean rectangulos pequeños con vertices suavisados
       popMatrix();                         // Cerrando propiedades independientes
  }

  stroke(colores[2]);
  strokeWeight(50);
  noFill();
  ellipse(0,0,600,600);

}

//////////////////////////////// INTERACCIONES TECLA "N"  /////////////////////////////////

if (keyPressed) {                          // Estado permanente al apretar "n"
      if (key == 'n' || key == 'N') {      // Solo si apreta la tecla "n" o "N": Cambio de paleta y activación de boolean "h"
      c1 = c1_v;                           // Cambio de color desde el original al nuevo
      c2 = c2_v;                           // Cambio de color desde el original al nuevo
      ef = ef_v;                           // Cambio de color desde el original al nuevo
      h = 2;                               // Activación de boolean: Su valor cambia de 1 a 2
   }
 }

 if (h == 2){                               // Condicion para interacción tecla "n"
    fill(c3_v);                             // Se rellena con el color beige
    ellipse(0,0,1500,1500);                 // Se crea una elipse de fondo
    for(int i = 0; i < 360; i+=20)  {       // Forloop que define: angulo máximo de rotación, cantidad de figuras y su separación
       float x = sin(radians(i))*150;       // Variable de rotación
       float y = cos(radians(i))*150;       // Variable de rotación
       pushMatrix();                        // Abriendo propiedades independientes
       translate(x,y);                      // Se traslada el origen, que al mismo tiempo esta en movimiento
       rotate(radians(-i-frameCount+90));   // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
       noStroke();                          // Sin bordes
       fill(115,22,48);                     // Se rellena con un color burdeo
       rect(0,50,120,20, 25);               // Se crean las figuras que rotan
       popMatrix();                         // Cerrando propiedades independientes
    }
  stroke(c1_v);                             // Se define el color del borde
  strokeWeight(50);                         // Se define el ancho del borde
  noFill();                                 // Sin relleno
  ellipse(0,0,600,600);                     // Se crea una elipse que sirve como contorno y limite de tamaño para el resto de la interacción
  }

/////////////////////////////////////////////// ANILLO EXTERIOR //////////////////////////////////////////////////////////////

strokeWeight(30);                            // Se define el ancho del borde
for(int i = 0; i < 360; i+=12){              // Forloop que define: angulo máximo de rotación, cantidad de figuras y su separación
  float x = sin(radians(i))*150;             // Variable de rotación
  float y = cos(radians(i))*150;             // Variable de rotación
  pushMatrix();                              // Abriendo propiedades independientes
  translate(x, y);                           // Se traslada el origen, que al mismo tiempo esta en movimiento, esta vez para el lado contrario
  rotate(radians(-i+frameCount+90));         // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
  stroke(c1);                                // Se rellena el contorno con el color celeste
  fill(sin(radians(i/2))*255, 50, 100);      // Se rellena la figura con el color original, pero es alterado en el canal R. (P.127)
  rect(0, 0, 120, 20, 25);                   // Se crean las figuras que le dan forma al petalo
  popMatrix();                               // Cerrando propiedades independientes
               }

/////////////////////////////////////////////// ANILLO EXTERIOR 2 ///(/////////////////////////////////////////////////////////

for(int i = 0; i < 360; i+=12){
  float x = sin(radians(i))*150;            // Variable de rotación
  float y = cos(radians(i))*150;            // Variable de rotación
  pushMatrix();                             // Abriendo propiedades independientes
  translate(x, y);                          // Se traslada el origen, que al mismo tiempo esta en movimiento, esta vez para el lado contrario
  rotate(radians(-i+frameCount+90));        // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
  stroke(ef);                               // sin bordes
  fill(50, 50, 100);                        // Se rellena la figura con un color azul
  rect(0, 0, 120, 5, 15);                   // Se crean las figuras que componen el petalo: Parte no sombreada
  popMatrix();                              // Cerrando propiedades independientes
}

/////////////////////////////////// IINTERACCIÓN MOUSE ////////////////////////////////////////////

if (k == 2){
  fill(0xfff0ca4d);                          // Se rellena con el color Amarillo
  noStroke();                             // Colocar color de paleta seleccionada
  ellipse(0,0,600,600);                   // Elipse de fondoque va a tapar el sketch
  for(int i = 0; i < 360; i+=10){         // Forloop que define: angulo máximo de rotación, cantidad de figuras y su separación
     rotate(radians(l));                  // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
     stroke(0xffde5b49);                     // Color de bordes
     fill(0xff3c989e);                       // Color relleno de ellipses pequeñas y rectangulos del borde
     rect(0,0,120,5,15);                  // Rectangulo central de la interacción
     rect(160,160,50,50);                 // Rectangulos perifericos
     noStroke();                          // Sin bordes
     ellipse(120,120,15,15);              // Elipses pequeñas que se forman en la interaccón
  }

  strokeWeight(60);               // Contorno figura interactiva
  stroke(0xff324d5c);                // Color contorno de la figura
  noFill();                       // Para que sea solo el contorno / Sin relleno
  ellipse(0,0, 600, 600);         // Se crea una elipse del mismo tamaño que el sketch anterior
  noStroke();                     // Sin bordes
  fill(0xff324d5c);                  // Color elipse central de la interacción
  ellipse(0,0,120,120);           // Elipse central de la interacción
}

/////////////////////////////////// INTERACCIÓN TECLA "b" ///////////////////////////////////////
if (j == 2){
  strokeWeight(40);               // Ancho de bordes de la figura
  stroke(255);                    // Relleno de los contornos con el color blanco
  noFill();                       // Sin relleno
  ellipse(0,0, 560,560);          // Elipse negra que tapa las figuras de colores
  strokeWeight(20);               // Ancho de bordes de la figura
  stroke(0);                      // Ancho de bordes de la figura
  ellipse(0,0, 500,500);          // Elipse negra que tapa las figuras de colores
}

//////////////////////////////////////// INTERACCIONES ///////////////////////////////////////

//Boton nueva forma
if (mousePressed) {               // Interacción con el mouse
  k = 2;                          // Activa booleana "k"
  j = 1;                          // Desactiva booleana "j"
  l = l + 0.1f;                    // Constante de movimiento: se le suma al float "l" 0.1 mientras preciono el mouse
  } else {                        // Si no se cumple la condicion
    k = 1;                        // Desactiva booleana "k"
}

// Boton cambio de color y nueva figura
if (keyPressed) {                        // Interacción de teclado
  if (key == 'm' || key == 'M') {        // Cuando apreto la tecla "m" o "M"
    g = 2;                               // Se activa la booleana "g"
    ef = efRandom;                       // El color ef se convierte en un color Random
    }
}

// BOTON CAMBIO DE COLOR

if (keyPressed) {                           // Interacción de teclado
  if (key == 'b' || key == 'B') {           // Cuando apreto la tecla "b"
    j = 2;                                  // Se activa la booleana
    c1 = c1_c;                              // De color original a negro
    ef = c2_c;                              // De color original a blanco
    f1 = color (0);                         // Cambio de color de lerpColor = Lerp "from"
    t1 = color(255);                        // Cambio de color de lerpColor = Lerp "to"
    }
}

// BOTON RESSET
if (keyPressed) {                               // Interacción tecla
  if (key == 'r' || key == 'R') {               // Cuando apreto la tecla "R"
    background(255);                            // Se crea un fondo para "borrar" todo
    c1_c = c1;                                  // los colores que han sido cambiados vuelven a su valor original
    c2_c = c2;                                  // los colores que han sido cambiados vuelven a su valor original
    ef_c = ef;                                  // los colores que han sido cambiados vuelven a su valor original
    j = 1;                                      // Se desactiva la booleana j
    f1 = color(237,82,118);                     // El incio del lerp vuelve a su color original
    t1 = color(70,179,157);                     // El final del lert vuelve a su color original
    }
}
}




















//////// PALETA PRINCIPALES ////////

// 1.-

//(63,43,55);                 // BURDEO OSCURO
//(84,0,50)                   // BURDEO no tan OSCURO
//(130,3,51)                  // MORADO
//(201,40,62)                 // ROJO
//(240,67,58)                 // NARANJO

// 2.-

// (#3c989e) (60, 152, 158)   // Celeste mas oscuro
// (#5db5a4) (93, 181, 164)   // CELESTE
// (#f4cda5) (244, 205, 165)  // beige
// (#f57a82) (245, 122, 130)  // rosado mas piola
// (#ed5276) (237,82, 118)    // ROSADO

// 3.-

//(#f0ca4d) (240, 202, 77)     // AMARILLO
//(#e37b40)                    // NARANJO
//(#46b39d)                    // CELESTE
//(#de5b49)                    // ROJISO
//(#324d5c) (50,77,92)         // GRIS AZULADO

// 4.-
//(38, 24, 34)                 // burdeo muy oscuro
//(64, 21, 42)                 // Morado oscuro
//(115, 22, 48)                // burdeo
//(204, 31, 45)                // Rojo
//(255, 82, 51)                // Naranjo




/*
int cf1 = 237;
int cf2 = 82 ;
int cf3 = 118;
int ct1 = 70 ;
int ct2 = 179;
int ct3 = 157;
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
             - ROTACION DE COORDENADAS POLARES: A difierencia de los movimientos en el plano, yo solo necesito
               un angulo y
             // cada elemento tiene que tener su pocicion
             float x, y;  // cordenadas cartesianas
             float angle, r;  // coordenadas polares
             void setup(){
             size(500,500);
             }
             void draw(){
             background(255);
             translate(width/2, heigth/2);
             ellipse(x,y 10,10)
             }
             ////////////////////////////// LERP COLOR ////////////////////////////
             float desdex, desdey, hastax, hastay;  // cordenadas cartesianas
             void setup(){
             size (500,500);
             fill(50);
             }
             void drwa(){
             background(255);
             //translate(width/2, height/2);
             desdex = lerp(desdex, hastax, 0);
             desdey = lerp(desdey, hastay, 0);
             ellipse(desdex, desdey, 10,10);
             }
             void mousePressed(){
             hastax = mouseX;
             hastay = mouseY;
             }
             */


/////////////////////////////////////                   ///////////////////////////////////
///////////////////////////////////// IDEAS ABANDONADAS ///////////////////////////////////
/////////////////////////////////////                   ///////////////////////////////////


/*
////// TODOs LO DEL COLOR ANTIGUO /////////
// //VARIABLES DE MOVMIENTO
 p = p + 5;
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
///////////////////////// ME ENRREDE EN ESTA PARTE ///////////////////
/*
// VARIABLES FLOAT
float p;
float cg;    // color gradient
float d;
// VARIABLES INT
int f = 240;
// VARIABLES DE COLOR
color c1,c2;
// LISTAS
color [] lista;
void setup(){
  size(800,800);
  c1    = color(235,139,184);               // Se define un color
  c2    = color(199,229,219);               // Se define otro color
  lista = new color[f];                     // f represenata el total de los objetos en lista
  for(int i   = 0; i < f/2; i ++){           //  f/2 para que el maximo del for se manifieste justo en la mitad
    float amt = map(i,0,f/2,0,1);            // mapear el valor de i para incorporarlo al lerp ("solo acepta 1 - 0")
    lista[i]  = lerpColor(c1,c2,amt);        // Esta lista es la que describe los limites de colores (En el lerp)
  }
}
void draw(){
// COMPROBACIONES
//println(cg);
p = p + 5;
background(214,190,130);
translate(width/2, height/2);
for(int i = 0; i < f; i++){           // i = angulo de rotacion 0-360/ Separacion entre lineas
  // float x = sin(radians(i))*150;   // variable de rotacion
  //float y = cos(radians(i))*150;    // variable de rotacion
if (i < 120){
  fill(lista[i]);
}
else {
fill(lista[(f-1)-i]);
 }
strokeWeight(1);
stroke(250,150,60);
//fill(20,50,90);
//ellipse(width/2, height/2, 300, 300);
//println(i);
float a = map (i, 0, 239, 0, TWO_PI);
    float x = sin(a)*150;            // variable de rotacion
      float y = cos(a)*150;            // variable de rotacion
      //fill(sin(radians(i/2))*255, 50, sin(radians(i*3))*100);   // fill con gradiente R0-R255, b0-b255
      //fill(sin(radians(p/2))*255, 150, 200);                      // esto hara que palpite el anillo
      //fill(sin(radians(i/2))*cg, 200, 150);                     // prueba gradientes cambiantes
      pushMatrix();
        translate(x, y);
        //rotate(radians(360/f));
        rotate(radians(-i+frameCount));                           // proporciona movimiento al sketch/ cambia los ejes/ direccion de rotacion
        noStroke();                                               // sin bordes
        rect(0, 0, 120, 2, 2);
      popMatrix();
  }
// ANILLO CENTRAL.
for(int i = 0; i < 360; i+=20){
      float x = sin(radians(i))*150;
      float y = cos(radians(i))*150;
      pushMatrix();
        translate(x, y);
        rotate(radians(-i+frameCount+90));            // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
        stroke(255);                                  // sin bordes
        fill(sin(radians(i/2))*255, 50, 100);
        rect(0, 0, 120, 20, 25);
      popMatrix();
  }
// LINEAS RECTAS
  for(int i = 0; i < 360; i+=10){
        float x = sin(radians(i))*150;               // suma al origen
        float y = cos(radians(i))*150;               // suma al origen // intenta sacarle a la multiplicacion
        pushMatrix();
          translate(x, y);                             // hace que no partan desde el punto (0,0)
          rotate(radians(-i+frameCount+90));           // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
          stroke(255);                                 // sin bordes
          fill(50, 50, 100);
          rect(0, 0, 120, 5, 15);
        popMatrix();
    }
}
//////////////////////////////////////////////////////////////////////
//////////////////////// DOCUMENTACION Y AVANCE //////////////////////
//////////////////////////////////////////////////////////////////////
- Revisar el leerpColor();
- ROTACION DE COORDENADAS POLARES: A difierencia de los movimientos en el plano, yo solo necesito
  un angulo y
// cada elemento tiene que tener su pocicion
float x, y;  // cordenadas cartesianas
float angle, r;  // coordenadas polares
void setup(){
size(500,500);
}
void draw(){
background(255);
translate(width/2, heigth/2);
ellipse(x,y 10,10)
}
////////////////////////////// LERP COLOR ////////////////////////////
float desdex, desdey, hastax, hastay;  // cordenadas cartesianas
void setup(){
size (500,500);
fill(50);
}
void drwa(){
background(255);
//translate(width/2, height/2);
desdex = lerp(desdex, hastax, 0);
desdey = lerp(desdey, hastay, 0);
ellipse(desdex, desdey, 10,10);
}
void mousePressed(){
hastax = mouseX;
hastay = mouseY;
}
*/

class Vert1{
  //float x;
  //float y;
  //Editor de color
  int r = 255  ;
  int g = 103 ;
  int b = 63 ;
Vert1(){

}


public void lerpcc(){
  noFill();
  // 1.-
  strokeWeight(165);
  stroke(t1);
  ellipse(height/2, width/2, 455,455);
  // 2.-
  strokeWeight(15);
  stroke(i6);
  ellipse(height/2, width/2, 475,475);
  // 3.-
  strokeWeight(15);
  stroke(i5);
  ellipse(height/2, width/2, 495,495);
  // 4.-
  strokeWeight(15);
  stroke(i4);
  ellipse(height/2, width/2, 515,515);
  // 5.-
  strokeWeight(15);
  stroke(i3);
  ellipse(height/2, width/2, 535,535);
  // 6.-
  strokeWeight(15);
  stroke(i2);
  ellipse(height/2, width/2, 555,555);
  // 7.-
  strokeWeight(15);
  stroke(i1);
  ellipse(height/2, width/2, 575,575);
  // 8.-
  strokeWeight(40);
  stroke(f1);
  ellipse(height/2, width/2, 620,620);
  }

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
  public void settings() {  size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "certv1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
