float accelerationMagnitude = 0.1;
float top_speed = 5;
float size = 10;



class Boid {
  
  float neighbourhood = 40;
 
  private color colour;
  
  private PVector position;
  private PVector velocity;
  private PVector acceleration;
  
  public Boid() {
    
    colour = color(random(255), random(255), random(255));
    
    position = new PVector(100, 100);
    velocity = new PVector(0, 0);
    acceleration = new PVector(1, 0);
    
  }
  
  public Boid(int x, int y, color c) {
    
    colour = c;
    
    position = new PVector(x, y);
    velocity = new PVector(0, 0);
    acceleration = new PVector (0, 0);
    
  }
  
  public void updatePosition(ArrayList<PVector> factors) {
    
    acceleration = PVector.sub(factors.get(0),position);
    for (int i = 1; i < factors.size(); i++) {
      acceleration.add(PVector.sub(factors.get(i), position));
    }
    acceleration.setMag(accelerationMagnitude);
    
    velocity.add(acceleration);
    velocity.limit(top_speed);
    position.add(velocity);
    
  }
  
  public boolean inCircle (float c_x, 
                float c_y,
                float c_r,
                float p_x,
                float p_y) {
                  
  return c_r > sqrt(
    pow((p_x - c_x), 2) + pow((p_y - c_y), 2));                
                  
}
  
  public boolean inNeighbourhood(Boid b) {
    return inCircle(position.x, position.y, neighbourhood, b.position.x, b.position.y);
    
    
  }
  
  public color getColour() {
    return colour;
  }
  
  public PVector getPosition() {
    return position;
  }
  
  public float getSize() {
    return size;
  }
  
    
  
}
