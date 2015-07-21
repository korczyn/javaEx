package com.capgemini.gol;
import java.util.List;

public class Cell {
	private List<Integer> coords;
	private int aliveNeighbours;
	private boolean isAlive;
	private List<Cell> neighbours;
	
	public Cell(List<Integer> coords){
		this.coords = coords;
	}
	
	public List<Integer> getCoords(){
		return coords;
	}
	
	public void setNeighboursList(List<Cell> neighbours){
		this.neighbours = neighbours;
	}
	
	public List<Cell> getNeighboursList(){
		return neighbours;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	public void kill(){
		isAlive = false;
	}
	
	public void ressurect(){
		isAlive = true;
	}
	
	public int getAliveNeighbours(){
		return aliveNeighbours;
	}
	
	public void countAliveNeighbours(){
		aliveNeighbours = 0;
		for (Cell cell : neighbours) {
			if(cell.isAlive)
				aliveNeighbours++;
		}
	}
	
	public void printInfoAboutCell(){
		System.out.println("coords " + coords);
		System.out.println("#neighbours " + neighbours.size());
		System.out.println("isAlive " + isAlive);
		System.out.println("alive neighbours " + getAliveNeighbours());
		System.out.println();
	}
	
}
