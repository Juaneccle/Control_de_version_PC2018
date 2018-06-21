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

Table table;
Bubble[] bubbles;

boolean a, b, c, j, k, l, m, n;      // incorporar booleanas durante la clase

public void setup() {
  
  cargarDatos();
}
public void draw() {
  translate(0,-200);
  background(255);
  // Display all bubbles
  for (int i = 0; i < bubbles.length; i++) {
  bubbles[i].circGeneral();
  }
}

public void cargarDatos() {
  table = loadTable("Data_miami_juan.csv", "header");
  bubbles = new Bubble[table.getRowCount()];
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

     bubbles[i] = new Bubble(dia, y, "h", powViento, i, e, d);
//String n = row.getString("maxVelViento");

}
}


/*
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
  float mes;               // MES
  float velocidadMIN;      // velocidad viento minima
  float velocidadPRO;      // velocidad viento minima
  float velocidadMAX;      // velocidad viento minima
  float powViento;         // Fuerza viento
  float grados;            // direccion del viento
  String valor;            // imprime el valor de cada dato
  int i;
  boolean over = false;
  // Create the Bubble
  Bubble(float tempX, float tempY,  String s, float tempH, int i, float graViento, float tempD) {
// VER EN CLASES EL TEMA DEL COLOR
     colores = new int [7];
       colores[0] = color(150, 74, 129); // Rosado.
       colores[1] = color(64, 54, 133); // Lila.
       colores[2] = color(12, 27, 72); // Azul, color de fondo.
       colores[3] = color(230, 183, 120); // Naranjo claro.
       colores[4] = color(205, 109, 98); // Naranjo.
       colores[5] = color(196, 64, 60); // Rojo.
       colores[6] = color(139, 32, 82); // Morado.


    x = tempX;
    y = tempY;
    d = tempD;
    valor = s;
    powViento = tempH;
    grados = graViento;
    this.i = i;
  }
  // Checking if mouse is over the bubble
  public void rollover(float px, float py) {
    float d = dist(px, py, x, y);
    if (d < velocidadMIN/2) {
      over = true;
    } else {
      over = false;
    }
  }
  // Display the Bubble
  public void circGeneral() {

    noStroke();
    strokeWeight(2);
    //noFill();
    fill(150,150,grados);
    float xo = map (i, 0, 364, 0, width);
    rect(xo,350, 3, powViento);
    fill(x,0,d);
    rect(xo, 340, 3, y* -1);
    if (over) {
      //fill(0);
      //textAlign(CENTER);
      //text(xo, 450, powViento);
}
}

   public void segNive3(){                // imprime los datos de una semana para poder compararlos
     noStroke();
     strokeWeight(2);
     //noFill();
     fill(150,150,grados);                  //
     float xEsp = map (i, 0, 7, 0, width);
     rect(width/2,height/2, powViento , powViento);
     fill(x,0,d);                           // colores mas fuertes
     rect(width/2, height/2, 3, y* -1);

   }
}



/*

class DataOFF {
  float x, y;
  float velocidad;
  String valor;
  boolean over = false;
  // Create the DataOFF
  DataOFF(float tempX, float tempY, float tempD, String s) {
    x = tempX;
    y = tempY;
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
  public void settings() {  size(1420, 300); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "examenOFF" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
