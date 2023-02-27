float noiseX = 0.1;
float noiseY = 0.1;
float stepX = 0.03;
float stepY = 0.0001;

size(400, 400);
pixelDensity(2); // pixelDensity helps fix issues with Mac Retina display (2 seems to be only value)
colorMode(HSB, 360, 100, 100); // set the colour mode to HSB for easier colour adventures later
  
for (int y = 0; y < height; y++) {
  for (int x = 0; x < width; x++) {
    int d = (int) (noise(noiseX, noiseY) * 360);
    stroke(d, 100, 100);
    point(x, y);
    noiseX += stepX;
  }
  noiseY += stepY;
  
}
