/*
    Name Chihiro Asanoma
		Date 3/28/2022
		Assignment 5
		This file implements Model class.
*/
import java.util.ArrayList;
class Model
{
	//int turtle_x;
	//int turtle_y;
	int brick_x;
	int brick_y;
	//static ArrayList<Brick> bricks;
	static ArrayList<Sprite> sprites;
	//Brick brick;
	Link link;
	boolean collision;
	boolean collision2;
	//int dest_x;
	//int dest_y;


	Model()
	{
		//bricks=new ArrayList<Brick>();
		link=new Link(100,100);
		//brick=new Brick(-100,-100);
		sprites=new ArrayList<Sprite>();
		sprites.add(link);
		//Brick b = new Brick(400, 300);
		//bricks.add(b);
	}

	public void update()
	{
		// Move the turtle
		/*
		if(this.turtle_x < this.dest_x)
			this.turtle_x +=Math.min(4, this.dest_x - this.turtle_x);
		else if(this.turtle_x > this.dest_x)
			this.turtle_x -=Math.min(4, this.turtle_x - this.dest_x);
		if(this.turtle_y < this.dest_y)
			this.turtle_y += Math.min(4, this.dest_y - this.turtle_y);
		else if(this.turtle_y > this.dest_y)
			this.turtle_y -= Math.min(4, this.turtle_y - this.dest_y);
		*/
		//link.update();

		/*for(int i=0; i<sprites.size(); i++){
			sprites.get(i).update();
			if(sprites.get(i).isBrick() || sprites.get(i).isPot()){
			  collision=isThereACollision(link, sprites.get(i));
			  for(int n=0; n<sprites.size(); n++){
				if((sprites.get(n).isBoomerang() || sprites.get(n).isPot()) && (sprites.get(i).isBrick())){
					collision2=isThereACollision(sprites.get(n), sprites.get(i));
					if(collision2){
						sprites.remove(n);
					}
				}
			}

			if(collision){
				System.out.println("Collision");
				if(sprites.get(i).isBrick()){
				 link.getOutOfBrick((Brick)sprites.get(i));
				}
				if(sprites.get(i).isPot()){
					((Pot)sprites.get(i)).pot_direction=link.link_direction;

				}
				
			}
			}
			
		}
	  */

		for(int i=0; i<sprites.size(); i++) {
			sprites.get(i).update();
			if(sprites.get(i).isPot() && ((Pot)sprites.get(i)).broken_timer > 50) {
				sprites.remove(i);
				i--;
			}
			for(int n=0; n<sprites.size(); n++) {
				if(i!=n){
					collision = isThereACollision(sprites.get(i), sprites.get(n));
						if(collision) {
							//LINK COLLISIONS
							if(sprites.get(i).isLink()){
								if(sprites.get(n).isPot()){
									if(!((Pot)sprites.get(n)).broken && !((Pot)sprites.get(n)).moving){
                   ((Pot)sprites.get(n)).pot_direction=link.link_direction;
									 ((Pot)sprites.get(n)).moving = true;
									}
									else{
										link.getOutOfBrick((Pot)sprites.get(n));
									}
								}
								if(sprites.get(n).isBrick()){
                    link.getOutOfBrick((Brick)sprites.get(n));
								}
							}
						//BOOMERANG COLLISIONS
						if(sprites.get(i).isBoomerang()){
							if(sprites.get(n).isPot()){
								  ((Pot)sprites.get(n)).broken = true;
									
									sprites.remove(i);
									i--;

								}
							if(sprites.get(n).isBrick()){
									sprites.remove(i);
									i--;
								}
							}
						if(sprites.get(i).isPot()){
							if(sprites.get(n).isBrick()){
                ((Pot)sprites.get(i)).broken = true;
					      ((Pot)sprites.get(i)).pot_direction = ' ';
								
							}
						}
				}
			}
		}
		
		}
	}
	public boolean isThereACollision(Sprite l, Sprite b)
	{
     if(l.y+l.h<=b.y){
			 return false;
		 }
		 if(l.y>=b.y+b.h){
			 return false;
		 }
		 if(l.x+l.w<=b.x){
			 return false;
		 }
		 if(l.x>=b.x+b.w){
			 return false;
		 }
		 
		 return true;
	}

	/*public void setDestination(int x, int y)
	{
		//this.dest_x = x;
		//this.dest_y = y;
	}*/

	void unmarshal(Json ob){
		sprites=new ArrayList<Sprite>();
		sprites.add(link);
		Json tmpList=ob.get("Bricks");
		Json tmpListPot=ob.get("Pots");
		for(int n=0; n<tmpListPot.size(); n++){
			sprites.add(new Pot(tmpListPot.get(n)));
		}
		for(int i=0; i<tmpList.size(); i++){
			sprites.add(new Brick(tmpList.get(i)));
		}
		/*for(int n=0; n<tmpListPot.size(); n++){
			sprites.add(new Pot(tmpListPot.get(n)));
		}*/
		
	}
	Json marshal(){
		Json ob=Json.newObject();
		Json tmpList=Json.newList();
		Json tmpListPot=Json.newList();
		ob.add("Bricks",tmpList);
		ob.add("Pots", tmpListPot);
		for(int i=0; i<sprites.size(); i++){
			if(sprites.get(i).isBrick()){
			tmpList.add(((Brick)sprites.get(i)).marshal());
			}
			if(sprites.get(i).isPot()){
				tmpListPot.add(((Pot)sprites.get(i)).marshal());
			}
		}
		return ob;
	}
	

}