import java.util.ArrayList;
import java.util.List;

public class Game {

	public static int size = 51;
	public static List<Cell> board;

	public static List<Cell> createCells() {
		List<Cell> list = new ArrayList<Cell>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Cell c = new Cell(String.valueOf(i) + " " + String.valueOf(j));
				list.add(c);
			}
		}
		return list;
	}

	public static void init() {
		board = createCells();
		for (Cell c : board) {
			c.setNeighboursList(Neighbourhood.setNeighbours2D(c));
		}
	}

	static void changeState(Cell c) {
		boolean isAlive = c.isAlive();
		int aliveNeighbours = c.getAliveNeighbours();

		if (isAlive && aliveNeighbours < 2) {
			c.kill();
		} else if (isAlive && (aliveNeighbours == 2 || aliveNeighbours == 3)) {

		} else if (isAlive && aliveNeighbours > 3) {
			c.kill();
		} else if (!isAlive && aliveNeighbours == 3) {
			c.ressurect();
		}
	}

	public static void calculateNextGeneration() {

		for (Cell cell : board) {
			cell.countAliveNeighbours();
		}
		for (Cell cell : board) {
			changeState(cell);
		}

	}
}
