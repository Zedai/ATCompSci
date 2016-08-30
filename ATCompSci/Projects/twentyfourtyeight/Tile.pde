class Tile{
  int state = 0;
  boolean merge = true;

  public Tile(){
    state = 0;
  }
  
  public boolean mergeable(){
    return merge;
  }
  
  public void mergeSet(boolean set){
    merge = set;
  }
  
  public Tile(int s){
    state = s;
  }
  
  public boolean empty(){
    return state == 0;  
  }
  
  public void setState(int state){
    this.state = state;
  }
  
  public int getState(){
    return state;
  }
  
  public PImage getTile(){
    PImage tile = new PImage();
    if(state == 0)
      tile = loadImage("emptyTile.png");
    else if(state == 2)
      tile = loadImage("twoTile.png");
    else if(state == 4)
      tile = loadImage("fourTile.png");
    else if(state == 8)
      tile = loadImage("eightTile.png");
    else if(state == 16)
      tile = loadImage("sixteenTile.png");
    else if(state == 32)
      tile = loadImage("thirtytwoTile.png");
    else if(state == 64)
      tile = loadImage("sixtyfourTile.png");
    else if(state == 128)
      tile = loadImage("onehundredtwentyeightTile.png");
    else if(state == 256)
      tile = loadImage("twohundredfiftysixTile.png");
    else if(state == 512)
      tile = loadImage("fivehundredtwelveTile.png");
    else if(state == 1024)
      tile = loadImage("onethousandtwentyfourTile.png");
    else if(state == 2048)
      tile = loadImage("twothousandfourtyeightTile.png");
      
    return tile;
  }
  
}
