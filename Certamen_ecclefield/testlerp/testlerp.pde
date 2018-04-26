///////////////////// ESTUDIAR ESTA PORQUERIA ///////////////////////////

float desdex, desdey, hastax, hastay;  // cordenadas cartesianas
float amt;
color cObjeto, c1,c2;
color [] lista;


void setup(){
size (500,500);
noStroke();
//fill(50);

c1 = color(235,139,184);
c2 = color(199,229,219);
lista = new color[10];
for(int i = 0; i < 10; i ++){
float amt = map(i,0,0,1);
lista[i] = lerpColor(c1,c2,amt);
}
}

void draw(){
background(255);
for (int i = 0; i < 10; i ++){
fill(cObjeto);
fill(lista[i]);
  ellipse(x + i *22, y + i*22,20,20);
}

if (amt > 1){
  amt = 0;
}
amt += .01;
fill(cObjeto);
//float amt = 0;
float amt = map(mouseX, 0, width, 0,1);
cObjeto = lerpColor(c1,c2, amt);  // amt = 0, se pone eo porque se puede animar
//translate(width/2, height/2);

desdex = lerp(desdex, hastax, .5);  // entre mas lejano del 0 mas lento
desdey = lerp(desdey, hastay, .5);

//ellipse(desdex, desdey, 10,10);
ellipse(mouseX, mouseY, 100,100);
}

void mousePressed(){

hastax = mouseX;
hastay = mouseY;
}
