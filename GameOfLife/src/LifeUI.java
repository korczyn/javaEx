import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class LifeUI extends JFrame {

	Game g;
	static int cycle = 0;

	public LifeUI() {
		g = new Game();
		g.init();
		initUI();
	}

	public final void initUI() {
		final ImageIcon aliveColor = new ImageIcon("blue.jpg");
		final ImageIcon deadColor = new ImageIcon("white.jpg");

		final JButton nextButton = new JButton("NEXT GENERATION");
		final JButton randomizeBoardButton = new JButton("RANDOMIZE START");
		final JButton clearButton = new JButton("CLEAR THE BOARD");
		final JLabel[] cells = new JLabel[g.size * g.size];
		JLabel infoLabel = new JLabel("<html>Press R to randomize start or make your own by clicking labels (LMP to resurrect, RMP to kill)<br>S - start/stop simulation <br> C - clear the board <br> Right Arrow - next generation ");
		JPanel gui = new JPanel(new BorderLayout());
		JPanel boardPanel = new JPanel();
		JPanel userPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JPanel infoPanel = new JPanel();
		
		gui.add(boardPanel);
		gui.add(userPanel, BorderLayout.SOUTH);
		userPanel.setLayout(new BorderLayout());
		userPanel.add(infoPanel, BorderLayout.NORTH);
		userPanel.add(buttonsPanel, BorderLayout.SOUTH);
		boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		boardPanel.setLayout(new GridLayout(g.size + 1, g.size, 2, 2));
		
		infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		infoPanel.setLayout(new FlowLayout());
		infoPanel.add(infoLabel);
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonsPanel.setLayout(new FlowLayout());
		int t = (g.size/2) - 1;

		for (int i = 0; i < cells.length; i++) {
			final int index = i;
			cells[i] = new JLabel();
			ImageIcon ii = deadColor;
			cells[i].setIcon(ii);
			cells[i].addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						ImageIcon ii = aliveColor;
						cells[index].setIcon(ii);
						g.board.get(index).ressurect();
					}
					if (e.getButton() == MouseEvent.BUTTON2) {
						nextButton.doClick();
					}
					if (e.getButton() == MouseEvent.BUTTON3) {
						ImageIcon ii = deadColor;
						cells[index].setIcon(ii);
						g.board.get(index).kill();
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
			boardPanel.add(cells[i]);
		}

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				g.calculateNextGeneration();
				for (int i = 0; i < g.board.size(); i++) {
					if (!g.board.get(i).isAlive()) {
						ImageIcon ii = deadColor;
						cells[i].setIcon(ii);
					} else {
						ImageIcon ii = aliveColor;
						cells[i].setIcon(ii);
					}
				}
				cycle++;
				setTitle("Game of Life cycle " + cycle);
			}
		});

		randomizeBoardButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Random r = new Random();
				for (int i = 0; i < g.board.size() / 2; i++) {
					int ran = r.nextInt(g.board.size());
					g.board.get(ran).ressurect();
				}

				for (int i = 0; i < g.board.size(); i++) {
					if (!g.board.get(i).isAlive()) {
						ImageIcon ii = deadColor;
						cells[i].setIcon(ii);
					} else {
						ImageIcon ii = aliveColor;
						cells[i].setIcon(ii);
					}
				}
			}
		});

		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < g.board.size(); i++) {
					g.board.get(i).kill();
					ImageIcon ii = deadColor;
					cells[i].setIcon(ii);
					cycle = 0;
					setTitle("Game of life");
				}

			}
		});

		buttonsPanel.add(nextButton);
		buttonsPanel.add(randomizeBoardButton);
		buttonsPanel.add(clearButton);
		
		buttonsPanel.addKeyListener(new KeyAdapter() {
			Timer timer = new Timer(100, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					nextButton.doClick();

				}
			});

			@Override
			public void keyPressed(KeyEvent k) {
				switch (k.getKeyCode()) {
				case KeyEvent.VK_R:
					randomizeBoardButton.doClick();
					break;
				case KeyEvent.VK_RIGHT:
					nextButton.doClick();
					break;
				case KeyEvent.VK_C:
					clearButton.doClick();
					break;
				case KeyEvent.VK_S:
					if (timer.isRunning()) {
						timer.stop();
					} else {
						timer.start();
					}
					break;
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
				}
			}
		});
		add(gui);
		buttonsPanel.setFocusable(true);
		buttonsPanel.requestFocusInWindow();
		// panel.setBackground(ColorUIResource.decode("#BADA55"));
		setTitle("Game of life");
		setSize(1000, 1000);
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
