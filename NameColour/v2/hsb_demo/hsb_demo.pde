
int colour;

void setup() {
  size(400, 400);
  colorMode(HSB, 360, 100, 100);
}

void draw() {
 background(color(0, 0, 100));
 //fill(color(102, 16, 50));
 fill(color(102, 16, 50));
 rect (150, 150, 100, 100);
 colour++;
}
