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

//////////////////////////////////// SKETCH ////////////////////////////////////

             //OBJETIVOS: // HACER QUE CAMBIE DE COLOR CON ArrayList DE COLOR/
                          // HACER QUE LA VELOCIDAD CAMBIE CON KEYPRESSED
                          // INCORPORAR UNA INTERACCION CON EL MOUSE (¿GRADIENTES? ¿COS, SIN? ¿?)


// CODIGOS COLORES
//////// PALETA PRINCIPALES ////////
// 1.-

//(63,43,55);  //BURDEO OSCURO
//(84,0,50)    // BURDEO no tan OSCURO
//(130,3,51)   // MORADO
//(201,40,62)  // ROJO
//(240,67,58)  // NARANJO

// 2.-

// (#3c989e) (60, 152, 158)   // Celeste mas oscuro
// (#5db5a4) (93, 181, 164)   // CELESTE
// (#f4cda5) (244, 205, 165)  // beish
// (#f57a82) (245, 122, 130)  // rosado mas piola
// (#ed5276) (237,82, 118)    // ROSADO

// 3.-

//(#f0ca4d) (240, 202, 77)     // AMARILLO
//(#e37b40)                    // NARANJO
//(#46b39d)                    // CELESTE
//(#de5b49)                    // ROJISO
//(#324d5c) (50,77,92)         // GRIS AZULADO

// 4.-
//(38, 24, 34)   // burdeo muy oscuro
//(64, 21, 42)   // Morado oscuro
//(115, 22, 48)  // burdeo
//(204, 31, 45)  // Rojo
//(255, 82, 51)  // Naranjo

//CLASES
Vert1 a;

