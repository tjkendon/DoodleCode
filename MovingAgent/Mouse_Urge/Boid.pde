float top_speed = 5;
float size = 33;

class Boid {
 
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
  
  //acceleration = PVector.sub(mouse,position);
  //  acceleration.add(PVector.sub(mid, position));
  //  acceleration.setMag(0.1);
  
  
  public update_position() {
    velocity.add(acceleration);
    velocity.limit(top_speed);
    position.add(velocity);
  }
  
  public color getColour() {
    return colour;
  }
  
  public PVector getPosition() {
    return position;
  }
  
  public int getSize() {
    return size();
  }
    
  
}
