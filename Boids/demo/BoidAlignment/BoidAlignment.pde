 //<>// //<>//
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

  for (Boid b : boids) {
    if (b.equals(ourBoid)) {
      drawDebug(ourBoid);


      stroke(100, 100, 80);
      noFill();
      circle(b.getPosition().x, b.getPosition().y, b.getNeighbourhood() * 2);

      fill(b.getColour());
      circle( ourBoid.getPosition().x, ourBoid.getPosition().y, ourBoid.getSize());

      
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
    factors.add(new PVector(400, 400));


    b.updatePosition(factors);
  }
}

void drawNeighbourhood(Boid b) {
  stroke(100, 100, 80);
  noFill();
  circle(b.getPosition().x, b.getPosition().y, b.getNeighbourhood() * 2);
}

void drawDebug(Boid b) {
  println(b);
  stroke(0);
  line(b.getPosition().x, b.getPosition().y, b.getVelocity().x, b.getVelocity().y);
  stroke(100);
  line(b.getPosition().x, b.getPosition().y, b.getAcceleration().x, b.getAcceleration().y);
}

public static boolean inCircle (float cX,
  float cY,
  float cR,
  float pX,
  float pY) {

  return cR > sqrt(pow((pX - cX), 2) + pow((pY - cY), 2));
}
