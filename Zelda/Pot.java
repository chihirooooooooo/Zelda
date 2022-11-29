/*
    Name Chihiro Asanoma
		Date 3/28/2022
		Assignment 5
		This file implements Pot class.
*/
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Pot extends Sprite
{
  //int x;
  //int y;
  //int height;
  //int width;
  
  static BufferedImage pot_image=null;
  static BufferedImage pot_broken_image=null;
  static BufferedImage pot_current_image=null;
  char pot_direction; 
  boolean broken=false;
  int broken_timer = 0;
  boolean moving = false;

  public Pot(int x, int y)
  {
    this.x=x;
    this.y=y;
    
   
    
    if(this.pot_image==null && this.pot_broken_image==null){
     try{
     this.pot_image=ImageIO.read(new File("pot.png"));
     this.pot_broken_image=ImageIO.read(new File("pot_broken.png"));

     }
     catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
    }
    this.pot_current_image=this.pot_image;
    //this.height=this.image.getHeight();
		//this.width=this.image.getWidth();
  }
  public Pot(Json ob){
    x=(int)ob.getLong("potsx");
    y=(int)ob.getLong("potsy");
    w=48;
    h=48;
    if(this.pot_image==null){
     try{
     this.pot_image=ImageIO.read(new File("pot.png"));
     this.pot_broken_image=ImageIO.read(new File("pot_broken.png"));
     }
     catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
    }
    this.pot_current_image=this.pot_image;
    //w=(int)ob.getLong("bricksw");
    //h=(int)ob.getLong("bircksh");
  }
  /*static public boolean detect(int x, int y)
  {
     boolean detected=false;
     for(int i = 0; i < Model.sprites.size(); i++)
		{
      if(Model.sprites.get(i).isPot()){
			Sprite b = Model.sprites.get(i);
			if(x==b.x && y==b.y)
      {
        detected=true;
        Model.sprites.remove(i);
      }
      }
      
		}
    return detected;
  }*/
  Json marshal()
  {
    Json ob=Json.newObject();
    ob.add("potsy",y);
    ob.add("potsx",x);
    //ob.add("bricksw",w);
    //ob.add("bircksh",h);
    return ob;
  }
  @Override
  public String toString()
 {
	return "Pot (x,y) = (" + this.x + ", " + this.y + ")";
 }
 public void update(){

   if(pot_direction=='u'){
      y-=5;
    }
    if(pot_direction=='d'){
      y+=5;
    }
    if(pot_direction=='l'){
      x-=5;
    }
    if(pot_direction=='r'){
      x+=5;
    }
 }
 public void draw(Graphics g){
    if(!broken){
     g.drawImage(pot_current_image, x - View.roomx, y - View.roomy, null); 
    }else{
     g.drawImage(pot_broken_image, x - View.roomx, y - View.roomy, null);
     broken_timer++;  
    }
   
 }
 
 @Override
 public boolean isPot(){
   return true;
 }
 
}