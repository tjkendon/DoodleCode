
PVector position;
PVector velocity;
PVector acceleration;

int boid_count = 5;
ArrayList<Boid> boids = new ArrayList();

int field_height = 800;
int field_width = 800;

ArrayList<PVector> positions;

void setup() {
  size(800, 800);
  
  boids.add(new Boid(300, 300, color(255, 0, 0)));
  boids.add(new Boid(600, 600, color(0, 255, 0)));
  
}

void draw() {
  background(255);
  
  noStroke();
  
  for (Boid b: boids) {
    fill(b.getColour());  
    circle( b.getPosition().x, b.getPosition().y, b.getSize());
  
    ArrayList factors = new ArrayList();
    factors.add(new PVector(mouseX, mouseY));
    factors.add(new PVector(400,400));
  
    b.update_position(factors);
    
  }
          
  

  
}
