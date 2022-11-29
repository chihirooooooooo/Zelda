/*
    Name Chihiro Asanoma
		Date 3/28/2022
		Assignment 5
		This file implements Brick class.
*/
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Brick extends Sprite
{
  //int x;
  //int y;
  //int height;
  //int width;
  
  static BufferedImage brick_image=null;
  
  
  public Brick(int x, int y)
  {
    this.x=x;
    this.y=y;
    w=50;
    h=50;
    
    if(this.brick_image==null){
     try{
     this.brick_image=ImageIO.read(new File("brick.jpg"));
     }
     catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
    }
    //this.height=this.image.getHeight();
		//this.width=this.image.getWidth();
  }
  public Brick(Json ob){
    x=(int)ob.getLong("bricksx");
    y=(int)ob.getLong("bricksy");
    w=50;
    h=50;
    if(this.brick_image==null){
     try{
     this.brick_image=ImageIO.read(new File("brick.jpg"));
     }
     catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
    }
    //w=(int)ob.getLong("bricksw");
    //h=(int)ob.getLong("bircksh");
  }
  static public boolean detect(int x, int y)
  {
     boolean detected=false;
     for(int i = 0; i < Model.sprites.size(); i++)
		{
      if(Model.sprites.get(i).isBrick()){
			Sprite b = Model.sprites.get(i);
			if(x==b.x && y==b.y)
      {
        detected=true;
        Model.sprites.remove(i);
      }
      }
      
		}
    return detected;
  }
  Json marshal()
  {
    Json ob=Json.newObject();
    ob.add("bricksy",y);
    ob.add("bricksx",x);
    //ob.add("bricksw",w);
    //ob.add("bircksh",h);
    return ob;
  }
  @Override
  public String toString()
 {
	return "Brick (x,y) = (" + this.x + ", " + this.y + ")";
 }
 public void update(){

 }
 public void draw(Graphics g){
   g.drawImage(brick_image, x - View.roomx, y - View.roomy, null);
 }
 @Override
 public boolean isBrick(){
   return true;
 }
 
}