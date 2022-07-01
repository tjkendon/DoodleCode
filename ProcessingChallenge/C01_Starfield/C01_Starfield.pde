
int size = 600;

Point p = new Point (300, 300);
int pointSize = 50;
Point[] points = new Point[pointSize];



void setup() {
  size(600, 600);
  background(0);
  stroke(255);
  
  for (int i = 0; i < pointSize; i++) {
    points[i] = randomPoint();
  }
  
  drawPoints();
}

void draw() {
  update();
  background(0);
  drawPoints();
  cleanUp();
}

void drawPoints() {
  for (int i = 0; i < pointSize; i++) {
    ellipse(points[i].x,points[i].y,1,1);
  }
}

void update() {
  for (int i = 0; i < pointSize; i++) {

    if (points[i].x > (size / 2)) {
      points[i].updateX(1);
    } else {
      points[i].updateX(-1);
    }
    if (points[i].y > (size / 2)) {
      points[i].updateY(1);
    } else {
      points[i].updateY(-1);
    }
  }
  
}

void cleanUp() {
  for (int i = 0; i < pointSize; i++) {
    
    if ((points[i].x < 0) || 
    (points[i].y < 0) || 
    (points[i].x > size) || 
    (points[i].y > size)) {
      if (random(2) > 1) {
      points[i] = randomPoint(0, 600, 200, 400);
    } else {
      points[i] = randomPoint(200, 200, 0, 600);
    }
    }
    
  }
  
}

public  Point randomPoint() {
    return new Point(int(random(size)), int(random(size)));
  }
  
  public Point randomPoint(int xLow, int xHigh, int yLow, int yHigh) {
    return new Point(xLow + int(random(xHigh - xLow)), 
      yLow + int(random(yHigh - yLow)));
  }


class Point {
  int x;
  int y;
  
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
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
