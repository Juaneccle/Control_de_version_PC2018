// ¿Estilo Vapor Wave?
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
//boton 6
int jllimX  = 590;
int jllimY  = 620;
int jllimY2 = 720;
int jllimX2 = 650;


Table table;
Bubble[] bubbles;

boolean j, k, l, m, n;
boolean anual = true;      // incorporar booleanas durante la clase PARA NAVEGACION
boolean mensual;
boolean diario;

int temperaturaMin = -100;
int mSt,mEnd;

void setup() {
  size(1420, 900);
  cargarDatos();
//  divisiones();




}
void draw() {
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


 if (mouseX > limX && mouseY > limY && mouseX < limX2 && mouseY < limY2){
   mSt= 0;
   mEnd= 30;
 }
 if (mouseX > flimX && mouseY > flimY && mouseX < flimX2 && mouseY < flimY2){
   mSt= 31;
   mEnd= 59;
 }
 if (mouseX > mlimX && mouseY > mlimY && mouseX < mlimX2 && mouseY < mlimY2){
   mSt=60;
   mEnd=90;
 }

 if (mouseX > alimX && mouseY > alimY && mouseX < alimX2 && mouseY < alimY2){
   mSt=91;
   mEnd=120;
 }

 if (mouseX > malimX && mouseY > malimY && mouseX < malimX2 && mouseY < malimY2){
   mSt=121;
   mEnd=150;
 }

 if (mouseX > jlimX && mouseY > jlimY && mouseX < jlimX2 && mouseY < jlimY2){
   mSt=151;
   mEnd=180;
 }

 if (mouseX > jllimX && mouseY > jllimY && mouseX < jllimX2 && mouseY < jllimY2){
   mSt=181;
   mEnd=210;
 }
// BOTONES //

 // comprobaciones:
 fill(150,150,250, 50);
 rect(limX,limY,limX2,limY2);        // RARA esta wa
 rect(flimX,flimY,flimX2/2,flimY2/2);    // RARA esta wa
 rect(mlimX,mlimY,mlimX2/2,mlimY2/2);    // RARA esta wa
 rect(malimX,malimY,malimX2/2,malimY2/2);    // RARA esta wa
 rect(alimX,alimY,alimX2/2,alimY2/2);    // RARA esta wa
 rect(jlimX,jlimY,jlimX2/2,jlimY2/2);    // RARA esta wa
 rect(jllimX,jllimY,jllimX2/2,jllimY2/2);    // RARA esta wa

// boton enero o cualquier mes

if (mouseX > limX && mouseY > limY && mouseX < limX2 && mouseY < limY2){
    println("activado");
    triangle(width/2, height/2, -100, 460, -100, 75);

}
// boton febrero, o cualquier mes
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

void cargarDatos() {

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

void keyPressed(){
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
