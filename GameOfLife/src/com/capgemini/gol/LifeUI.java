package com.capgemini.gol;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class LifeUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Game g;
	Timer timer;
	public static JLabel[] cells;
	File fileToLoad;
	static ImageIcon aliveColor;
	static ImageIcon deadColor;
	static int cycle = 0;
	boolean leftMouseDown = false;
	boolean rightMouseDown = false;

	public static enum Figure {
		glider, square, fountain, gospel_gun
	};

	public Figure figure;

	public LifeUI() {
		Game.init();
		initUI();
	}

	public final void chooseFigure() {
		final JFrame jf = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(LifeUI.Figure.values().length, 1));
		Figure[] f = LifeUI.Figure.values();
		for (int i = 0; i < LifeUI.Figure.values().length; i++) {
			final int index = i;
			JLabel label = new JLabel(String.valueOf(Figure.values()[i]));
			label.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					figure = Figure.values()[index];
					jf.setVisible(false);
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
			panel.add(label);
		}
		jf.setSize(75, 50 * Figure.values().length);
		revalidate();
		repaint();
		jf.add(panel);
		jf.add(panel);
		jf.setVisible(true);

	}

	private void updateBoard() {
		for (int i = 0; i < cells.length; i++) {
			if (Game.board.get(i).isAlive()) {
				cells[i].setIcon(aliveColor);
			} else {
				cells[i].setIcon(deadColor);
			}
		}
	}

	private void chooseFileToLoad() {
		final JFrame jf = new JFrame();

		File folder = new File("save");
		final File[] listOfFiles = folder.listFiles();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(listOfFiles.length, 1));
		for (int i = 0; i < listOfFiles.length; i++) {
			final int index = i;
			JLabel j = new JLabel(listOfFiles[i].getName());
			j.setFocusable(false);
			j.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

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
					fileToLoad = new File(listOfFiles[index].getAbsolutePath());
					System.out.println(fileToLoad.getAbsolutePath());
					loadState(fileToLoad);
					jf.setVisible(false);
				}
			});
			panel.add(j);
		}
		jf.setSize(100, listOfFiles.length * 30);
		revalidate();
		repaint();
		jf.add(panel);
		jf.setVisible(true);
	}

	public void loadState(File file) {
		try {
			killEmAll();
			Scanner sc = new Scanner(file);
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			while ((line = br.readLine()) != null) {
				List<String> t = Arrays.asList(line.split(" "));
				int x = Integer.parseInt(t.get(0));
				int y = Integer.parseInt(t.get(1));
				Cell c = Neighbourhood.getCellByCoords(x, y);
				c.ressurect();
			}

			updateBoard();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void killEmAll() {
		for (Cell cell : Game.board) {
			cell.kill();
		}
	}

	private void saveState() {
		final JFrame jf = new JFrame();
		JPanel panel = new JPanel();
		final JTextField textField = new JTextField("");
		final JButton button = new JButton("Save");
		panel.setLayout(new FlowLayout());
		textField.setPreferredSize(new Dimension(150, 25));
		panel.add(textField);
		panel.add(button);

		jf.add(panel);
		jf.setSize(250, 75);
		jf.setVisible(true);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("save//" + Game.size + "_" + textField.getText() + ".txt");
					FileWriter fw;
					fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					for (Cell cell : Game.board) {
						if (cell.isAlive()) {
							bw.write(cell.getCoords().get(0) + " " + cell.getCoords().get(1));
							bw.newLine();
						}
					}
					bw.close();
					jf.setVisible(false);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) {
				switch (k.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					button.doClick();
					break;
				case KeyEvent.VK_ESCAPE:
					jf.setVisible(false);
				}
			}
		});

	}

	public final void initUI() {
		aliveColor = new ImageIcon("black.jpg");
		deadColor = new ImageIcon("white.jpg");
		final String[] colors = new String[] { " ", "Red", "Black", "White", "Blue", "Green", "Gold" };

		final JButton nextButton = new JButton("NEXT GENERATION");
		final JButton randomizeBoardButton = new JButton("RANDOMIZE START");
		final JButton clearButton = new JButton("CLEAR THE BOARD");
		final JButton saveButton = new JButton("Save");
		final JButton loadButton = new JButton("Load");
		cells = new JLabel[Game.size * Game.size];
		JLabel infoLabel = new JLabel(
				"<html>Press R to randomize start or make your own by clicking labels (LMP to resurrect, RMP to kill)<br>S - start/stop simulation <br> C - clear the board <br> Right Arrow - next generation ");
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
		boardPanel.setLayout(new GridLayout(Game.size + 1, Game.size));

		infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		infoPanel.setLayout(new FlowLayout());
		infoPanel.add(infoLabel);
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonsPanel.setLayout(new FlowLayout());

		for (int i = 0; i < cells.length; i++) {
			final int index = i;
			cells[i] = new JLabel();
			ImageIcon ii = deadColor;
			cells[i].setIcon(ii);
			cells[i].addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					leftMouseDown = false;
					rightMouseDown = false;
				}

				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						leftMouseDown = true;
						ImageIcon ii = aliveColor;
						cells[index].setIcon(ii);
						Game.board.get(index).ressurect();
					}
					if (e.getButton() == MouseEvent.BUTTON2) {
						Figures f = new Figures();
						f.printFigure(Game.board.get(index), figure);
					}
					if (e.getButton() == MouseEvent.BUTTON3) {
						rightMouseDown = true;
						ImageIcon ii = deadColor;
						cells[index].setIcon(ii);
						Game.board.get(index).kill();
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					System.out.println(
							Game.board.get(index).getCoords().get(0) + " " + Game.board.get(index).getCoords().get(1));
					if (leftMouseDown) {
						ImageIcon ii = aliveColor;
						cells[index].setIcon(ii);
						Game.board.get(index).ressurect();
					}
					if (rightMouseDown) {
						ImageIcon ii = deadColor;
						cells[index].setIcon(ii);
						Game.board.get(index).kill();
					}
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
				Game.calculateNextGeneration();
				for (int i = 0; i < Game.board.size(); i++) {
					if (!Game.board.get(i).isAlive()) {
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
				for (int i = 0; i < Game.board.size() / 2; i++) {
					int ran = r.nextInt(Game.board.size());
					Game.board.get(ran).ressurect();
				}

				for (int i = 0; i < Game.board.size(); i++) {
					if (!Game.board.get(i).isAlive()) {
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
				for (int i = 0; i < Game.board.size(); i++) {
					Game.board.get(i).kill();
					cycle = 0;
					setTitle("Game of life");
				}
				updateBoard();
			}
		});

		nextButton.setFocusable(false);
		randomizeBoardButton.setFocusable(false);
		clearButton.setFocusable(false);
		saveButton.setFocusable(false);
		buttonsPanel.add(nextButton);
		buttonsPanel.add(randomizeBoardButton);
		buttonsPanel.add(clearButton);

		JLabel l1 = new JLabel("Alive Col: ");
		buttonsPanel.add(l1);
		final JComboBox<String> aliveColorCB = new JComboBox<>(colors);
		aliveColorCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String t = (String) aliveColorCB.getSelectedItem();
				aliveColor = new ImageIcon(t + ".jpg");
				updateBoard();
			}
		});
		aliveColorCB.setFocusable(false);
		buttonsPanel.add(aliveColorCB);

		JLabel l2 = new JLabel("Dead Col: ");
		buttonsPanel.add(l2);
		final JComboBox<String> deadColorCB = new JComboBox<>(colors);
		deadColorCB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String t = (String) deadColorCB.getSelectedItem();
				deadColor = new ImageIcon(t + ".jpg");
				updateBoard();
			}
		});
		deadColorCB.setFocusable(false);
		buttonsPanel.add(deadColorCB);

		buttonsPanel.addKeyListener(new KeyAdapter() {
			Timer timer = new Timer(1, new ActionListener() {

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
				case KeyEvent.VK_1:
					saveState();
					break;
				case KeyEvent.VK_2:
					chooseFileToLoad();
					break;
				case KeyEvent.VK_3:
					chooseFigure();
					break;
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
				}
			}
		});
		add(gui);
		buttonsPanel.setFocusable(true);
		buttonsPanel.requestFocusInWindow();
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
