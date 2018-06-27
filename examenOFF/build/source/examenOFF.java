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

Table table;
Bubble[] bubbles;
//PFont();
boolean j, k, l, m, n;
boolean anual;      // incorporar booleanas durante la clase PARA NAVEGACION
boolean mensual;
boolean diario;

int temperaturaMin = -100;

public void setup() {
  
  cargarDatos();
//  divisiones();




}
public void draw() {
  background(255);
  println(diario);

  // Display all bubbles
  for (int i = 0; i < bubbles.length; i++) {

//  bubbles[i].circGeneral();
//  bubbles[i].matrect();
  bubbles[i].display();


}
}

public void cargarDatos() {
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
     //String n = row.getString("maxVelViento");

}

// de temperatura maxima
println(temperaturaMax);
println(temperaturaMin);

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

    if (mensual) { //Figura 1 círculo

    }

    if (anual) { //Figura 1 círculo
          circGeneral();
          matrect();
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
      //fill(0);
      //textAlign(CENTER);
      //text(xo, 450, powViento);


    textAlign(CENTER);
    text(valor, 50, y+powViento/2+20);
    textSize(200);
    fill(150);
    println(valor);

}
popMatrix();
}

   public void segNivel(){                // imprime los datos de una semana para poder compararlos
     float posX_S;
     noStroke();
     strokeWeight(2);
     fill(150,150,grados);                      //
     float xEsp = map (i, 0, 7, 0, width);
     rect(width/2, height/2, powViento , powViento);
     fill(x,0,d);                               // colores mas fuertes
     rect(width/2, height/2, velocidadPRO, velocidadPRO);
     rect(width/2, height/2, velocidadMAX, velocidadMAX);
   }


 public void menu(){
//   textAlign(CENTER);
//   text(valor, 50, y+powViento/2+20);
//   textSize(200);
//   fill(150);
//   println(valor);


}


public void matrect(){
  for (int i = 0; i < bubbles.length; i++) {
pushMatrix();
    translate(width/2, height/2);
    rotate(radians(i));
    fill(200,200,200,25);
    rect(0,370,2,50);
popMatrix();
}


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
