
PVector position;
PVector velocity;
PVector acceleration;

int boidCount = 10;
ArrayList<Boid> boids = new ArrayList();


Boid ourBoid = new Boid(100, 100, color(200, 30, 170));

int field_height = 800;
int field_width = 800;

ArrayList<PVector> positions;

void setup() {
  size(800, 800);
  
  boids.add(ourBoid);
  for (int i = 1; i < boidCount; i++) {
    boids.add(new Boid((int) random(800), (int) random(800), color(0, 0, 0)));
  }
  boids.add(new Boid(300, 300, color(255, 0, 0)));
  
  
}

void draw() {
  background(255);
  
  noStroke();
  
  for (Boid b: boids) {
    if (b.equals(ourBoid)) {
      stroke(100, 100, 80);
      noFill();
      circle(ourBoid.getPosition().x, ourBoid.getPosition().y, ourBoid.neighbourhood * 2);
      fill(b.getColour());  
      circle( ourBoid.getPosition().x, ourBoid.getPosition().y, ourBoid.getSize());

      stroke(255,0,0);
      line(
        b.getPosition().x, 
        b.getPosition().y, 
        b.getPosition().x + b.getSeperationUrge(boids).x, 
        b.getPosition().y + b.getSeperationUrge(boids).y);
      noStroke();  
    } else {
      if (ourBoid.inNeighbourhood(b)) {
        fill(200, 60, 60);  
      } else {
        fill(60, 60, 200);
      }
      circle( b.getPosition().x, b.getPosition().y, b.getSize());
    }
        
    
    ArrayList factors = new ArrayList();
    //factors.add(new PVector(mouseX, mouseY));
    factors.add(new PVector(400,400));
    factors.add(PVector.add(
      b.getSeperationUrge(boids),
      b.getPosition()));
  
    b.updatePosition(factors);
    
  }
          
  

  
}
