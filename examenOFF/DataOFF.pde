
class Bubble {

  color [] colores;        // Lista Colores (Solucionar en clases)
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
     colores = new color [7];

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

  void display(){
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
  void rollover(float px, float py) {
    float d = dist(px, py, x, y);
    if (d < velocidadMAX/2) {
      over = true;
    } else {
      over = false;
    }
  }
  // Display the Bubble
  void circGeneral() {
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
    fill(colorTAI*1.3,150,150);               // Mapear los valores de color
    rect(0, 210, 2, altoAI);
    fill(ty2,0,0);
    ellipse(1.5,210+altoAI,6,6);
    ellipse(1.5,210+altoAE,6,6);

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

   void segNivel(){                // imprime los datos de un mes para poder compararloss
     float  tv = map (tempMaxima, 0, 32, 0, 85);

  if (i > 0 && i < 31){
    pushMatrix();
         translate(width/2, height/2);
         rotate(radians(i));
    fill(150,150,250);
    rect(0,180,2,-tv);
    popMatrix();
  if (i > 32 && i < 62){

    pushMatrix();
         fill(150,150,250);
         rect(0,180,2,-tv);
  popMatrix();
  }
}
}
 void menu(){
//   textAlign(CENTER);
//   text(valor, 50, y+powViento/2+20);
//   textSize(200);
//   fill(150);
//   println(valor);


}


void matrect(){

//for (int i = 0; i < bubbles.length; i++) {

pushMatrix();
    translate(width/2, height/2);
    rotate(radians(i));
    fill(0,0,0,25);
    rect(0,370,2,50);
    //rect(0,370,10,10);
popMatrix();

//}
}

void divisiones(int fillmes, int rot, int alphames){
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
