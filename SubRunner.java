import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SubRunner extends JFrame implements ActionListener{
	
	private JFrame window;
	private MenuInterface menu;
	
	SubRunner(){
		
		window = new JFrame();
		// Creates the menu
		menu = new MenuInterface();
		menu.getNoughtsJButton().addActionListener(this);
		menu.getConnectJButton().addActionListener(this);
		menu.getReturnButton().addActionListener(this);
		
		window.setContentPane(menu);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(900,900);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == menu.getNoughtsJButton()) {
			
			System.out.println(window.getContentPane());
			window.setContentPane(menu.getNoughtsGame());
			System.out.println(window.getContentPane());
			SwingUtilities.updateComponentTreeUI(window);
		}
		
		if(e.getSource() == menu.getConnectJButton()) {
			window.setContentPane(menu.getConnectGame());
			SwingUtilities.updateComponentTreeUI(window);
		}
		
		
		if (e.getSource()== menu.getReturnButton()) {
			window.setContentPane(menu);
				System.out.println("HHHHHHHHH");
		}
	}

}
