/*
    Name Chihiro Asanoma
		Date 3/28/2022
		Assignment 5
		This file implements Game class.
*/
import javax.swing.JFrame;
import java.awt.Toolkit;


public class Game extends JFrame
{
	static Model model;
	Controller controller;
	static View view;
	public Game()
	{
		model = new Model();
		controller = new Controller(model);
		view = new View(controller,model);
		view.addMouseListener(controller);
		this.setTitle("Assignment4");
		this.setSize(700, 500);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(controller);
	}
	public void run()
{
	while(true)
	{
		controller.update();
		model.update();
		view.repaint(); // Indirectly calls View.paintComponent
		Toolkit.getDefaultToolkit().sync(); // Updates screen

		// Go to sleep for 50 miliseconds
		try
		{
			Thread.sleep(40);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}

	public static void main(String[] args)
	{
		Game g = new Game();
		Json j=Json.load("map.json");
		model.unmarshal(j);
		System.out.println("File loaded & playing");
		g.run();
	}
}
