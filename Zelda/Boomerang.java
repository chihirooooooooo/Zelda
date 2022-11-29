/*
    Name Chihiro Asanoma
		Date 3/28/2022
		Assignment 5
		This file implements Boomerang class.
*/
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Boomerang extends Sprite
{
  static BufferedImage image=null;
  //static BufferedImage[] boomerang_images;
  char boomerang_direction;
  
  public Boomerang(int x, int y){
    this.x=x;
    this.y=y;

    
    
    if(this.image==null){
    try{
    this.image=ImageIO.read(new File("boomerang1.png"));
    /*this.boomerang_images=new BufferedImage[4];
		this.boomerang_images[0] = ImageIO.read(new File("boomerang1.png"));
		this.boomerang_images[1] = ImageIO.read(new File("boomerang2.png"));
		this.boomerang_images[2] = ImageIO.read(new File("boomerang3.png"));
    this.boomerang_images[3] = ImageIO.read(new File("boomerang4.png"));*/
    }
    catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
    }
    w=8;
    h=12;
  }
  
  public void update()
  {
    
    /*if(this.image==this.boomerang_images[0]){
				this.image=boomerang_images[1];
        System.out.println("k");
        w=12;
        h=8;
		}else if(this.image==this.boomerang_images[1]){
        this.image=this.boomerang_images[2];
        w=8;
        h=12;
    }else if(this.image==this.boomerang_images[2]){
        this.image=this.boomerang_images[3];
        w=12;
        h=8;
    }else if(this.image==this.boomerang_images[3]){
        this.image=this.boomerang_images[0];
        w=8;
        h=12;
    }*/

    
    if(boomerang_direction=='u'){
      y-=4;
    }
    if(boomerang_direction=='d'){
      y+=4;
    }
    if(boomerang_direction=='l'){
      x-=4;
    }
    if(boomerang_direction=='r'){
      x+=4;
    }

  }
  Json marshal()
  {
    Json ob=Json.newObject();
    ob.add("boomerangy",y);
    ob.add("boomerangx",x);
    //ob.add("bricksw",w);
    //ob.add("bircksh",h);
    return ob;
  }
  public void draw(Graphics g){
    g.drawImage(image,x-View.roomx, y-View.roomy,null);
  }
  @Override
  public boolean isBoomerang(){
    return true;
  }
  @Override
  public String toString()
 {
	return "Boomerang (x,y) = (" + this.x + ", " + this.y + ")";
 }
  
 
}