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
float amt;
int cObjeto, c1,c2;

public void setup(){

noStroke();
//fill(50);

c1 = color(235,139,184);
c2 = color(199,229,219);
lista = new int[10];
for(int i = 0; i < 10; i ++){
float amt = map(i,0,0,1);
lista[i] = lerpColor(c1,c2,amt);
}
}

public void draw(){
background(255);
if (amt > 1){
  amt = 0;
}
amt += .01f;
fill(cObjeto);
//float amt = 0;
float amt = map(mouseX, 0, width, 0,1);
cObjeto = lerpColor(c1,c2, amt);  // amt = 0, se pone eo porque se puede animar
//translate(width/2, height/2);

desdex = lerp(desdex, hastax, .5f);  // entre mas lejano del 0 mas lento
desdey = lerp(desdey, hastay, .5f);

//ellipse(desdex, desdey, 10,10);
ellipse(mouseX, mouseY, 100,100);
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
