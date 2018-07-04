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

public class examenOFF extends PApplet {

// ¿Estilo Vapor Wave?
// Buscar referentes de "Color, diagramacion y movimiento" un archvo que tenga todos los referentes. como funciones

// boton 1
int limX  = 690;
int limY  = 100;
int limY2 = 200;
int limX2 = 820;
// boton 2
int flimX  = 770;
int flimY  = 150;
int flimY2 = 400;
int flimX2 = 870;
// boton 3
int mlimX  = 800;
int mlimY  = 250;
int mlimY2 = 350;
int mlimX2 = 990;
// boton 4
int alimX  = 800;
int alimY  = 450;
int alimY2 = 550;
int alimX2 = 990;
//boton 5
int malimX  = 720;
int malimY  = 550;
int malimY2 = 650;
int malimX2 = 890;
//boton 6
int jlimX  = 690;
int jlimY  = 590;
int jlimY2 = 750;
int jlimX2 = 820;
//boton 7
int jllimX  = 590;
int jllimY  = 620;
int jllimY2 = 720;
int jllimX2 = 650;
//boton 8
int aglimX  = 490;
int aglimY  = 560;
int aglimY2 = 660;
int aglimX2 = 550;
//boton 9
int slimX  = 420;
int slimY  = 510;
int slimY2 = 610;
int slimX2 = 500;
//boton 10
int olimX  = 420;
int olimY  = 410;
int olimY2 = 510;
int olimX2 = 500;
//boton 11
int nlimX  = 500;
int nlimY  = 310;
int nlimY2 = 410;
int nlimX2 = 600;
//boton 11
int dlimX  = 600;
int dlimY  = 210;
int dlimY2 = 310;
int dlimX2 = 700;

Table table;
Bubble[] bubbles;

boolean j, k, l, m, n;
boolean anual = true;      // incorporar booleanas durante la clase PARA NAVEGACION
boolean mensual;
boolean diario;

int temperaturaMin = -100;
int mSt,mEnd;

public void setup() {
    // 1280, 720
  cargarDatos();
//  divisiones();

}
public void draw() {
//  println(diario);
  background(255);
  println(mouseX);
  println(mouseY);


  for (int i = 0; i < bubbles.length; i++) {
 bubbles[i].display();
}

for (int i = mSt; i <mEnd; i++) {
bubbles[i].mes();
}


 if (mouseX > limX && mouseY > limY && mouseX < limX2 && mouseY < limY2)           {mSt = 0;    mEnd = 30;}
 if (mouseX > flimX && mouseY > flimY && mouseX < flimX2 && mouseY < flimY2)       {mSt = 31;   mEnd = 59;}
 if (mouseX > mlimX && mouseY > mlimY && mouseX < mlimX2 && mouseY < mlimY2)       {mSt = 60;   mEnd = 90;}
 if (mouseX > alimX && mouseY > alimY && mouseX < alimX2 && mouseY < alimY2)       {mSt = 91;   mEnd = 120;}
 if (mouseX > malimX && mouseY > malimY && mouseX < malimX2 && mouseY < malimY2)   {mSt = 121;  mEnd = 150;}
 if (mouseX > jlimX && mouseY > jlimY && mouseX < jlimX2 && mouseY < jlimY2)       {mSt = 151;  mEnd = 180;}
 if (mouseX > jllimX && mouseY > jllimY && mouseX < jllimX2 && mouseY < jllimY2)   {mSt = 181;  mEnd = 210;}
 if (mouseX > aglimX && mouseY > aglimY && mouseX < aglimX2 && mouseY < aglimY2)   {mSt = 211;  mEnd = 240;}
 if (mouseX > aglimX && mouseY > aglimY && mouseX < aglimX2 && mouseY < aglimY2)   {mSt = 211;  mEnd = 240;}
 if (mouseX > slimX && mouseY > slimY && mouseX < slimX2 && mouseY < slimY2)       {mSt = 241;  mEnd = 270;}
 if (mouseX > olimX && mouseY > olimY && mouseX < olimX2 && mouseY < olimY2)       {mSt = 271;  mEnd = 300;}
 if (mouseX > nlimX && mouseY > nlimY && mouseX < nlimX2 && mouseY < nlimY2)       {mSt = 301;  mEnd = 330;}
 if (mouseX > dlimX && mouseY > dlimY && mouseX < dlimX2 && mouseY < dlimY2)       {mSt = 331;  mEnd = 360;}


// BOTONES //

 // comprobaciones:
 fill(150,150,250, 50);
 // rect(limX,limY,limX2,limY2);                // RARA esta wa
 // rect(flimX,flimY,flimX2/2,flimY2/2);        // RARA esta wa
 // rect(mlimX,mlimY,mlimX2/2,mlimY2/2);        // RARA esta wa
 // rect(malimX,malimY,malimX2/2,malimY2/2);    // RARA esta wa
 // rect(alimX,alimY,alimX2/2,alimY2/2);        // RARA esta wa
 // rect(jlimX,jlimY,jlimX2/2,jlimY2/2);        // RARA esta wa
 // rect(jllimX,jllimY,jllimX2/2,jllimY2/2);    // RARA esta wa
 // rect(aglimX,aglimY,aglimX2/2,aglimY2/2);    // RARA esta wa
 // rect(slimX,slimY,slimX2/2,slimY2/2);        // RARA esta wa
 // rect(olimX,olimY,olimX2/2,olimY2/2);        // RARA esta wa
 // rect(nlimX,nlimY,nlimX2/2,nlimY2/2);        // RARA esta wa
 // rect(dlimX,dlimY,dlimX2/2,dlimY2/2);        // RARA esta wa

// boton enero o cualquier mes

// triangulo enero
if (mouseX > limX && mouseY > limY && mouseX < limX2 && mouseY < limY2){
  triangle(width/2, height/2, -100, 460, -100, 75);
}

// triangulo febrero
if (mouseX > flimX && mouseY > flimY && mouseX < flimX2 && mouseY < flimY2){
  triangle(width/2, height/2, -100, 460, -100, 75);
}

// triangulo marzo
if (mouseX > mlimX && mouseY > mlimY && mouseX < mlimX2 && mouseY < mlimY2){
  triangle(width/2, height/2, -100, 75, 200, -150);
    }

// triangulo abril
if (mouseX > alimX && mouseY > alimY && mouseX < alimX2 && mouseY < alimY2){
  triangle(width/2, height/2, -100, 75, 200, -150);
                }

// triangulo enero
if (mouseX > mlimX && mouseY > mlimY && mouseX < mlimX2 && mouseY < mlimY2){
  triangle(width/2, height/2, -100, 75, 200, -150);
        }

// triangulo enero
if (mouseX > flimX && mouseY > flimY && mouseX < flimX2 && mouseY < flimY2){
  println("activado");
  triangle(width/2, height/2, -100, 75, 200, -150);
                }

// triangulo enero
if (mouseX > flimX && mouseY > flimY && mouseX < flimX2 && mouseY < flimY2){
  println("activado");
  triangle(width/2, height/2, -100, 75, 200, -150);
                    }

// triangulo enero
if (mouseX > flimX && mouseY > flimY && mouseX < flimX2 && mouseY < flimY2){
  println("activado");
  triangle(width/2, height/2, -100, 75, 200, -150);
                        }

if(mensual == true){
//for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].segNivel(255);
//for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].segNivel(224);

  for (int i = 0; i < 31; i+=5) {

}
}
// DIVISION MESES
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(255, 30, 10);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(224, 60, 20);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(203, 90, 30);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(182, 120, 40);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(140, 180, 60);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(161, 150, 50);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(119, 210, 70);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(98, 240, 80);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(77, 270, 90);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(56, 300, 100);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(35, 330, 110);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(14, 360, 120);
for(int i = 0; i < bubbles.length/12; i++)   bubbles[i].divisiones(0, 390, 130);

}

public void cargarDatos() {

  //rect(limX,limY,limX2,limY2);

  table = loadTable("Data_miami_juan.csv", "header");
  bubbles = new Bubble[table.getRowCount()];

  float temperaturaMax =0;
  float temperaturaMin =0;

  for (int i = 0; i < table.getRowCount(); i++) {

     TableRow row = table.getRow(i);
     float dia = row.getFloat("D");
     float powViento = row.getFloat("fuerzaViento");
     float maxVel = row.getFloat("maxVelViento");
     float promVel = row.getFloat("mediaVelViento");
     float x = row.getFloat("maxTemp");
     float y = row.getFloat("proTemp");
     float d = row.getFloat("minTemp");
     float e = row.getFloat("WindDirDegrees");
     String h = row.getString("D");

     bubbles[i] = new Bubble(dia, y, h, powViento, i, e, d, promVel, maxVel, diario, mensual, anual);
     row.setString("D", "hola");


     if(x> temperaturaMax){
     temperaturaMax = x;
     }
     if(x> temperaturaMin){
     temperaturaMin = d;
     }
}
}

public void keyPressed(){
    if (key == '1') { //aparecen elipses
      anual = !anual;
    }
    if (key == '2') { //aparecen rectangulos
      mensual = !mensual;
    }
    if (key == '3') { //aparecen cuadrados
      diario = !diario;
  }

}


// de temperatura maxima
//println(temperaturaMax);
//println(temperaturaMin);

//rect(limX,limY,limX2,limY2);

// Creacion de botones

/*


- NO se pueden hacer maps con "int"
///////////////////////////////////////////////////////////////////
s = second();       // frame count de segundo del compu
sp = s;             //

if(s != sp);
se suma un dia      //
time++;             // La variable que va a ir cambiando cada segundo
sp = s;             // es como el estado antiguo

//////////////////////////////////////////////////////////////////

DataOFF [] dataOFF;


void setup(){
size(1600, 400);
background(0);
//String s = "64,100,32,7,87,22";

}

void draw(){
background(0);

//Table table = loadTable("baseDatos.csv");
//Table table = loadTable("data6meses.csv", "header");

//TableRow row = table.getRow(2);

for(int i = 0; i < dataOFF.length;  i++){
 dataOFF [i].display();
 dataOFF [i].rollover(mouseX, mouseY);

//float f1 = row.getInt(0);    //
//float f2 = row.getInt(1);    //
//float f3 = row.getInt(2);    //
//float maxT = row.getInt("Max TemperatureC");    // temperatura maxima
//float meanT = row.getInt("Mean TemperatureC");
//float minT = row.getInt("Min TemperatureC");
//float dewP = row.getInt("Dew PointC");

}

textAlign(LEFT);
fill(0);
text("Click to add dataOFF.", 10, height-10);
}

void loadData (){

Table table = loadTable("data6meses.csv", "header");
dataOFF = new DataOFF[table.getRowCount()];

for(int i = 1; i < table.getRowCount(); i++){
  TableRow row = table.getrow(i);

  float f1 = row.getInt(0);    //
  //float f2 = row.getInt(1);    //
  //float f3 = row.getInt(2);    //
  float maxT = row.getInt("Max TemperatureC");    // temperatura maxima
  float meanT = row.getInt("Mean TemperatureC");
  float minT = row.getInt("Min TemperatureC");
  float dewP = row.getInt("Dew PointC");

  dataOFF[i] = new DataOFF (maxT, meanT, minT, dewP);


}
}

  void mousePressed() {
  TableRow row = table.addRow();
  row.setFloat("maxT", mouseX);
  row.setFloat("meanT", mouseY);
  row.setFloat("minT", random(40, 80));
  row.setString("dewP", "Blah");
  if (table.getRowCount() > 10) {
    table.removeRow(0);
  }
  saveTable(table, "data/data.csv");
  loadData();
}


/*
float w = row.getInt(7);
float h = row.getInt(8);
float x = row.getInt(9);
float y = row.getInt(10);
float w = row.getInt(11);
float h = row.getInt(12);
float x = row.getInt(13);
float y = row.getInt(14);
float w = row.getInt(15);
float h = row.getInt(16);
float x = row.getInt(17);
float y = row.getInt(18);
float w = row.getInt(19);
float h = row.getInt(20);
float x = row.getInt(21);
float y = row.getInt(22);


fill(255,255,f3);
rect(maxT,meanT,minT,dewP);

println(maxT);
println(" ");
println(meanT);
println(" ");
println(minT);
println(" ");
println(dewP);

*/

class Bubble {

