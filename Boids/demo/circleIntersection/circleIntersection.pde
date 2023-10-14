/** 
 * A very short demo of finding if a point is in a circle.
 */

ArrayList<PVector> points = new ArrayList<>();

/**
 * Takes the location of the circle and the radius, then the x and y of the point.
 */
public boolean inCircle (float c_x, 
                float c_y,
                float c_r,
                float p_x,
                float p_y) {
                  
  return c_r > sqrt(
    pow((p_x - c_x), 2) + pow((p_y - c_y), 2));                
                  
}

void setup() {
  size(400, 400);
}

void draw() {
  background(255);
 
  noStroke();
  fill(120, 120, 120);
  circle(100, 100, 80); // takes diameter (becuase Ellipse) see https://processing.org/reference/circle_.html
  
  for (PVector dot: points) {
    if (inCircle(100, 100, 40, dot.x, dot.y)) {
      fill(200, 60, 60);
    } else {
      fill(60, 60, 200);
    }
    circle (dot.x, dot.y, 5);
  }
  
}

void mouseClicked() {
  // see https://processing.org/reference/mouseClicked_.html
  points.add(new PVector(mouseX, mouseY));
}
