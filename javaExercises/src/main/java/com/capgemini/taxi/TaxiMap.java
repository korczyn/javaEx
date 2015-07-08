package com.capgemini.taxi;

import java.util.Random;

public class TaxiMap {

	public static void main(String[] args){
		
		String[][] map = new String[100][100];
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				map[i][j] = ".";
			}
		}
		
		Random r = new Random();
		
		for(int i = 0; i < 100; i++){
			map[r.nextInt(100)][r.nextInt(100)] = "T";
		}
		map[r.nextInt(100)][r.nextInt(100)] = "C";
		
		
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				if(map[i][j] == "C"){
					System.err.print(map[i][j]);
				} else {
					System.out.print(map[i][j]);
				}
			}
			System.out.println();
		}
		
		
	}
	
}
