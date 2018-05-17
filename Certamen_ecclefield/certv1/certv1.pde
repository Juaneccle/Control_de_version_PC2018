/*
//INSTRUCCIONES//

1.	Presionando la tecla “n” se cambian los colores a una paleta de colores predefinida, además se agrega una forma que hace que la composición sea más interesante y distinta.
2.	Presionando la tecla “m” se cambian los colores a una paleta de colores aleatoria, además se le agrega una forma que hace que la composición sea más interesante y distinta.
3.	Presionando la tecla “b” algunos de los colores se cambian por blancos y negros.
4.	Presionando el mouse la composición se convierte en otra, con otros movimientos, colores y formas.
5.	Presionando la tecla  ”r” el sketch se reinicia.

//////////////////////////////////// SKETCH ////////////////////////////////////

//OBJETIVOS: // HACER QUE CAMBIE DE COLOR CON ArrayList DE COLOR/
             // HACER QUE LA VELOCIDAD CAMBIE CON KEYPRESSED
             // INCORPORAR UNA INTERACCION CON EL MOUSE (¿GRADIENTES? ¿COS, SIN? ¿?)
*/


// LISTAS
color[] colores;

//CLASES
Vert1 a;     // SE DEFINE LA CLASE

// COLOR CONTORNOS
color c1   = color(50,77,92);         // Original
color c1_c = color(0);                // cambio otro color stroke pequeño
color c2   = color(240,67,58);        // Original
color c2_c = color(255);              // cambio otro color stroke grande
color ef   = color(240, 202, 77);     // color ellipse del fondo
color ef_c = color(240, 202, 77);     // Cambia el color ellipse del fondo
color f1_c = color(0);                // Cambia color a negro: Afecta a lerp color
color t1_c = color(0);                // Cambia color a negro: Afecta a lerp color

// Cuarta paleta de colores

color c1_v = color(64, 21, 42);                                   // Afecta lado sombreado cambio otro color stroke pequeño
color c2_v = color(0);                                            // cambio otro color stroke grande
color c3_v = color(244, 205, 165);                                // Afecta al color de fondo
color ef_v = color(255, 82, 51);                                  // Afecta lado no sombreado color ellipse del fondo cambio
color efRandom = color(random(255),random(255),random(255));      // Definicion de un color random: se activa con la interaccion de la tecla "m"
color c1Random = color(random(255),random(255),random(255));      // Definicion de un color random: se activa con la interaccion de la tecla "m"

// Definición RGB para el lerp color
int cf1 = 237;
int cf2 = 82 ;
int cf3 = 118;
int ct1 = 70 ;
int ct2 = 179;
int ct3 = 157;

// VARIABLES GRADIENTES
color f1 = color(cf1,cf2, cf3);        // Inicio del lerp color
color t1 = color(ct1,ct2,ct3);         // Final del lerp color
color i1 = lerpColor(f1,t1,.15);       // un punto intermedio dentro de estos dos colores
color i2 = lerpColor(f1,t1,.30);       // un punto intermedio dentro de estos dos colores
color i3 = lerpColor(f1,t1,.45);       // un punto intermedio dentro de estos dos colores
color i4 = lerpColor(f1,t1,.60);       // un punto intermedio dentro de estos dos colores
color i5 = lerpColor(f1,t1,.75);       // un punto intermedio dentro de estos dos colores
color i6 = lerpColor(f1,t1,.85);       // un punto intermedio dentro de estos dos colores

float l = 0;                           // Para disminuir el movimiento en la interaccion con el mouse
float p;                               // Variable para cambiar de color (Palpitaciones)

// Variables de cambio permanente (Booleanas)
int k = 1;     // Variable permanente del Mouse
int j = 1;     // Variable permanente de la tecla b
int h = 1;     // Variable permanente de la tecla n
int g = 1;     // Variable permanente de la tecla m

void setup(){

  colores = new color[3];
  colores[0] = color(random(255),random(255),random(255));      // Primer color random de la lista
  colores[1] = color(random(255),random(255),random(255));      // Segundo color random de la lista
  colores[2] = color(random(255),random(255),random(255));      // Tercer color random de la lista
  a = new Vert1();         // Incializacion de clases
  size(800,800);           // Tamaño del sketch en pixeles
  background(255);         // Fondo global
}


