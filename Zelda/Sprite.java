/*
    Name Chihiro Asanoma
		Date 3/28/2022
		Assignment 5
		This file implements Sprite class.
*/
import java.awt.Graphics;
abstract class Sprite
{
  int x,y,w,h;
  public Sprite(){
    x=0;
    y=0;
    w=0;
    h=0;
  }
  abstract void update();
  abstract void draw(Graphics g);
  abstract Json marshal();
  public boolean isLink(){
    return false;
  }
  public boolean isBrick(){
    return false;
  }
  public boolean isBoomerang(){
    return false;
  }
  public boolean isPot(){
    return false;
  }


}