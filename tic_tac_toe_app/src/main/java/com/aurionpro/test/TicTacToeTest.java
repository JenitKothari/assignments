package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Game;

public class TicTacToeTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Game game = new Game(scanner);
		game.startGame(scanner);
	}

}
