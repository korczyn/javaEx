import static org.junit.Assert.*;

import org.junit.Test;

public class GoLTest {

	@Test
	public void testCornerCellShouldHave3Neighbours() {
		Game.board = Game.createCells();
		for (Cell c : Game.board) {
			c.setNeighboursList(Neighbourhood.setNeighbours2D(c));
		}
		Cell c = Neighbourhood.getCellByCoords("0 0");
		assertEquals(3, c.getNeighboursList().size());
	}

	@Test
	public void testBorderNotCornerCellShouldHave5Neighbours() {
		Game.board = Game.createCells();
		for (Cell c : Game.board) {
			c.setNeighboursList(Neighbourhood.setNeighbours2D(c));
		}
		Cell c = Neighbourhood.getCellByCoords("0 1");
		assertEquals(5, c.getNeighboursList().size());
	}

	@Test
	public void testInsideCellShouldHave8Neighbours() {
		Game.board = Game.createCells();
		for (Cell c : Game.board) {
			c.setNeighboursList(Neighbourhood.setNeighbours2D(c));
		}
		Cell c = Neighbourhood.getCellByCoords("1 1");
		assertEquals(8, c.getNeighboursList().size());
	}
}
