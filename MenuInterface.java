import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.SwingUtilities;

public class MenuInterface  extends JPanel implements ActionListener{

	private JPanel gamePanel = new JPanel();
	private JButton noughtsStartButton;
	private JButton connectStartButton;
	private JLabel selectionLabel;
	private GameRunner game;
	private JButton returnToMenuButton;
	private boolean isMenu;
	private boolean isGame;
	
	MenuInterface(){
		
		isMenu = true;
		isGame = false;
		
		this.setLayout(new BorderLayout());
		
		gamePanel.setLayout(new GridLayout(1,2));
		
		
		returnToMenuButton = new JButton("Return");
		returnToMenuButton.setFont(new Font("Sans Serif",Font.BOLD,50));
		returnToMenuButton.setBackground(Color.BLACK);
		returnToMenuButton.setForeground(Color.WHITE);
		returnToMenuButton.setFocusable(false);
		returnToMenuButton.setBorder(null);
		returnToMenuButton.addActionListener(this);
		
		this.add(returnToMenuButton, BorderLayout.NORTH);
		
		
		
		//selectionLabel = new JLabel("Sen le  ct: ", SwingConstants.CENTER);
		//selectionLabel.setBackground(Color.BLACK);
		//selectionLabel.setForeground(Color.WHITE);
		//selectionLabel.setFont(new Font("Sans Serif",Font.BOLD,50));
		//
		//topPanel.add(selectionLabel, BorderLayout.NORTH);
		
		
		
		
		noughtsStartButton = new JButton("Noughts & Crosses");
		noughtsStartButton.setFont(new Font("Sans Serif",Font.BOLD,50));
		noughtsStartButton.setBackground(Color.BLACK);
		noughtsStartButton.setForeground(Color.WHITE);
		noughtsStartButton.setFocusable(false);
		noughtsStartButton.setBorder(null);
		noughtsStartButton.addActionListener(this);
		
		gamePanel.add(noughtsStartButton);
		
		
		connectStartButton = new JButton("Connect4");
		connectStartButton.setFont(new Font("Sans Serif",Font.BOLD,50));
		connectStartButton.setBackground(Color.BLACK);
		connectStartButton.setForeground(Color.WHITE);
		connectStartButton.setFocusable(false);
		connectStartButton.setBorder(null);
		connectStartButton.addActionListener(this);
		
		gamePanel.add(connectStartButton);
		
		this.add(gamePanel, BorderLayout.CENTER);
		
		//game = new GameRunner('N');
			
	}
	
	
	

//	public JButton getNoughtsJButton() {
//		return noughtsStartButton;
//	}
//	
//	public JButton getConnectJButton() {
//		return connectStartButton;
//	}
//	
//	public JButton getReturnButton() {
//		return returnToMenu;
//	}
	
	public GameRunner getNoughtsGame() {
		game = new GameRunner('N');
		return game;
	}
	
	public GameRunner getConnectGame() {
		game = new GameRunner('C');
		return game;
	}
	
	
	public void startGame(GameRunner game) {
		gamePanel.remove(noughtsStartButton);
		gamePanel.remove(connectStartButton);
		this.remove(gamePanel);
		this.add(game, BorderLayout.CENTER);
		//gamePanel.add(game);
		isMenu = false;
		isGame = true;
	}
	
	public void returnToMenu() {
		//gamePanel.remove(game);
		gamePanel.add(noughtsStartButton);
		gamePanel.add(connectStartButton);
		this.remove(game);
		this.add(gamePanel, BorderLayout.CENTER);
		isMenu = true;
		isGame = false;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == noughtsStartButton) {
			if (isMenu == true) {
				game = getNoughtsGame();
				startGame(game);
				SwingUtilities.updateComponentTreeUI(this);
			}
			
		}
		
		if (e.getSource() == connectStartButton) {
			if (isMenu == true) {
				game = getConnectGame();
				startGame(game);
				SwingUtilities.updateComponentTreeUI(this);
			}
			
		}
		
		if (e.getSource() == returnToMenuButton) {
			if (isGame == true) {
				returnToMenu();
				game = null;
				SwingUtilities.updateComponentTreeUI(this);
			}
			
		}
		
		
		
	}
	
		
	
}