// COLOR
color original1 = color(#5db5a4);
color original2 = color(#f57a82);
color original3 = color(#ed5276);

// COLOR CONTORNOS
color c1   = color(50,77,92);         // Original
color c1_c = color(0);                // cambio otro color stroke pequeño
color c2   = color(240,67,58);        // Original
color c2_c = color(255);              // cambio otro color stroke grande
color ef   = color(240, 202, 77);     // color ellipse del fondo
color ef_c = color(240, 202, 77);     // color ellipse del fondo cambio
color f1_c = color(0);
color t1_c = color(0);

// Cuarta paleta de colores

color c1_v = color(64, 21, 42);     // Afecta lado sombreado cambio otro color stroke pequeño
color c2_v = color(0);              // cambio otro color stroke grande
color c3_v = color(244, 205, 165);
color ef_v = color(255, 82, 51);    //Afecta lado no sombreado color ellipse del fondo cambio
color f1_v = color(0);
color t1_v = color(0);

// SACA ESTO
int cf1 = 237;
int cf2 = 82 ;
int cf3 = 118;
int ct1 = 70 ;
int ct2 = 179;
int ct3 = 157;

// VARIABLES GRADIENTES
color f1 = color(cf1,cf2, cf3);       //(70,179,157);    // (63,43,55);
color t1 = color(ct1,ct2,ct3);         // 222,91,73           // (240,67,58);
color i1 = lerpColor(f1,t1,.15);
color i2 = lerpColor(f1,t1,.30);
color i3 = lerpColor(f1,t1,.45);
color i4 = lerpColor(f1,t1,.60);
color i5 = lerpColor(f1,t1,.75);
color i6 = lerpColor(f1,t1,.85);
//color i7 = lerpColor(f1,t1,.20);
//color i8 = lerpColor(f1,t1,.20);

// Variables de movimientos
float l = 0;
//Variables para el fondo
int telx = 20;
int tely = 20;

// Variable cambios de color
float p;    // Palpitaciones
float cg;   // color gradient
float f;
float d;

// Variables cambio de sketch
int k = 1;
int j = 1;
int h = 1;

void setup(){

// Incializacion de clases
a = new Vert1();

background(255);
size(800,800);
}

             void draw(){
             // COMPROBACIONES
             background(255);
//             println(p);

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

///////////////////////// FOONDO INTERACTIVO ////////////////////////////////
//println(telx, tely);
noFill();
strokeWeight(165);
stroke(t1);
ellipse(height/2, width/2, 455,455);

strokeWeight(15);
stroke(i6);
ellipse(height/2, width/2, 475,475);

strokeWeight(15);
stroke(i5);
ellipse(height/2, width/2, 495,495);

strokeWeight(15);
stroke(i4);
ellipse(height/2, width/2, 515,515);

strokeWeight(15);
stroke(i3);
ellipse(height/2, width/2, 535,535);

strokeWeight(15);
stroke(i2);
ellipse(height/2, width/2, 555,555);

strokeWeight(15);
stroke(i1);
ellipse(height/2, width/2, 575,575);

strokeWeight(40);
stroke(f1);
ellipse(height/2, width/2, 620,620);


////////////////////////// ELLIPSE CENTRAL /////////////////////////////////

             //fill(255,200,80);
             //strokeWeight(20);
             // stroke(250,150,60);
             noStroke();
             fill(ef);                                   // Color de ellipse del centro
             ellipse(width/2, height/2, 300, 300);             // Ellipse del centro



/////////////////////////// ANILLO FONDO //////////////////////////////////

             strokeWeight(30);
             noStroke();                           // sin bordes, IMPORTANTE
               translate(width/2, height/2);       // punto (0,0)/ ORIGEN en el centro del sketch
               for(int i = 0; i < 360; i+=1.5){      // i = angulo de rotacion 0-360/ Separacion entre lineas
                   float x = sin(radians(i))*150;  // variable de rotacion
                   float y = cos(radians(i))*150;  // variable de rotacion
                   pushMatrix();
                   translate(x, y);
                   rotate(radians(-i+frameCount));    // proporciona movimiento al sketch/ cambia los ejes/ direccion de rotacion

 // COLOR
 //222,91,73
 //70,179,157);
 // 70,179,157
                 fill(sin(radians(p/2))*2*70, 179, 157);                        // esto hara que palpite el anillo
                 //fill(sin(radians(i/2))*255, 50, sin(radians(i*3))*100);     // fill con gradiente R0-R255, b0-b255
                 //fill(sin(radians(i/2))*cg, 200, 150);                       // prueba gradientes cambiantes

                   rect(0, 0, 120, 20, 25);
                   popMatrix();
}

if (keyPressed) {
      if (key == 'n' || key == 'N') {
      //f1 = color (0);
      //t1 = color(0);
      c1 = c1_v;
      c2 = c2_v;
      ef = ef_v;
      h = 2;

 }
 }
 if (h == 2){
   fill(c3_v);
   ellipse(0,0,1500,1500);

 for(int i = 0; i < 360; i+=20){
  float x = sin(radians(i))*150;
  float y = cos(radians(i))*150;
  pushMatrix();
    translate(x, y);
    rotate(radians(-i-frameCount+90));   // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
    noStroke();                     // COLOR ANILLO DE PETALOS
  // COLOR
  //fill(sin(radians(i/2))*255, 50, 100);
    fill(115, 22, 48);
    rect(0, 50, 120, 20, 25);
  popMatrix();
     }
 stroke(c1_v);
 strokeWeight(50);
 noFill();
 ellipse(0,0,600,600);
 }

/////////////////////////// ANILLO EXTERIOR //////////////////////////////////
strokeWeight(30);
             for(int i = 0; i < 360; i+=12){
                   float x = sin(radians(i))*150;
                   float y = cos(radians(i))*150;
                   pushMatrix();
                   translate(x, y);
                   rotate(radians(-i+frameCount+90));   // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
                   stroke(c1);                     // COLOR ANILLO DE PETALOS
// COLOR
                   fill(sin(radians(i/2))*255, 50, 100);
                   rect(0, 0, 120, 20, 25);
                   popMatrix();
               }

////////////////////////// ANILLO EXTERIOR 2 /////////////////////////////////

               for(int i = 0; i < 360; i+=12){
                     float x = sin(radians(i))*150;  // suma al origen
                     float y = cos(radians(i))*150;  // suma al origen // intenta sacarle a la multiplicacion
                     pushMatrix();
                     translate(x, y); // hace que no partan desde el punto (0,0)
                     rotate(radians(-i+frameCount+90));   // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
                     stroke(ef);                     // sin bordes
// COLOR
                     fill(50, 50, 100);
                     rect(0, 0, 120, 5, 15);
                     popMatrix();
                 }

if (k == 2){
  fill(#f0ca4d);
  noStroke();                    // Colocar color de paleta seleccionada
  ellipse(0, 0, 600, 600);                // Elipse de fondoque va a tapar el sketch
  for(int i = 0; i < 360; i+=10){
    float x = sin(radians(i))*150;  // suma al origen
    float y = cos(radians(i))*150;  // suma al origen // intenta sacarle a la multiplicacion
    rotate(radians(l));             // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
    stroke(#de5b49);                     // sin bordes
  // COLOR
    fill(#3c989e);
    rect(0, 0, 120, 5, 15);
    rect(160,160, 50,50);
    noStroke();
    ellipse(120,120,15,15);

    }

strokeWeight(60);
stroke(#324d5c);
noFill();
ellipse(0,0, 600, 600);

noStroke();
fill(#324d5c);
ellipse(0,0,120,120);
}

if (j == 2){
  strokeWeight(40);
  stroke(255);
  noFill();
  ellipse(0,0, 560,560);
}

///////////////////////////// Interaccion ///////////////////////////////

if (mousePressed) {
k = 2;
j = 1;
l = l + 0.1;
   } else {
k = 1;

   }

if (keyPressed) {
      if (key == 'b' || key == 'B') {
        j = 2;
        c1 = c1_c;
        ef = c2_c;

      f1 = color (0);
      t1 = color(0);

      }
  }


// CAMBIO DE COLOR

// BOTON RESSET
if (keyPressed) {
      if (key == 'r' || key == 'R') {
        background(255);
        c1_c = c1;
        c2_c = c2;
        ef_c = ef;
        j = 1;
        f1 = color(237,82,118);
        t1 = color(70,179,157);
 }
 }
}

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
