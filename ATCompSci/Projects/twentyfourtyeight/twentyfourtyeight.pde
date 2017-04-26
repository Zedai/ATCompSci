//import ddf.minim.spi.*;
//import ddf.minim.signals.*;
//import ddf.minim.*;
//import ddf.minim.analysis.*;
//import ddf.minim.ugens.*;
//import ddf.minim.effects.*;
//
//AudioPlayer bounce;
//Minim minim;
//PImage bg;
int currentScore = 0, bestScore;
Tile[][] grid = new Tile[4][4];
PrintWriter output;
BufferedReader reader;

void setup(){
  size(576, 720);
//  minim = new Minim(this);
//  bg = loadImage("fullWindow.png");
  for(int i = 0; i < 4; i++)
    for(int c = 0; c < 4; c++)
      grid[i][c] = new Tile();
  randomSpawn();
  randomSpawn();
  reader = createReader("best.txt");    
  try {
    bestScore = Integer.parseInt(reader.readLine());
  } catch (IOException e) {
    bestScore = 0;
  }
}

void draw() {
  fill(255, 102, 148);
//  background(bg);
  image(loadImage("fullWindowv2.png"), 0, 0);
  printGrid();
  textSize(18);
  if(currentScore < 10)
    text(currentScore, 330, 119); 
  else if(currentScore < 100)
    text(currentScore , 328, 119); 
  else if(currentScore < 1000)
    text(currentScore , 320, 119); 
  else if(currentScore < 10000)
    text(currentScore , 314, 119); 
  else if(currentScore < 100000)
    text(currentScore , 310, 119); 
  else 
    text(currentScore , 305, 119);   
    
  if(bestScore < 10)
    text(bestScore, 430 + 8, 119); 
  else if(bestScore < 100)
    text(bestScore , 428 + 8, 119); 
  else if(bestScore < 1000)
    text(bestScore , 420 + 8, 119); 
  else if(bestScore < 10000)
    text(bestScore , 414 + 8, 119); 
  else if(bestScore < 100000)
    text(bestScore , 410 + 8, 119); 
  else 
    text(bestScore , 405 + 8, 119); 

  if(currentScore > bestScore){
    bestScore = currentScore;
    output = createWriter("best.txt"); 
    output.print(bestScore);
    output.flush();
    output.close();
  }
}

void moveUp(){
  for(int r = 1; r < 4; r++)
    for(int c = 0; c < 4; c++){
      if(!grid[r][c].empty()){
         int k = r;
         while(k > 0 && (grid[k-1][c].getState() == grid[k][c].getState() || grid[k-1][c].empty())){
          
           
          if(grid[k - 1][c].empty()){
              grid[k-1][c] = grid[k][c];
              grid[k][c] = new Tile();
          }
          else if(grid[k-1][c].getState() == grid[k][c].getState()){
            if(grid[k][c].mergeable()){
              grid[k-1][c].setState(grid[k][c].getState() * 2);
              grid[k][c] = new Tile();
              currentScore += grid[k-1][c].getState();
            }
            grid[k-1][c].mergeSet(false);
          }
          k--;
        }
      }
      remerge();
    }
}

void remerge(){
  for(Tile[] tile : grid)
    for(Tile t : tile)
      t.mergeSet(true);
}

void moveDown(){
    for(int r = 2; r >= 0; r--)
    for(int c = 0; c < 4; c++){
      if(!grid[r][c].empty()){
         int k = r;
         while(k < 3 && (grid[k+1][c].getState() == grid[k][c].getState() || grid[k+1][c].empty())){
          if(grid[k + 1][c].empty()){
              grid[k+1][c] = grid[k][c];
              grid[k][c] = new Tile();
          }
          else if(grid[k+1][c].getState() == grid[k][c].getState()){
            if(grid[k][c].mergeable()){
              grid[k+1][c].setState(grid[k][c].getState() * 2);
              grid[k][c] = new Tile();
              currentScore += grid[k+1][c].getState();
            }
            grid[k+1][c].mergeSet(false);
          }
          k++;
        }
      }
      remerge();
    }
}

void randomSpawn(){
   int x = (int)(Math.random()*cellsLeft()) + 1; 
   for(int r = 0; r < 4; r++)
     for(int c = 0; c < 4; c++){
       if(x == 1 && grid[r][c].empty()){
         grid[r][c] = new Tile(2);
         return;  
       }
       if(grid[r][c].empty())
         x--;
     }
     
}

int cellsLeft(){
  int cells = 0;
  for(Tile[] tile : grid)
    for(Tile t : tile)
      if(t.empty())
        cells++;
        
   return cells;
}
void moveRight(){
   for(int r = 0; r < 4; r++)
    for(int c = 3; c >= 0; c--){
      if(!grid[r][c].empty()){
         int k = c;
         while(k < 3 && (grid[r][k + 1].getState() == grid[r][k].getState() || grid[r][k + 1].empty())){
          if(grid[r][k + 1].empty()){
              grid[r][k + 1] = grid[r][k];
              grid[r][k] = new Tile();
          }
          else if(grid[r][k + 1].getState() == grid[r][k].getState()){
            if(grid[r][k].mergeable()){
              grid[r][k + 1].setState(grid[r][k].getState() * 2);
              grid[r][k] = new Tile();
              currentScore += grid[r][k+1].getState();
            }
            grid[r][k + 1].mergeSet(false);
          }
          k++;
        }
      }
      remerge();
    }
}

void moveLeft(){
   for(int r = 3; r >= 0; r--)
    for(int c = 0; c < 4; c++){
      if(!grid[r][c].empty()){
         int k = c;
         while(k > 0 && (grid[r][k - 1].getState() == grid[r][k].getState() || grid[r][k - 1].empty())){
          if(grid[r][k - 1].empty()){
              grid[r][k - 1] = grid[r][k];
              grid[r][k] = new Tile();
          }
          else if(grid[r][k - 1].getState() == grid[r][k].getState()){
            if(grid[r][k].mergeable()){
              grid[r][k - 1].setState(grid[r][k].getState() * 2);
              grid[r][k] = new Tile();
              currentScore += grid[r][k-1].getState();
            }
            grid[r][k - 1].mergeSet(false);
          }
          k--;
        }
      }
      remerge();
    }
}

void printGrid(){
  for(int i = 0; i < 4; i++)
    for(int c = 0; c < 4; c++)
       image(grid[i][c].getTile(), -175 + 110 * c + 7 * c, -86 + 110 * i + 7 * i);
}


void keyReleased(){
  if(key == CODED && keyCode == UP || key == 'w' || key == 'W'){
    moveUp();
    randomSpawn();
  }
  else if(key == CODED && keyCode == DOWN || key == 's' || key == 'S'){
    moveDown();
    randomSpawn();
  }
  else if(key == CODED && keyCode == RIGHT || key == 'd' || key == 'D'){
    moveRight();
    randomSpawn();
  }
  else if(key == CODED && keyCode == LEFT || key == 'a' || key == 'A'){
    moveLeft();
    randomSpawn();
  }
}
