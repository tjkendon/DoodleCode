
int x = 0;
int y = 0;

void setup() {
  size(400, 400);
  
}

void draw() {
  background(255);
  fill(220, 140, 90);
  noStroke();
  circle(x++ % 400, y++ % 400, 10);
  
}
