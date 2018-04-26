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

public class testpolares extends PApplet {


// cada elemento tiene que tener su pocicion
float x, y;  // cordenadas cartesianas
float angle, r;  // coordenadas polares

public void setup(){

}

public void draw(){
background(255);
fill(0);
translate(width/2, height/2);
ellipse(x,y, 10,10);

x = r * cos(angle);
y = r * sin(angle);

ellipse(x,y,10,10);
stroke(0);

text(r,x,y - 10);
text("r: ",x,y - 10);
text(angle,x-50,y - 10);
text("angle: ",x-50,y - 10);
text("cos: "+ cos(angle), x -50, y -30);
}

public void keyPressed(){
  if (key == '+'){
r += 1;
  } else if(key == '-'){
r -= 1;

  }
}
  public void settings() { 
size(500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "testpolares" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
