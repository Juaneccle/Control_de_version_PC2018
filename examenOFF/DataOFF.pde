
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
  void rollover(float px, float py) {
    float d = dist(px, py, x, y);
    if (d < diameter/2) {
      over = true;
    } else {
      over = false;
    }
  }
  // Display the Bubble
  void display() {

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