  int [] colores;        // Lista Colores (Solucionar en clases)
  float x, y, d;           // Temperatura
  float tempMinima;
  float tempMaxima;
  float mes;               // MES
  float velocidadPRO;      // velocidad viento minima
  float velocidadMAX;      // velocidad viento minima
  float powViento;         // Fuerza viento
  float grados;            // direccion del viento
  String valor;            // imprime el valor de cada dato
  int i;
  boolean over = false;

 int fillmaes;
 int rot;
 int alphames;
 int segrot;

  // Create the Bubble
  Bubble(float diasAno, float tempMaxima,  String s, float fuerzaV, int i, float graViento, float tempMinima, float velP, float velM, Boolean diario, Boolean mensual, Boolean anual) {
  // VER EN CLASES EL TEMA DEL COLOR
     colores = new int [7];

     // this.maxima = map(0,30,0,250); // mapeo para expandir el rango de cada variable "exagerar la distancia entre valores"
     // this.temp = this.maxima;      // los datos tienen que ser los mismos, esto se puede usar para cualquier cosa en la clase,
     // para lo unico que se usa es para ordenar el sketch y tener mayor control, al igual que un (PinMode)

       colores[0] = color(150, 74, 129); // Rosado.
       colores[1] = color(64, 54, 133); // Lila.
       colores[2] = color(12, 27, 72); // Azul, color de fondo.
       colores[3] = color(230, 183, 120); // Naranjo claro.
       colores[4] = color(205, 109, 98); // Naranjo.
       colores[5] = color(196, 64, 60); // Rojo.
       colores[6] = color(139, 32, 82); // Morado.


    x = diasAno;
    //y = tempMaxima;
  //  d = tempD;
    valor = s;                // String h, valor del dia
    //this.powViento = fuerzaV;
    //this.fuerzaV = this.powViento;
    //this.powViento =  map(0,30,0,250);
    //this.fuerzaV = this.powViento;
    //this.powViento =  map(0,30,0,250);

    grados = graViento;
    this.i = i;
    this.powViento = fuerzaV;       //
    this.velocidadPRO = velP;       // velocidad viento minima
    this.velocidadMAX = velM;       // velocidad viento minima
    this.tempMaxima = tempMaxima;
    this.tempMinima = tempMinima;
    //this.d = tempD;
  }

