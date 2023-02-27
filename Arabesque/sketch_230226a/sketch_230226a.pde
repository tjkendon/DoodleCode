// example from Processing noise() documentation
// https://processing.org/reference/noise_.html

float xoff = 0.0;

void draw() {
  background(204);
  xoff = xoff + .01;
  float n = noise(xoff) * width;
  line(n, 0, n, height);
}
