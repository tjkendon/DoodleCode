float noiseStep = 0.005;

size(600, 400);

for (int x = 0; x < width; x++) {
  int y = (int) (noise(noiseStep) * height);
  println(x + ", " + y + " - " + noiseStep);
  point(x, y);
  noiseStep += 0.005;
  
}
  
