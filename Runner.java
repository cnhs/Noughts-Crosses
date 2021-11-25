
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class Runner extends JFrame{
	
	public static void Main(String[] args) {
		
		
		// Creates the window
		JFrame window = new JFrame(); 
		
		//  Creates the clock
		Interface clocky = new Interface();
		window.setContentPane(clocky);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(clocky.getWidth(),clocky.getHeight());
		//window.setSize(900,900);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
		//window.setMinimumSize(new Dimension (500, 300));
	}

}