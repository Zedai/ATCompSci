class Ball{
  int x, y = 297;
  boolean right = true, up = true, down = false, left = false;  
  
  public Ball(int val, boolean l){
    x = val;
    if(l){
      left = true;
      right = false;
    }
  }
  
  void drawBall(){
    fill(255, 255, 255);
    ellipse(x, y, 7, 7);
  }
  
  void iterate(Paddle l, Paddle r){
    if(up)
       y -= 3;
    if(right)
       x += 3;
    if(left)
       x -= 3;
    if(down)
       y += 3;
       
    if(x + 7 >= 385 && ((y + 7) >= r.y && y <= (r.y + 80))){
      right = false;
      left = true;
      bounce.rewind();
      bounce.play();
    }
    if(x <= 15 && ((y + 7) >= l.y && y <= (l.y + 80))){
      right = true;
      left = false; 
      bounce.rewind();
      bounce.play();
    }
    if(y <= 0){
      up = false;
      down = true; 
      bounce.rewind();
      bounce.play();
    }
    if(y + 7 >= 600){
      up = true;
      down = false; 
      bounce.rewind();
      bounce.play();
    }
  }
  
}
