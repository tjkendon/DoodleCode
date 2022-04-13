
void setup() {
  size(400, 400);
}

void draw() {
  println(mouseX + " " + mouseY);
  println(mouseX + " " + mouseY);
  float angle = atan((mouseX - 200.0) / (mouseY - 200.0));
  println(angle + " " + degrees(angle));
  
  
  line (200, 190, 200, 210);
  
}
