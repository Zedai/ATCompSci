import ddf.minim.spi.*;
import ddf.minim.signals.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.ugens.*;
import ddf.minim.effects.*;

Paddle left = new Paddle(0), right = new Paddle(385);
boolean wKey = false, sKey = false, iKey = false, kKey = false, rightStart = true, leftStart = false;
Ball ball = new Ball(375, false);
int lScore = 0, rScore = 0;
AudioPlayer bounce;
Minim minim;

void setup(){
  size(400, 600);
  minim = new Minim(this);
  bounce = minim.loadFile("bounce.mp3");

}

void draw() {
  fill(255, 102, 148);
  rect(0, 0, 400, 600);
  
  if(leftStart || rightStart){
    left = new Paddle(0);
    right = new Paddle(385);
    if(rightStart)
       ball = new Ball(375, false);
    if(leftStart)
       ball = new Ball(22, true);
  }
  else
      ball.iterate(left, right);
  
  left.drawPaddle();
  right.drawPaddle();
  ball.drawBall();
  
  if(wKey){
    left.up();
    leftStart = false;
  }
  if(sKey){
    left.down();
    leftStart = false;
  }
  if(iKey){
    right.up();
    rightStart = false;
  }
  if(kKey){
    right.down();
    rightStart = false;
  }
  
  if(ball.x <= 0){
    rightStart = true;
    reset();
    rScore++;
  }
  if(ball.x + 7 >= 400){
    leftStart = true;
    reset();
    lScore++;
  }
  
  textSize(18);
  text("Left Score: " + lScore + "\nRight Score: " + rScore, 10, 25); 
}

void reset(){
  wKey = false;
  sKey = false;
  iKey = false;
  kKey = false;
}
void keyPressed(){
  toggle(key, true); 
}
     
void keyReleased(){
  toggle(key, false); 
}

void toggle(char key, boolean set){
  if(key == 'W' || key == 'w')
     wKey = set; 
  if(key == 'S' || key == 's')
     sKey = set; 
  if(key == 'I' || key == 'i')
     iKey = set; 
  if(key == 'K' || key == 'k')
     kKey = set; 

}  

