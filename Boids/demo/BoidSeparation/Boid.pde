float accelerationMagnitude = 0.1;
float topSpeed = 5;
float size = 10;

class Boid {

  float neighbourhood;

  private color colour;

  private PVector position;
  private PVector velocity;
  private PVector acceleration;

  public Boid() {

    colour = color(random(255), random(255), random(255)); //<>//
    
    this.neighbourhood = DEFAULT_NEIGHBOURHOOD_SIZE;

    position = new PVector((int) random(width), (int) random(height));
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
  }
  
  public Boid (int x, int y) {
    this(); //<>//
    position = new PVector(x, y);
  }
  
  public Boid(int x, int y, color c) {
    this(x, y); //<>//
    colour = c;
  }

  public Boid(int x, int y, int neighbourhood, color c) {
    this(x, y, c); //<>//
    this.neighbourhood = neighbourhood;

  }

  public PVector updateUrges(ArrayList<PVector> factors) {

    PVector totalUrge = PVector.sub(factors.get(0), position);

    for (int i = 1; i < factors.size(); i++) {
      totalUrge.add(PVector.sub(factors.get(i), position));
    }

    return totalUrge;
  }

  public void updatePosition(ArrayList<PVector> factors) {

    acceleration = updateUrges(factors);
    acceleration.setMag(accelerationMagnitude);

    velocity.add(acceleration);
    velocity.limit(topSpeed);
    position.add(velocity);
  }

  public boolean inCircle (float cX,
    float cY,
    float cR,
    float pX,
    float pY) {

    return cR > sqrt(pow((pX - cX), 2) + pow((pY - cY), 2));
  }

  public boolean inNeighbourhood(Boid b) {

    return inCircle(position.x, position.y, neighbourhood, b.position.x, b.position.y);
  }

  public ArrayList<Boid> findNeighbours(ArrayList<Boid> allBoids) {
    ArrayList<Boid> neighbours = new ArrayList<>();

    for (Boid b : allBoids) {
      if ((!b.equals(this)) && inNeighbourhood(b)) {
        neighbours.add(b);
      }
    }

    return neighbours;
  }

  public PVector calculateSeperationUrge(ArrayList<Boid> allBoids) {

    ArrayList<Boid> neighbours = findNeighbours(allBoids);
    if (!neighbours.isEmpty()) {
      PVector cluster = new PVector();

      for (Boid b : neighbours) {
        cluster = PVector.add(cluster, PVector.sub(b.position, this.position));
      }
      cluster = cluster.div(neighbours.size());

      return cluster.rotate(PI);
    } else {
      return new PVector(0, 0);
    }
  }

  public PVector getPosition() {
    return position;
  }
  
  public float getNeighbourhood() {
    return neighbourhood;
  }

  public color getColour() {
    return colour;
  }

  public float getSize() {
    return size;
  }
}
