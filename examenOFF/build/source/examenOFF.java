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
public void setup() {
  
  loadData();
}
public void draw() {
translate(0,-200);
  background(255);
  // Display all bubbles
  for (int i = 0; i < bubbles.length; i++) {
    bubbles[i].display();
  }
}
public void loadData() {
  table = loadTable("Data_miami_juan.csv", "header");
  bubbles = new Bubble[table.getRowCount()];
  for (int i = 0; i < table.getRowCount(); i++) {
  TableRow row = table.getRow(i);
  println(i);

float humedad = row.getFloat("maxVelViento");
float dia = row.getFloat("D");
float x = row.getFloat("maxTemp");
float y = row.getFloat("proTemp");
float d = row.getFloat("minTemp");
//String n = row.getString("maxVelViento");

bubbles[i] = new Bubble(dia, y, dia, "h", humedad, i);
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
  float x, y;            // Temperatura
  float diameter;        // velocidad viento
  float humedad;         // Fuerza viento
  String name;
  int i;
  boolean over = false;
  // Create the Bubble
  Bubble(float tempX, float tempY, float tempD, String s, float tempH, int i) {
    x = tempX;
    y = tempY;
    diameter = tempD;
    name = s;
    humedad = tempH;
    this.i = i;
  }
  // Checking if mouse is over the bubble
  public void rollover(float px, float py) {
    float d = dist(px, py, x, y);
    if (d < diameter/2) {
      over = true;
    } else {
      over = false;
    }
  }
  // Display the Bubble
  public void display() {

    //x = tempX;
  //  y = tempY;

    float lx,ly;
    noStroke();
    strokeWeight(2);
    //noFill();
    fill(humedad,humedad,humedad,25);
    float xo = map (i, 0, 364, 0, width);
    ellipse(xo,450, humedad, humedad);
    if (over) {
      //fill(0);
      textAlign(CENTER);

      text(name, x, y+diameter/2+20);
}
}
}



/*

class DataOFF {
  float x, y;
  float diameter;
  String name;
  boolean over = false;
  // Create the DataOFF
  DataOFF(float tempX, float tempY, float tempD, String s) {
    x = tempX;
    y = tempY;
    diameter = tempD;
    name = s;
  }
  // Checking if mouse is over the DataOFF
  void rollover(float px, float py) {
    float d = dist(px, py, x, y);
    if (d < diameter/2) {
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
    ellipse(x, y, diameter, diameter);
    if (over) {
      fill(0);
      textAlign(CENTER);
      text(name, x, y+diameter/2+20);
    }
  }
}


*/
  public void settings() {  size(900, 900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "examenOFF" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