  public void display(){
    if (diario) { //Figura 1 círculo
     background(255);
     noStroke();
     fill(255, 50, 0);
     ellipse(100,100,100,100);
    }

    if (mensual) { //Figura 1 círculo    DEBERIA SER PRO FRACCION (Resolver en clases)
       segNivel();
    }

    if (anual) { //Figura 1 círculo
       circGeneral();
       matrect();
          //divisiones();
    }

  }

  // Checking if mouse is over the bubble
  public void rollover(float px, float py) {
    float d = dist(px, py, x, y);
    if (d < velocidadMAX/2) {
      over = true;
    } else {
      over = false;
    }
  }
  // Display the Bubble
  public void circGeneral() {
    pushMatrix();
    translate(width/2, height/2);
    rotate(radians(i));
    noStroke();
    strokeWeight(2);
    //noFill();

//  float xo  = map (i, 0, 364, 0, 200);
    float ty         = map (powViento, 0, 36, 0, -65);       // Mapeo
    float ty2        = map (velocidadPRO, 0, 30, 0, 165);
    float altoAE     = map (tempMaxima, 0, 36, 0, 120);       // Mapeo temperatura MINIMA/ Colocar los valores reales
    float colorTAE   = map (tempMaxima, 20, 32, 0, 255);       // Mapeo temperatura maxima
    float altoAI     = map (tempMinima, 0, 36, 0, 85);       // Mapeo temperatura MINIMA/ Colocar los valores reales
    float colorTAI   = map (tempMinima, 17, 29, 0, 255);       // Mapeo temperatura maxima

  //  float ty2 = map (velocidadPRO, 0, 30, 0, 165);

    fill(colorTAE,50, 50);
    rect(0,210, 2,altoAE);
    fill(colorTAI*1.3f,150,150);               // Mapear los valores de color
    rect(0, 210, 2, altoAI);
    fill(ty2,0,0);
    ellipse(1.5f,210+altoAI,6,6);
    ellipse(1.5f,210+altoAE,6,6);

    // ellipse(i,ty,10,10);                       // esta esta filete ql: hace
    // ellipse(10,ty,10,10);                      // esta esta filete ql
    //
    //  println(colorT);
    if (over) {
    textAlign(CENTER);
    text(valor, 50, y+powViento/2+20);
    textSize(200);
    fill(150);
    println(valor);
}
popMatrix();
}
   public void segNivel(){                // imprime los datos de un mes para poder compararloss
   float  tv = map (tempMaxima, 0, 32, 0, 85);
}

public void mes(){
    float  tv = map (tempMaxima, 0, 32, 0, 85);  // cambiar con control f
    pushMatrix();
    translate(width/2, height/2);
    rotate(radians(i+180));
    fill(150,150,250);
    rect(0,180,2,-tv);
    popMatrix();

}

