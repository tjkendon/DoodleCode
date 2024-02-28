
public static final float DEFAULT_NEIGHBOURHOOD_SIZE = 60;

int boidCount = 10;
ArrayList<Boid> boids = new ArrayList();


PVector ourBoidStart = new PVector(100, 100);
color ourBoidColour = color(200, 30, 170);
Boid ourBoid = new Boid((int)ourBoidStart.x, (int)ourBoidStart.y, ourBoidColour);

void setup() {
  size(800, 800);
  
  boids.add(ourBoid);
  for (int i = 1; i < boidCount; i++) {
    boids.add(new Boid());
  }
  
  
}

void draw() {
  background(255);
  
  noStroke();
  
  for (Boid b: boids) {
    if (b.equals(ourBoid)) {
      
      //drawNeighbourhood(b);
      
      stroke(100, 100, 80);
  noFill();
  circle(b.getPosition().x, b.getPosition().y, b.getNeighbourhood() * 2);
      
      fill(b.getColour());  
      circle( ourBoid.getPosition().x, ourBoid.getPosition().y, ourBoid.getSize());
      

      drawSeperationUrge(b);
    } else {
      if (ourBoid.inNeighbourhood(b)) {
        fill(200, 60, 60);  
      } else {
        fill(60, 60, 200);
      }
      circle( b.getPosition().x, b.getPosition().y, b.getSize());
    }
        
    
    ArrayList factors = new ArrayList();
    factors.add(new PVector(mouseX, mouseY));
    //factors.add(new PVector(400,400));
    factors.add(PVector.add(
      b.calculateSeperationUrge(boids),
      b.getPosition()));
  
    b.updatePosition(factors);
    
  }
  
}

void drawNeighbourhood(Boid b) {
  println("N", b.getPosition().x, b.getPosition().y);
  stroke(100, 100, 80);
  noFill();
  circle(b.getPosition().x, b.getPosition().y, b.getNeighbourhood() * 2);
      
}

void drawSeperationUrge(Boid b) {
  println("S", b.getPosition().x, b.getPosition().y);
  stroke(255,0,0);
      line(
        b.getPosition().x, 
        b.getPosition().y, 
        b.getPosition().x + b.calculateSeperationUrge(boids).x, 
        b.getPosition().y + b.calculateSeperationUrge(boids).y);
  noStroke();  
}
