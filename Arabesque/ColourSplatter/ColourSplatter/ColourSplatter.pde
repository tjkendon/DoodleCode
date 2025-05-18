color hue;

void setup() {
  size(600, 600);
  pixelDensity(2); // pixelDensity helps fix issues with Mac Retina display (2 seems to be only value)
  colorMode(HSB, 360, 100, 100); // set the colour mode to HSB for easier colour
                // https://www.learnui.design/blog/the-hsb-color-system-practicioners-primer.html
                
                
  background(0, 0, 100); // white 
  
  ellipseMode(CENTER);
  
  noStroke();
  
}

void draw() {
  hue++;
}

void mousePressed() {
  float size = 50 + random(50);
  float saturation = 80 + random(20);
  float brightness = 80 + random(20);
  fill(hue%360, saturation, brightness);
  circle(mouseX, mouseY, size);
}
