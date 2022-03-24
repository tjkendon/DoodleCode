
float pos_x = 200;
float pos_y = 350;

float v_x = 0; 
float v_y = -45;

float a_x = 0;
float a_y = 3;

float easing = 0.05;

void setup() {
  size(400, 400);
  frameRate(30);
}

void draw() {
  background(255);
  fill(220, 140, 90);
  noStroke();
  
  v_x += a_x;
  v_y += a_y;
  
  circle( pos_x += v_x, pos_y += v_y,
          10);
          
  
  
  
}