 public void menu(){
//   textAlign(CENTER);
//   text(valor, 50, y+powViento/2+20);
//   textSize(200);
//   fill(150);
//   println(valor);


}


public void matrect(){

//for (int i = 0; i < bubbles.length; i++) {

pushMatrix();
    translate(width/2, height/2);
    rotate(radians(i));
    fill(0,0,0,25);
    //rect(0,370,2,50);
    //rect(0,370,10,10);
popMatrix();

//}
}

public void divisiones(int fillmes, int rot, int alphames){
  pushMatrix();

  translate(width/2, height/2);
  rotate(radians(i+rot));
  fill(fillmes,150,150, alphames);
  rect(0,370,10,10);
  popMatrix();

}
}


// REVISAR EL CERTAMEN DE LA GABY //
//color cTemperatura(float tem){         // esta es una funcion
//float amt = map (tem, 0,40,0,1);       // se mapea la temperatura que entra
//color c = lerpColor(cMin, cMax, amt);  // TODAS LAS variables que se usan son variables de color
//return c;   // devuelve un color que esta entre ese rango
//}           // depende del numero de temperatura que entre como va a cambiar el color, son numeros distintos


/*

class DataOFF {
  float x, y;
  float velocidad;
  String valor;
  boolean over = false;
  // Create the DataOFF
  DataOFF(float diasAno, float tempMaxima, float tempD, String s) {
    x = diasAno;
    y = tempMaxima;
    velocidad = tempD;
    valor = s;
  }
  // Checking if mouse is over the DataOFF
  void rollover(float px, float py) {
    float d = dist(px, py, x, y);
    if (d < velocidad/2) {
      over = true;
    } else {
      over = false;
    }
  }
  // Display the DataOFF
  void display() {
    stroke(0);
    strokeWeight(2);
    noFill();
    ellipse(x, y, velocidad, velocidad);
    if (over) {
      fill(0);
      textAlign(CENTER);
      text(valor, x, y+velocidad/2+20);
    }
  }
}


*/
  public void settings() {  size(1420, 900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "examenOFF" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
