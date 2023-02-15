/**
 * Experiment messing with colours as they're painted onto the circles
 */ 

static final int xScale = 50; //manage the space alotted to each circle
static final int yScale = 50; 
static final int startSize = 40; // size to actually draw the circle

int hue = 0; // hue for circle colouring
int hueStep = 7; // value to adjust hue

void setup() {
  size(400, 400); // test size
  pixelDensity(2); // pixelDensity helps fix issues with Mac Retina display (2 seems to be only value)
  colorMode(HSB, 360, 100, 100); // set the colour mode to HSB for easier colour adventures later
                // https://www.learnui.design/blog/the-hsb-color-system-practicioners-primer.html
                
  frameRate(7);                
                
  background(0, 0, 100); // white
  noStroke();

  
}

void draw() {
 
  drawCircles();
}

void drawCircles() {
  background(0, 0, 100); // white
  for (int y = 1; y < height / yScale; y++) {
    for (int x = 1; x < width / xScale; x++) {
      fill(hue%360, 100, 90);
      hue+=hueStep;
      circle(x * xScale, y * yScale, startSize);
    }
  }
}
