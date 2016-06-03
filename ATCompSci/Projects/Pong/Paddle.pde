class Paddle{
  int x, y = 260; 
  public Paddle(int x){
    this.x = x;   
  }
  
  void drawPaddle(){
    fill(255, 255, 255);
    rect(x, y, 15, 80);
  }
  
  void up(){
    if(y > 0)
      y -= 3;
  }
  
  void down(){
    if(y < 520)
      y += 3;
  }

}
