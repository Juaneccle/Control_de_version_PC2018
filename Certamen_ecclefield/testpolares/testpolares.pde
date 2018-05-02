
// cada elemento tiene que tener su pocicion
float x, y;  // cordenadas cartesianas
float angle, r;  // coordenadas polares

void setup(){
size(500,500);
}

void draw(){
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
text("cos: "+  cos(angle), x -50, y -30);
}

void keyPressed(){
  if (key == '+'){
r += 1;
  } else if(key == '-'){
r -= 1;

  }
}
