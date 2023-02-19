/**
 * Further experiment messing with colours as they're painted onto the circles
 */ 

static final int xScale = 50; //manage the space alotted to each circle
static final int yScale = 50; 
static final int startSize = 40; // size to actually draw the circle

static final int low = 50; // ranges for saturation and brightness;
static final int high = 95;

int hue = 0; // hue for circle colouring
int hueStep = 3; // value to adjust hue

int sat = high; // saturation value
int satStep = -3; // value to adjust saturation

int brightness = high; // brightness value
int brightStep = -5; // value to adjust brightness

void setup() {
  size(400, 400); // test size
  pixelDensity(2); // pixelDensity helps fix issues with Mac Retina display (2 seems to be only value)
  colorMode(HSB, 360, 100, 100); // set the colour mode to HSB for easier colour adventures later
                // https://www.learnui.design/blog/the-hsb-color-system-practicioners-primer.html
                
  frameRate(15);                
                
  background(0, 0, 100); // white
  noStroke();

  
}

void draw() {
 
  drawCircles();
}

void drawCircles() {
  hue+=hueStep;
  sat+=satStep;
      if ((sat <= low) || (sat >= high)) {
        satStep*=-1;
        brightness+=brightStep;
        if ((brightness <= low) || (brightness >= high)) {
          brightStep*=-1;
        }
      }
  background(0, 0, 100); // white
  for (int y = 1; y < height / yScale; y++) {
    for (int x = 1; x < width / xScale; x++) {
      fill((hue + x+y*2) % 360, sat, brightness);
      
      
      circle(x * xScale, y * yScale, startSize);
    }
  }
}
