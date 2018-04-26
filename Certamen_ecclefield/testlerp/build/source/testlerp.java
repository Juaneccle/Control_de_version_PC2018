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

public class testlerp extends PApplet {

float desdex, desdey, hastax, hastay;  // cordenadas cartesianas

public void setup(){

noStroke();
fill(50);
}

public void draw(){
background(255);
//translate(width/2, height/2);

desdex = lerp(desdex, hastax, .5f);  // entre mas lejano del 0 mas lento
desdey = lerp(desdey, hastay, .5f);

ellipse(desdex, desdey, 10,10);
}

public void mousePressed(){

hastax = mouseX;
hastay = mouseY;
}
  public void settings() { 
size (500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "testlerp" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
