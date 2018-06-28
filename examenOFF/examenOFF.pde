// ¿Estilo Vapor Wave?
// boton 1
int limX  = 300;
int limY  = 270;
int limY2 = 470;
int limX2 = 400;
// boton 2
int flimX  = 470;
int flimY  = 150;
int flimY2 = 400;
int flimX2 = 600;


Table table;
Bubble[] bubbles;

boolean j, k, l, m, n;
boolean anual = true;      // incorporar booleanas durante la clase PARA NAVEGACION
boolean mensual;
boolean diario;

int temperaturaMin = -100;


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
// BOTONES //

 // comprobaciones:
 //rect(limX,limY,limX2/2,limY2/2);        // RARA esta wa
 //rect(flimX,flimY,flimX2/2,flimY2/2);    // RARA esta wa

// boton enero o cualquier mes
fill(150,150,250, 50);
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
