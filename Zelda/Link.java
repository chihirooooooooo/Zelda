/*
    Name Chihiro Asanoma
		Date 3/28/2022
		Assignment 5
		This file implements Link class.
*/
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Link extends Sprite
{
  //int x;
	//int y;
  int px;
  int py;
  char link_direction;
  //int height;
  //int width;
  static BufferedImage image=null;
  static BufferedImage[] link_images;
  
	double speed;
  public Link(int x, int y){
    this.x=x;
    this.y=y;
    w=75;
    h=75;
    link_direction='d';
    if(this.image==null){
    try{
    this.image=ImageIO.read(new File("link.down1.jpg"));
    this.link_images=new BufferedImage[20];
		this.link_images[0] = ImageIO.read(new File("link.down1.jpg"));
		this.link_images[1] = ImageIO.read(new File("link.down2.jpg"));
		this.link_images[2] = ImageIO.read(new File("link.down3.jpg"));
		this.link_images[3] = ImageIO.read(new File("link.down4.jpg"));
		this.link_images[4] = ImageIO.read(new File("link.down5.jpg"));
		this.link_images[5] = ImageIO.read(new File("link.left1.jpg"));
		this.link_images[6] = ImageIO.read(new File("link.left2.jpg"));
		this.link_images[7] = ImageIO.read(new File("link.left3.jpg"));
		this.link_images[8] = ImageIO.read(new File("link.left4.jpg"));
		this.link_images[9] = ImageIO.read(new File("link.left5.jpg"));
		this.link_images[10] = ImageIO.read(new File("link.right1.jpg"));
		this.link_images[11] = ImageIO.read(new File("link.right2.jpg"));
		this.link_images[12] = ImageIO.read(new File("link.right3.jpg"));
		this.link_images[13] = ImageIO.read(new File("link.right4.jpg"));
		this.link_images[14] = ImageIO.read(new File("link.right5.jpg"));
		this.link_images[15] = ImageIO.read(new File("link.up1.jpg"));
		this.link_images[16] = ImageIO.read(new File("link.up2.jpg"));
		this.link_images[17] = ImageIO.read(new File("link.up3.jpg"));
		this.link_images[18] = ImageIO.read(new File("link.up4.jpg"));
		this.link_images[19] = ImageIO.read(new File("link.up5.jpg"));
    }
    catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
    }
    //this.height=this.image.getHeight();
		//this.width=this.image.getWidth();
  }
  void update()
  {
     if(x>700){
			View.roomx=700;
		}
		if(x<700){
			View.roomx=0;
		}
		if(y>500){
			View.roomy=500;
		}
		if(y<500){
			View.roomy=0;
		}
  }
  @Override
  public String toString()
  {
	  return "Link (x,y) = (" + this.x + ", " + this.y + ")";
  }
  public void getOutOfBrick(Sprite b){
    if(x+w>=b.x && px+w<=b.x){
      x=b.x-w;
    }
    if(x<=b.x+b.w && px>=b.x+b.w){
      x=b.x+b.w;
    }
    if(y+h>=b.y && py+h<=b.y){
      y=b.y-h;
    }
    if(y<=b.y+b.h && py>=b.y+b.h){
      y=b.y+b.h;
    }
  }
  public void savePrevLocation(){
    px=x;
    py=y;
  }
  public void draw(Graphics g){
    g.drawImage(image,x-View.roomx, y-View.roomy,null);
  }
  @Override 
  public boolean isLink(){
    return true;
  }
  Json marshal()
  {
    Json ob=Json.newObject();
    ob.add("linky",y);
    ob.add("linkx",x);
    //ob.add("bricksw",w);
    //ob.add("bircksh",h);
    return ob;
  }


}