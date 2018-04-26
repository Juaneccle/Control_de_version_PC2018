float desdex, desdey, hastax, hastay;  // cordenadas cartesianas

void setup(){
size (500,500);
noStroke();
fill(50);
}

void draw(){
background(255);
//translate(width/2, height/2);

desdex = lerp(desdex, hastax, .5);  // entre mas lejano del 0 mas lento
desdey = lerp(desdey, hastay, .5);

ellipse(desdex, desdey, 10,10);
}

void mousePressed(){

hastax = mouseX;
hastay = mouseY;
}
