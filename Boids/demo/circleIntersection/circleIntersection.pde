size (400, 400)


public boolean inCircle (double c_x, 
                double c_y,
                double c_r,
                double p_x,
                double p_y) {
                  
  return c_r > sqrt(
    pow((p_x - c_x), 2) + pow((p_y - c_y), 2));
                  
                  
}
