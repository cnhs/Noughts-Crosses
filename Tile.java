import java.awt.*;

import javax.swing.*;

public class Tile extends JButton{
	
	private char symbol;
	
	Tile(char s){
		this.symbol = s;
		this.setText(""+symbol);
		this.setFocusable(false);
		this.setBorder(null);
		this.setFont(new Font("Forte", Font.PLAIN, 60));
		this.setForeground(Color.BLACK);
		this.setBackground(Color.red);
		//this.setContentAreaFilled(false);
		
	}
	
	public void setSymbol(char setter) {
		symbol = setter;
		this.setText(""+symbol);
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void clear() {
		symbol = ' ';
		this.setText("" +symbol);
	}

}
