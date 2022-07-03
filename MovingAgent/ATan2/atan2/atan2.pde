PFont f;


void setup() {
  
 size(600, 600);
  f = createFont("Arial",20,true); 
  textFont(f, 20);
}

void draw() {
  
  background(255);
  translate(width/2, height/2);
  int rMouseX = mouseX - (width/2);
  int rMouseY = mouseY - (height/2);
  float a = atan2(rMouseY, rMouseX); 
  int y = int(100 * sin(a));
  int x = int(100 * cos(a));
  fill(0);
  text (frameCount + " " 
    + rMouseX + " " 
    + rMouseY + " "
    + a + " "
    + degrees(a) + " " 
    + x + " " 
    + y,
    -280, 
    -280);
  stroke(255,0,0);
  line (0, 0, rMouseX, rMouseY);
  stroke(0,0,255);
  line (0, 0, x, y);
  stroke(0);
  line (0, 0, 300, 0);
  
}
