
class Vert1{
  //float x;
  //float y;

  //Editor de color
  int r = 255  ;
  int g = 103 ;
  int b = 63 ;
Vert1(){

  //this.x   = x  ;
  //this.y   = y  ;
}


void fondo(){
fill(0);
noStroke();                    // Colocar color de paleta seleccionada
ellipse(0, 0, 600, 600);                // Elipse de fondoque va a tapar el sketch
for(int i = 0; i < 360; i+=10){
      float x = sin(radians(i))*150;  // suma al origen
      float y = cos(radians(i))*150;  // suma al origen // intenta sacarle a la multiplicacion
      //pushMatrix();
      //translate(x, y); // hace que no partan desde el punto (0,0)
      rotate(radians(-i+frameCount+90));   // proporciona el movimiento al sketch / cambia los ejes / direccion de rotacion
      stroke(55);                     // sin bordes
// COLOR
      fill(50, 50, 100);
      rect(0, 0, 120, 5, 15);
      //popMatrix();
  }
}

}


/*
void bubls(){
  //fill(50,80,100);
  translate(width/2, height/2);
  rotate(radians(p));
  rect(-26, -26, 52, 52);


}

}
*/
