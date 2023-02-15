/**
 * Experiment setting up a basic form of an array of circles which can each get colour.
 */ 

static final int xScale = 50; //manage the space alotted to each circle
static final int yScale = 50; 
static final int startSize = 40; // size to actually draw the circle

void setup() {
  size(400, 400); // test size
  pixelDensity(2); // pixelDensity helps fix issues with Mac Retina display (2 seems to be only value)
  colorMode(HSB, 360, 100, 100); // set the colour mode to HSB for easier colour adventures later
                // https://www.learnui.design/blog/the-hsb-color-system-practicioners-primer.html
                
                
  background(0, 0, 100); // white

  for (int y = 1; y < height / yScale; y++) {
    for (int x = 1; x < width / xScale; x++) {
      fill((x * xScale + y * yScale) % 360, 100, 80);
      circle(x * xScale, y * yScale, startSize);
    }
  }
}
