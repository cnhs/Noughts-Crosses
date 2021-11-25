
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameRunner extends JPanel{
	
	
	
	private GamePanelConnect4 connect4;
	private GamePanel noughts;
	private JButton returnToMenu;
		
	GameRunner(char gameType){	
		
		
		this.setLayout(new BorderLayout());
		
		
		if (gameType == 'C'){
			connect4 = new GamePanelConnect4();
			this.add(connect4, BorderLayout.CENTER);
		}
		
		else if (gameType == 'N'){
			noughts = new GamePanel();
			this.add(noughts, BorderLayout.CENTER);
		}
		
		
	}
	
	
	
	

}













	
	
	
	
	
	
	
	
	
	
	