void draw(){

  p = p + 10;              // Variable para hacer que el fondo cambie de color constantemente
  background(255);         // Fondo permamente
  a.lerpcc();              //Gradiente usando lerp: Cargar una funcion desde la clase

/////////////////////////////////////////////////// ELLIPSE CENTRAL ////////////////////////////////////////////////////

   noStroke();                                   // Sin Bordes
   fill(ef);                                     // Color de ellipse del centro
   ellipse(width/2, height/2, 300, 300);         // Ellipse del centro

////////////////////////////////////////////////////// ANILLO FONDO ////////////////////////////////////////////////////

   strokeWeight(30);
   noStroke();                                      // Sin bordes
   translate(width/2, height/2);                    // punto (0,0)/ ORIGEN en el centro del sketch
   for(int i = 0; i < 360; i+=1.5){                 // For que define: angulo máximo de rotación, cantidad de figuras y su separación
       float x = sin(radians(i))*150;               // variable de rotacion
       float y = cos(radians(i))*150;               // variable de rotacion
       pushMatrix();                                // Abriendo propiedades independientes
       translate(x, y);                             // Se traslada el origen, que al mismo tiempo esta en movimiento
       rotate(radians(-i+frameCount));              // proporciona movimiento al sketch/ cambia los ejes/ direccion de rotacion
       fill(sin(radians(p/2))*2*70, 179, 157);      // Se rellena la figura con el color original, pero es alterado en el canal R. (P.127) esto hara que palpite el anillo
       rect(0, 0, 120, 20, 25);                     // Se dibujan las figuras que se encuentran en el fondo
       popMatrix();                                 // Cerrando propiedades independientes
}

/////////////////////////////////////////////// INTERACCIÓN TECLA "M" /////////////////////////////////////////////////

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

//////////////////////////////////////////// INTERACCIONES TECLA "N"  ////////////////////////////////////////////////////

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
  stroke(ef);                               // Rellenar el borde de un color
  fill(50, 50, 100);                        // Se rellena la figura con un color azul
  rect(0, 0, 120, 5, 15);                   // Se crean las figuras que componen el petalo: Parte no sombreada
  popMatrix();                              // Cerrando propiedades independientes
}

////////////////////////////////////////// IINTERACCIÓN MOUSE ///////////////////////////////////////////////////////////////

if (k == 2){
  fill(#f0ca4d);                          // Se rellena con el color Amarillo
  noStroke();                             // Colocar color de paleta seleccionada
  ellipse(0,0,600,600);                   // Elipse de fondoque va a tapar el sketch
  for(int i = 0; i < 360; i+=10){         // Forloop que define: angulo máximo de rotación, cantidad de figuras y su separación
     rotate(radians(l));                  // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
     stroke(#de5b49);                     // Color de bordes
     fill(#3c989e);                       // Color relleno de ellipses pequeñas y rectangulos del borde
     rect(0,0,120,5,15);                  // Rectangulo central de la interacción
     rect(160,160,50,50);                 // Rectangulos perifericos
     noStroke();                          // Sin bordes
     ellipse(120,120,15,15);              // Elipses pequeñas que se forman en la interaccón
  }

  strokeWeight(60);               // Contorno figura interactiva
  stroke(#324d5c);                // Color contorno de la figura
  noFill();                       // Para que sea solo el contorno / Sin relleno
  ellipse(0,0, 600, 600);         // Se crea una elipse del mismo tamaño que el sketch anterior
  noStroke();                     // Sin bordes
  fill(#324d5c);                  // Color elipse central de la interacción
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
  l = l + 0.1;                    // Constante de movimiento: se le suma al float "l" 0.1 mientras preciono el mouse
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
    } else {
      c1_c = c1;
      ef_c = ef;
      j = 1;
    }
}

// BOTON RESSET
if (keyPressed) {                               // Interacción tecla
  if (key == 'r' || key == 'R') {               // Cuando apreto la tecla "R"
    background(255);                            // Se crea un fondo para "borrar" todo
    c1_c = c1;
    c1_v = c1;                                  // los colores que han sido cambiados vuelven a su valor original
    c2_c = c2;
    c2_v = c2;                                  // los colores que han sido cambiados vuelven a su valor original
    ef_c = ef;
    ef_v = ef;                                  // los colores que han sido cambiados vuelven a su valor original
    j = 1;
    k = 1;
    h = 1;                                      // Se desactiva la booleana j
    f1 = color(237,82,118);                     // El incio del lerp vuelve a su color original
    t1 = color(70,179,157);                     // El final del lert vuelve a su color original
    }
}
}
