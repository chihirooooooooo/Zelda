/*
    Name Chihiro Asanoma
		Date 3/28/2022
		Assignment 5
		This file implements View class.
*/

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



class View extends JPanel
{
	JButton b1;
	Model model;
	//static int width;
	//static int height;
	//BufferedImage turtle_image;
	//BufferedImage brick_image;
	static int roomx;
	static int roomy;
	//BufferedImage[] link_images;
	
	
	/*void removeButton()
	{
		this.remove(b1);
		this.repaint();
	} */
	

	View(Controller c, Model m)
	{
		//b1 = new JButton("Don't push me");
		//b1.addActionListener(c);
		//this.add(b1);
		c.setView(this);
		model=m;
		roomx = 0;
		roomy = 0;
		try
		{
			/*this.turtle_image =
				ImageIO.read(new File("turtle.png")); */
			//this.brick_image =ImageIO.read(new File("brick.jpg"));
			/*this.link_images=new BufferedImage[20];
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
		  this.link_images[19] = ImageIO.read(new File("link.up5.jpg"));*/
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		//width=this.brick_image.getWidth();
		//height=this.brick_image.getHeight();
		
		



	}
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//g.drawImage(this.turtle_image, model.turtle_x, model.turtle_y, null);
		Iterator<Sprite> it=model.sprites.iterator();
		//for(int i = 0; i < model.bricks.size(); i++)
		while(it.hasNext())
		{
			Sprite b=it.next();
			//Brick b = model.bricks.get(i);
			b.draw(g);
		}
		//g.drawImage(model.link.image,model.link.x-roomx, model.link.y-roomy,null);
		/*if(model.link.x>700){
			this.roomx=700;
		}
		if(model.link.x<700){
			this.roomx=0;
		}
		if(model.link.y>500){
			this.roomy=500;
		}
		if(model.link.y<500){
			this.roomy=0;
		}*/
	  
		
	}
	
}
