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
	
	@Test
	public void shouldReturnFalseIfAliveCellWithNoAliveNeighboursIsDeadInNextGen(){
		Game.init();
		Cell c = Neighbourhood.getCellByCoords("1 1");
		c.ressurect();
		Game.calculateNextGeneration();
		assertFalse(c.isAlive());
	}
	
	@Test
	public void shouldReturnFalseIfAliveCellWith1AliveNeighbourIsDeadInNextGen(){
		Game.init();
		Cell testedCell = Neighbourhood.getCellByCoords("1 1");
		testedCell.ressurect();
		Cell c = Neighbourhood.getCellByCoords("1 2");
		c.ressurect();
		Game.calculateNextGeneration();
		assertFalse(testedCell.isAlive());
	}

	@Test
	public void shouldReturnTrueIfAliveCellWith2AliveNeighbourIsAliveInNextGen(){
		Game.init();
		Cell testedCell = Neighbourhood.getCellByCoords("1 1");
		testedCell.ressurect();
		Cell c = Neighbourhood.getCellByCoords("1 2");
		c.ressurect();
		c = Neighbourhood.getCellByCoords("0 1");
		c.ressurect();
		Game.calculateNextGeneration();
		assertTrue(testedCell.isAlive());
	}

	@Test
	public void shouldReturnTrueIfAliveCellWith3AliveNeighbourIsAliveInNextGen(){
		Game.init();
		Cell testedCell = Neighbourhood.getCellByCoords("1 1");
		testedCell.ressurect();
		Cell c = Neighbourhood.getCellByCoords("1 2");
		c.ressurect();
		c = Neighbourhood.getCellByCoords("0 1");
		c.ressurect();
		c = Neighbourhood.getCellByCoords("1 0");
		c.ressurect();
		Game.calculateNextGeneration();
		assertTrue(testedCell.isAlive());
	}

	@Test
	public void shouldReturnFalseIfAliveCellWithMore3AliveNeighbourIsDeadInNextGen(){
		Game.init();
		Cell testedCell = Neighbourhood.getCellByCoords("1 1");
		testedCell.ressurect();
		Cell c = Neighbourhood.getCellByCoords("1 2");
		c.ressurect();
		c = Neighbourhood.getCellByCoords("0 1");
		c.ressurect();
		c = Neighbourhood.getCellByCoords("1 0");
		c.ressurect();
		c = Neighbourhood.getCellByCoords("2 1");
		c.ressurect();
		Game.calculateNextGeneration();
		assertFalse(testedCell.isAlive());
	}
	
	@Test
	public void shouldReturnTrueIfDeadCellWith3AliveNeighbourIsAliveInNextGen(){
		Game.init();
		Cell testedCell = Neighbourhood.getCellByCoords("1 1");
		Cell c = Neighbourhood.getCellByCoords("0 2");
		c.ressurect();
		c = Neighbourhood.getCellByCoords("1 2");
		c.ressurect();
		c = Neighbourhood.getCellByCoords("2 2");
		c.ressurect();
		Game.calculateNextGeneration();
		assertTrue(testedCell.isAlive());
	}
	
}
