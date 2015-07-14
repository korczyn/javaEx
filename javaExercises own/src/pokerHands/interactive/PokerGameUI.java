package pokerHands.interactive;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PokerGameUI extends JFrame {
	PokerGame pg;
	Button p1Cards;
	Label p2Cards;
	
	public PokerGameUI() {
		pg = new PokerGame();
		initUI();
	}

	public final void initUI() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(3, 6));
		String[] buttons = { "P1a", "P1b", "P1c", "P1d", "P1e", "click", 
							 " ", " ", " ", " ", " ", " ", 
							 "P2a", "P2b", "P2c", "P2d", "P2e", "click", 
							 "half", "all", " ", " ", " ", " "
							 };
		final Label p1HandRank = new Label();
		final Label result = new Label();
		final Label p2HandRank = new Label();
		final Button startButton = new Button("Start");
		final Button dealButton = new Button("DEAL");
		dealButton.setEnabled(false);
		final JLabel[] p2Cards = new JLabel[5];
		final Button[] p1Cards = new Button[5];
		final Button allButton = new Button("ALL IN");
		final Button halfButton = new Button("HALF");
		
		for (int i = 0; i < p2Cards.length; i++) {
			p2Cards[i] = new JLabel("");
			panel.add(p2Cards[i]);
		}
		panel.add(p2HandRank);
		
		for (int i = 0; i < p1Cards.length; i++) {
			final Button b = new Button("p1");
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					b.setLabel(pg.changeCard(pg.c1, b.getLabel()));
					pg.h1 = new Hand(pg.c1);
					p1HandRank.setText(pg.h1.res);
					b.setEnabled(false);
				}
			});
			p1Cards[i] = b;
			panel.add(p1Cards[i]);
		}
		
		dealButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pg.h1 = new Hand(pg.c1);
				for (int i = 0; i < p2Cards.length; i++) {
					p2Cards[i].setIcon(null);
					p2Cards[i].setText(String.valueOf(pg.c2[i].getRank()) + String.valueOf(pg.c2[i].getSuit()));
				}
				p2HandRank.setText("P2: " + pg.h2.res);
				int res = pg.h1.compareTo(pg.h2);
				if(res == 1){
					result.setText("P1 win");
				} else {
					result.setText("P2 win");
				}
				
				dealButton.setEnabled(false);
				startButton.setEnabled(true);
			}
		});
		
		panel.add(dealButton);
		panel.add(allButton);
		panel.add(halfButton);
		
		panel.add(p1HandRank);
		panel.add(result);
		panel.add(new Label(""));
		
		
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText("");
				p2HandRank.setText("Player 2");
				pg.setUpHands();
				p1HandRank.setText(pg.h1.res);
				for (int i = 0; i < p1Cards.length; i++) {
					p1Cards[i].setLabel(String.valueOf(pg.c1[i].getRank()) + String.valueOf(pg.c1[i].getSuit()));
				}
				for (int j = 0; j < p1Cards.length; j++) {
					ImageIcon ii = new ImageIcon("AC.png");
					p2Cards[j].setText("");
					p2Cards[j].setIcon(ii);
					p1Cards[j].setEnabled(true);
				}
				startButton.setEnabled(false);
				dealButton.setEnabled(true);
			}
		});
		panel.add(startButton);
		
		

		add(panel);
		setTitle("test");
		setSize(750, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PokerGameUI pgui = new PokerGameUI();
				pgui.setVisible(true);
			}
		});
	}
}
