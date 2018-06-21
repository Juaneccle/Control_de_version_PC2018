
class Bubble {

  color [] colores;        // Lista Colores (Solucionar en clases)
  float x, y, d;           // Temperatura
  float mes;               // MES
  float velocidadPRO;      // velocidad viento minima
  float velocidadMAX;      // velocidad viento minima
  float powViento;         // Fuerza viento
  float grados;            // direccion del viento
  String valor;            // imprime el valor de cada dato
  int i;
  boolean over = false;
  // Create the Bubble
  Bubble(float tempX, float tempY,  String s, float tempH, int i, float graViento, float tempD, float velP, float velM) {
// VER EN CLASES EL TEMA DEL COLOR
     colores = new color [7];
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
  void rollover(float px, float py) {
    float d = dist(px, py, x, y);
    if (d < velocidadMIN/2) {
      over = true;
    } else {
      over = false;
    }
  }
  // Display the Bubble
  void circGeneral() {

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

   void segNivel(){                // imprime los datos de una semana para poder compararlos
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
