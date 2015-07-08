package com.capgemini.pokerHands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompareHands {

	public static void main(String[] args) throws FileNotFoundException {
		List<String> hands = new ArrayList<String>();
		File file = new File("poker.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine()){
			hands.add(sc.nextLine());
		}
		int firstPlayerWins = 0;
		int secondPlayerWins = 0;
		int ties = 0;
		
		
		for(int i = 0; i < hands.size(); i++){
			String p1 = hands.get(i).substring(0, 14);
			String p2 = hands.get(i).substring(15, hands.get(i).length());
			Hand h1 = new Hand(p1);
			Hand h2 = new Hand(p2);
 			
			int winner = h1.compareTo(h2);
			
			if(winner == 1){
				System.out.println("1st player wins");
				firstPlayerWins++;
			} else if(winner == -1){
				System.out.println("2nd player wins");
				secondPlayerWins++;
			} if(winner == 0){
				System.out.println("tie");
				ties++;
			}
			System.out.println();
		}
		System.out.println("1st player wins: " + firstPlayerWins);
		System.out.println("2nd player wins: " + secondPlayerWins);
		System.out.println("ties: " + ties);
		
		
	}
}
