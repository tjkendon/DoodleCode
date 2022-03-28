
float pos_x = 100;
float pos_y = 100;

float v_x = 1.5; 
float v_y = -2.1;

float a_x = 0;
float a_y = 0.2;

float size = 66;

int field_height = 400;
int field_width = 400;

float floor_friction = 0.95;
float wall_friction = 0.9;

void setup() {
  size(400, 400);
  
  v_x = random(-3, 3); 
  v_y = random(-3, 3);
}

void draw() {
  background(255);
  fill(220, 140, 90);
  noStroke();
  
  v_x += a_x;
  v_y += a_y;
  
  circle( pos_x += v_x, pos_y += v_y,
          size);
  println(pos_y + " " + v_y);      
  if (((pos_y + (size / 2)) >= field_height) || ((pos_y - size / 2) <= 0)) {
    v_y = -abs(v_y) * floor_friction;
    pos_y = field_height - (size / 2);
  }
  if (((pos_x + size / 2) >= field_width) || ((pos_x - size / 2) <= 0)) {
    v_x = -v_x * wall_friction;
  }
  
  
}
