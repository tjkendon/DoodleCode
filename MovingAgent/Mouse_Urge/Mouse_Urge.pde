
PVector position;
PVector velocity;
PVector acceleration;

float top_speed = 5;
float size = 66;

int field_height = 400;
int field_width = 400;

void setup() {
  size(400, 400);
  
  position = new PVector(field_height / 2, field_width / 2);
  velocity = new PVector(0, 0);
  acceleration = new PVector(0, 0);
  
}

void draw() {
  background(255);
  fill(220, 140, 90);
  noStroke();
  
  velocity.add(acceleration);
  velocity.limit(top_speed);
  position.add(velocity);
  
  circle( position.x, position.y, size);
          
  
    PVector mouse = new PVector(mouseX,mouseY);
    PVector mid = new PVector(200, 200);
     acceleration = PVector.sub(mouse,position);
     acceleration.add(PVector.sub(mid, position));
    // Set magnitude of acceleration
    acceleration.setMag(0.1);
  
}
