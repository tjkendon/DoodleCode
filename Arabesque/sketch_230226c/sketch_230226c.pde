float noiseValue = 0.1;
float noiseStep = 0.007;

size(600, 400);

for (int x = 0; x < width; x++) {
  int y = (int) (noise(noiseValue) * height);
  println(x + ", " + y + " - " + noiseValue);
  point(x, y);
  noiseValue += noiseStep;
  
}
  
