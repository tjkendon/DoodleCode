float noiseX = 0.1;
float noiseY = 0.1;
float noiseStep = 0.005;

size(400, 400);
pixelDensity(2); // pixelDensity helps fix issues with Mac Retina display (2 seems to be only value)
colorMode(HSB, 360, 100, 100); // set the colour mode to HSB for easier colour adventures later
  
for (int y = 0; y < height; y++) {
  for (int x = 0; x < width; x++) {
    int d = (int) (noise(noiseX, noiseY) * 100);
    stroke(0, 0, d);
    point(x, y);
    noiseX += noiseStep;
    noiseY += noiseStep;
  }
  
}
