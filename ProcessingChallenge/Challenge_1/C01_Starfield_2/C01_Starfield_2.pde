
int size = 600;

int speed = 5;

int pointSize = 150;
Point[] points = new Point[pointSize];

void setup() {
  size(600, 600);
  background(0);
  stroke(255);
  
  for (int i = 0; i < pointSize; i++) {
    points[i] = randomPoint(color(255));
  }
  
  drawPoints();
}

void draw() {
  translate(width/2, height/2);
  update();
  background(0);
  drawPoints();
  cleanUp();
}

void drawPoints() {
  for (int i = 0; i < pointSize; i++) {
    stroke(points[i].c);
    ellipse(points[i].x,points[i].y,1,1);
  }
}

void update() {
  for (int i = 0; i < pointSize; i++) {

    float a = atan2(points[i].y, points[i].x);
    points[i].y += (speed * sin(a));
    points[i].x += (speed * cos(a));
  }
  
}

void cleanUp() {
  for (int i = 0; i < pointSize; i++) {
    
    if ((points[i].x < -(size / 2)) || 
    (points[i].y < -(size / 2)) || 
    (points[i].x > size / 2) || 
    (points[i].y > size / 2)) {
      color c = color(250);
      if (random(16) < 2) {
        c = color(random(255), random(255), random(255));
      }
      if (random(2) > 1) {
      points[i] = randomPoint(
            -(size / 2), 
            (size / 2), 
            -(size/6), 
            (size / 6),
            c);
    } else {
      points[i] = randomPoint(
            -(size / 6), 
            (size / 6), 
            -(size / 2), 
            (size / 2),
            c);
    }
    }
    
  }
  
}

public  Point randomPoint(color c) {
    return new Point(int(random(size)) - (size / 2), 
      int(random(size)) - (size / 2), c);
  }
  
  public Point randomPoint(int xLow, int xHigh, int yLow, int yHigh, color c) {
    return new Point(xLow + int(random(xHigh - xLow)), 
      yLow + int(random(yHigh - yLow)), c);
  }


class Point {
  int x;
  int y;
  
  color c;
  
  public Point(int x, int y, color c) {
    this.x = x;
    this.y = y;
    this.c = c;
  }
  
  public void updateX(int d) {
    x += d;
  }
  
  public void updateY(int d) {
    y += d;
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  
}
