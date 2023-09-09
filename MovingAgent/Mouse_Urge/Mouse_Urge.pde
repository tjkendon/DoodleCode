
PVector position;
PVector velocity;
PVector acceleration;

    //PVector mouse = new PVector(mouseX,mouseY);
    //PVector mid = new PVector(400, 400);


Boid boid = new Boid();

int field_height = 800;
int field_width = 800;

ArrayList<PVector> positions;

void setup() {
  size(800, 800);
  
  
}

void draw() {
  background(255);
  fill(boid.getColour());
  noStroke();
    
  circle( boid.getPosition().x, boid.getPosition().x, boid.getSize());
          
  

  
}
