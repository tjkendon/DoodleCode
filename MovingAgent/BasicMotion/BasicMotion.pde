
float pos_x = 100;
float pos_y = 100;

float v_x = 1.5; 
float v_y = -2.1;

float a_x = 0;
float a_y = 0.2;

float easing = 0.05;

void setup() {
  size(400, 400);
}

void draw() {
  background(255);
  fill(220, 140, 90);
  noStroke();
  
  v_x += a_x;
  v_y += a_y;
  
  circle( pos_x += v_x, pos_y += v_y,
          66);
          
  if ((pos_y + 33) >= 400) {
    v_y = -v_y;
  }
  
  
}
