/*
    Name Chihiro Asanoma
		Date 3/28/2022
		Assignment 5
		This file implements Controller class.
*/




import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;





class Controller implements ActionListener, MouseListener, KeyListener
{
	View view;
	Model model;
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	boolean play=true;
	boolean put_pot=false;
	void setView(View v)
	{
		view = v;
	}

	Controller(Model m)
	{
		model=m;
	}
	

	public void actionPerformed(ActionEvent e)
	{
		//view.removeButton();
	}
	public void mousePressed(MouseEvent e)
	{
		//model.setDestination(e.getX(), e.getY());
		if(!play){

		if(!put_pot){
		if(!Brick.detect(e.getX()-e.getX()%50+view.roomx, e.getY()-e.getY()%50+view.roomy))
		{
     Brick a=new Brick(e.getX()-e.getX()%50+view.roomx, e.getY()-e.getY()%50+view.roomy);
		 model.sprites.add(a);
		}
		}else{
			
     Pot a=new Pot(e.getX()-e.getX()%48+view.roomx, e.getY()-e.getY()%48+view.roomy);
		 model.sprites.add(a);
		}
		
		}
	}

	public void mouseReleased(MouseEvent e) {    }
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) 
	{ 
     if(e.getY() < 100)
		{
			System.out.println("break here");
		}
	}
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = true; break;
			case KeyEvent.VK_LEFT: keyLeft = true; break;
			case KeyEvent.VK_UP: keyUp = true; break;
			case KeyEvent.VK_DOWN: keyDown = true; break;
		}

	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = false; break;
			case KeyEvent.VK_LEFT: keyLeft = false; break;
			case KeyEvent.VK_UP: keyUp = false; break;
			case KeyEvent.VK_DOWN: keyDown = false; break;
			case KeyEvent.VK_ESCAPE: System.exit(0);
		}
		char c=e.getKeyChar();
		if(c =='q' || c =='Q'){
			System.exit(0);
		}
		/*if(c =='a'){
	    view.roomx = 0;
		}

		if(c =='d'){
		  view.roomx = 700;
		}
		if(c =='w'){
			view.roomy = 0;
		}
		if(c =='x'){
			view.roomy = 500;
		} */
		if(c =='s'){
			Json saveObject=model.marshal();
			saveObject.save("map.json");
			System.out.println("File is saved");
		}
		if(c =='l'){
			Json j=Json.load("map.json");
			model.unmarshal(j);
			System.out.println("File loaded");
		}
		if(c=='e'){
      if(play){
				play=false;
				System.out.println("editing");
			} else{
				play=true;
				System.out.println("playing");
			}
		}
		if(c=='p'){
			if(put_pot){
				put_pot=false;
				System.out.println("you can put brick");
			}else{
				put_pot=true;
				System.out.println("you can put pot");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
       //System.out.println("ok");
			 if(play){
         Boomerang a=new Boomerang(model.link.x+(model.link.w)/2, model.link.y+(model.link.h)/2);
				 a.boomerang_direction=model.link.link_direction;
		     model.sprites.add(a);
		   }
		   

    }
	}

	public void keyTyped(KeyEvent e)
	{
	}

	void update()
	{
	  model.link.savePrevLocation();
		if(keyRight) {
			model.link.x+=4;
			model.link.link_direction='r';
			if(model.link.image==model.link.link_images[10]){
				model.link.image=model.link.link_images[11];
			}else if(model.link.image==model.link.link_images[11]){
				model.link.image=model.link.link_images[12];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[12]){
				model.link.image=model.link.link_images[13];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[13]){
				model.link.image=model.link.link_images[14];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[14]){
				model.link.image=model.link.link_images[10];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else{
				model.link.image=model.link.link_images[10];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}
		}
		if(keyLeft) {
			model.link.x-=4;
			model.link.link_direction='l';
			if(model.link.image==model.link.link_images[5]){
				model.link.image=model.link.link_images[6];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[6]){
				model.link.image=model.link.link_images[7];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[7]){
				model.link.image=model.link.link_images[8];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[8]){
				model.link.image=model.link.link_images[9];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[9]){
				model.link.image=model.link.link_images[5];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else{
				model.link.image=model.link.link_images[5];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}

		}
		if(keyDown) {
			model.link.y+=4;
			model.link.link_direction='d';
			if(model.link.image==model.link.link_images[0]){
				model.link.image=model.link.link_images[1];
				//model.link.height=.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[1]){
				model.link.image=model.link.link_images[2];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[2]){
				model.link.image=model.link.link_images[3];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[3]){
				model.link.image=model.link.link_images[4];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[4]){
				model.link.image=model.link.link_images[0];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else{
				model.link.image=model.link.link_images[0];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}
		}
		if(keyUp) {
			model.link.y-=4;
			model.link.link_direction='u';
      if(model.link.image==model.link.link_images[15]){
				model.link.image=model.link.link_images[16];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[16]){
				model.link.image=model.link.link_images[17];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[17]){
				model.link.image=model.link.link_images[18];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[18]){
				model.link.image=model.link.link_images[19];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else if(model.link.image==model.link.link_images[19]){
				model.link.image=model.link.link_images[15];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}else{
				model.link.image=model.link.link_images[15];
				//model.link.height=model.link.image.getHeight();
				//model.link.width=model.link.image.getWidth();
			}
	  }
	 
}
}

