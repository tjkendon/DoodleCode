
PVector position;
PVector velocity;
PVector acceleration;

PVector mouse_urge;

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
  position.add(velocity);
  
  circle( position.x, position.y, size);
          
  
  
}
