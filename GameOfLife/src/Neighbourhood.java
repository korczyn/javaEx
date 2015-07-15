import java.util.ArrayList;
import java.util.List;

public class Neighbourhood {

	public static boolean checkNeighbours2D(int size, int x, int y) {
		return x < size && y < size && x >= 0 && y >= 0;
	}

	public static boolean checkNeighbours3D(int size, int x, int y, int z) {
		return x < size && y < size && z < size && x >= 0 && y >= 0 && z >= 0;
	}

	public static Cell getCellByCoords(String coords) {
		for (int i = 0; i < Game.board.size(); i++) {
			if (Game.board.get(i).getCoords().equals(coords)) {
				return Game.board.get(i);
			}
		}
		return null;
	}

	public static List<Cell> setNeighbours2D(Cell c) {
		List<Cell> neighbours = new ArrayList<Cell>();
		String[] tmp_coords = c.getCoords().split(" ");
		int x = Integer.parseInt(tmp_coords[0]);
		int y = Integer.parseInt(tmp_coords[1]);

		int tmp_x = x - 1;
		int tmp_y = y - 1;
		if (checkNeighbours2D(Game.size, tmp_x, tmp_y))
			neighbours.add(getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y)));

		tmp_x = x - 1;
		tmp_y = y;
		if (checkNeighbours2D(Game.size, tmp_x, tmp_y))
			neighbours.add(getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y)));

		tmp_x = x - 1;
		tmp_y = y + 1;
		if (checkNeighbours2D(Game.size, tmp_x, tmp_y))
			neighbours.add(getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y)));

		tmp_x = x;
		tmp_y = y - 1;
		if (checkNeighbours2D(Game.size, tmp_x, tmp_y))
			neighbours.add(getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y)));

		tmp_x = x;
		tmp_y = y + 1;
		if (checkNeighbours2D(Game.size, tmp_x, tmp_y))
			neighbours.add(getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y)));

		tmp_x = x + 1;
		tmp_y = y - 1;
		if (checkNeighbours2D(Game.size, tmp_x, tmp_y))
			neighbours.add(getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y)));

		tmp_x = x + 1;
		tmp_y = y;
		if (checkNeighbours2D(Game.size, tmp_x, tmp_y))
			neighbours.add(getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y)));

		tmp_x = x + 1;
		tmp_y = y + 1;
		if (checkNeighbours2D(Game.size, tmp_x, tmp_y))
			neighbours.add(getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y)));

		return neighbours;

	}

	public static List<Cell> setNeighbours3D(Cell c) {
		List<Cell> neighbours = new ArrayList<Cell>();
		String[] tmp_coords = c.getCoords().split(" ");
		int x = Integer.parseInt(tmp_coords[0]);
		int y = Integer.parseInt(tmp_coords[1]);
		int z = Integer.parseInt(tmp_coords[2]);

		int tmp_x = x;
		int tmp_y = y;
		int tmp_z = z;

		// tmp_z = z - 1
		tmp_x = x - 1;
		tmp_y = y - 1;
		tmp_z = z - 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x - 1;
		tmp_y = y;
		tmp_z = z - 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x - 1;
		tmp_y = y + 1;
		tmp_z = z - 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x;
		tmp_y = y - 1;
		tmp_z = z - 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x;
		tmp_y = y;
		tmp_z = z - 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x;
		tmp_y = y + 1;
		tmp_z = z - 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x + 1;
		tmp_y = y - 1;
		tmp_z = z - 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x + 1;
		tmp_y = y;
		tmp_z = z - 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x + 1;
		tmp_y = y + 1;
		tmp_z = z - 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		// tmp_z = z
		tmp_x = x - 1;
		tmp_y = y - 1;
		tmp_z = z;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x - 1;
		tmp_y = y;
		tmp_z = z;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x - 1;
		tmp_y = y + 1;
		tmp_z = z;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x;
		tmp_y = y - 1;
		tmp_z = z;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x;
		tmp_y = y + 1;
		tmp_z = z;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x + 1;
		tmp_y = y - 1;
		tmp_z = z;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x + 1;
		tmp_y = y;
		tmp_z = z;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x + 1;
		tmp_y = y + 1;
		tmp_z = z;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		// tmp_z = z + 1
		tmp_x = x - 1;
		tmp_y = y - 1;
		tmp_z = z + 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x - 1;
		tmp_y = y;
		tmp_z = z + 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x - 1;
		tmp_y = y + 1;
		tmp_z = z + 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x;
		tmp_y = y - 1;
		tmp_z = z + 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x;
		tmp_y = y;
		tmp_z = z + 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x;
		tmp_y = y + 1;
		tmp_z = z + 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x + 1;
		tmp_y = y - 1;
		tmp_z = z + 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x + 1;
		tmp_y = y;
		tmp_z = z + 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		tmp_x = x + 1;
		tmp_y = y + 1;
		tmp_z = z + 1;
		if (checkNeighbours3D(Game.size, tmp_x, tmp_y, tmp_z))
			neighbours.add(
					getCellByCoords(String.valueOf(tmp_x) + " " + String.valueOf(tmp_y) + " " + String.valueOf(tmp_z)));

		return neighbours;

	}
}
