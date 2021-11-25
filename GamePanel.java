import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements ActionListener{
	
	private int width = 3;
	private int height = 3;
	private int numOfTiles = width * height;
	private int numToWin = 3;
	private int inARow;
	private Tile[] tiles = new Tile[numOfTiles];
	private char turn = 'O';
	private char check = ' ';
	private char winner = ' ';
	private JLabel turnLabel;
	private JButton resetButton;
	private int wwidth = 900;
	private int wheight = 900;
	private int[] winTiles = new int[numToWin];
	
	

	public GamePanel(){

		
		this.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,2));
		
		turnLabel = new JLabel("Turn: " + this.getTurn(), SwingConstants.CENTER);
		turnLabel.setBackground(Color.BLACK);
		turnLabel.setForeground(Color.WHITE);
		turnLabel.setFont(new Font("Sans Serif",Font.BOLD,wwidth/18));
		topPanel.add(turnLabel);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Sans Serif",Font.BOLD,wwidth/18));
		resetButton.setBackground(Color.BLACK);
		resetButton.setForeground(Color.WHITE);
		resetButton.setFocusable(false);
		resetButton.setBorder(null);
		resetButton.addActionListener(this);
		topPanel.add(resetButton);
		topPanel.setBackground(Color.BLACK);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(height,width,5,5));
	
		
		// makes each of the items in the array a tile and it adds them to the layout and adds an action listener to each of them
		 for (int i=0; i<this.tiles.length; i++) {
			 this.tiles[i] = new Tile(' ');
			 buttonPanel.add(this.tiles[i]);
			 tiles[i].addActionListener(this);
			 tiles[i].setBackground(Color.yellow);
			 buttonPanel.setBackground(Color.BLACK);
			 tiles[i].setFont(new Font("Forte", Font.PLAIN, wwidth/12));
			 
		this.add(buttonPanel, BorderLayout.CENTER);
		this.add(topPanel, BorderLayout.NORTH);
		 }
		 
		 
		 
		 
		 
	}
	
	
	public int getWidth() {
		return wwidth;
	}
	
	public int getHeight() {
		return wheight;
	}
	
	
	public void reset() {
		
		for (Tile tile: tiles) {
			tile.setSymbol(' ');
		}
		
		turn = 'O';
		check = ' ';
		winner = ' ';
		turnLabel.setText("Turn: " + turn);
	}
	
	public char getTurn() {
		return turn;
	}
	
	public int tileLocator(int r, int c) {
		
		int loc;
		loc = (r)*width + (c);
		
		return loc;
	}
	
	private void notInARow() {
		inARow = 0;
		winTiles = new int[3];
	}
	
	private void yesInARow(int row, int col) {
		inARow +=1;
		winTiles[inARow-1] = tileLocator(row,col);
	}
	
	public char checkWinner() {
		
		// Noughts
		//char winner = ' ';
		check = 'O';
		
		for (int q=0; q<2; q++) {
			if (q==1) {
				check = 'X';
			}
			
			// Checks Rows
			
			
			for (int row=0; row<(height); row++ ){
				notInARow();
				
				if (winner == ' ') {
					for (int col=0; col<(width); col++ ){
						
						if (tiles[tileLocator(row,col)].getSymbol() == check) {
							yesInARow(row,col);
						//	winTiles+=(tileLocator(row,col));
						}
						
						else {
							notInARow();
						}
						
						if (inARow >= numToWin){
							winner = check;
							turnLabel.setText("Winner Winner: " + winner);
						}
						
						
					}
				}
			}
			
			notInARow();
			
			//Checks Columns
			
			for (int col=0; col<(width); col++ ){
				notInARow();
				
				if (winner == ' ') {
					for (int row=0; row<(width); row++ ){
						
						if (tiles[tileLocator(row,col)].getSymbol() == check) {
							yesInARow(row,col);
							
						}
						
						else {
							notInARow();
						}
						
						if (inARow >= numToWin){
							winner = check;
							turnLabel.setText("Winner Winner: " + winner);
						}
						
						
					}
				}
			}
			
			notInARow();
			
			// Checks negative (\) diagonals
			
			for (int row=0; row < (height-numToWin)+1; row++) {
				if (winner == ' ') {
					for (int col=0; col < (width-numToWin)+1; col++) {
						notInARow();
						if (tiles[tileLocator(row,col)].getSymbol() == check) {
							yesInARow(row,col);
							
							for (int d=1; d < numToWin; d++) {
								if (tiles[tileLocator(row+d,col+d)].getSymbol() == check) {
									yesInARow(row+d,col+d);
								}
								
								else {
									notInARow();
								}
								
								if (inARow >= numToWin){
									winner = check;
									turnLabel.setText("Winner Winner: " + winner);
								}
	
							}
						}
					}
				}
				
			}
			
			notInARow();
			
			for (int row=height-1; row > numToWin-2; row--) {
				if (winner == ' ') {
					for (int col=0; col < (width-numToWin)+1; col++) {
						notInARow();
						if (tiles[tileLocator(row,col)].getSymbol() == check) {
							yesInARow(row,col);
							System.out.println(inARow);
							
							for (int d=1; d < numToWin; d++) {
								System.out.println(inARow + " hi " + d);
								if (tiles[tileLocator(row-d,col+d)].getSymbol() == check) {
									yesInARow(row+d,col+d);
								}
								
								else {
									notInARow();
								}
								
								if (inARow >= numToWin){
									winner = check;
									turnLabel.setText("Winner Winner: " + winner);
								}
	
							}
						}
					}
				}
				
			}
			
			
			
			
			
			
		
		}
	
		System.out.println(winTiles);
		return winner;
		
	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		for (int i=0; i<tiles.length; i++) {
			if (check == ' '){
				if (e.getSource() == tiles[i]) {
					if (tiles[i].getSymbol() == ' '){
						tiles[i].setSymbol(turn);
						if (turn == 'X'){
							turn = 'O';
						}
						else {
							turn = 'X';
						}
						
						turnLabel.setText("Turn: "+turn);
						
						check = checkWinner();
						
					}
				}
			}
		}
		
		
		if (e.getSource() == resetButton) {
			this.reset();
		}	
	}
			
}
