import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LifeUI extends JFrame{

	Game g;
	static int cycle = 0;
	public LifeUI(){
		g = new Game();
		initUI();
	}
	
	public final void initUI(){
		final Button nextButton = new Button("NEXT");
		final Button initButton = new Button("INIT");
		final JLabel[] cells = new JLabel[g.size*g.size];
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(g.size+1, g.size, 2, 2));
		
		for (int i = 0; i < cells.length; i++) {
			cells[i] = new JLabel();
			ImageIcon ii = new ImageIcon("white.jpg");
			cells[i].setIcon(ii);
			panel.add(cells[i]);
		}

		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				g.calculateNextGeneration();
				for(int i = 0; i < g.board.size(); i++){
					if(!g.board.get(i).isAlive()){
						ImageIcon ii = new ImageIcon("white.jpg");
						cells[i].setIcon(ii);
					} else {
						ImageIcon ii = new ImageIcon("black.jpg");
						cells[i].setIcon(ii);
					}
				}
				cycle++;
				setTitle("Game of Life cycle " + cycle);
			}
		});
		
		initButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				g.init();
				
				Random r = new Random();
				for (int i = 0; i < g.board.size() / 2; i++) {
					int ran = r.nextInt(g.board.size());
					g.board.get(ran).ressurect();
				}
				
				for(int i = 0; i < g.board.size(); i++){
					if(!g.board.get(i).isAlive()){
						ImageIcon ii = new ImageIcon("white.jpg");
						cells[i].setIcon(ii);
					} else {
						ImageIcon ii = new ImageIcon("black.jpg");
						cells[i].setIcon(ii);
					}
				}
			}
		});
		
		panel.add(nextButton);
		panel.add(initButton);
		add(panel);

        setTitle("Game of life");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                LifeUI ex = new LifeUI();
                ex.setVisible(true);
            }
        });
    }
	
}
