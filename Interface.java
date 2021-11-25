import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;


public class Interface extends JPanel{

	private GamePanel game = new GamePanel();
	
	
	public Interface() {
		
		this.setLayout(new BorderLayout());
		this.add(game, BorderLayout.CENTER);
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
}
