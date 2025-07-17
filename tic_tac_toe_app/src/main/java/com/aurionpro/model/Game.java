package com.aurionpro.model;

import java.util.Scanner;

import javax.swing.border.Border;

public class Game {

	private Board boardObject;
	private Player players[];
	
	public Game(Scanner scanner) {
		this.players = new Player[2];
		this.boardObject = new Board();
		initialisePlayers(scanner);
	}

	private void initialisePlayers(Scanner scanner) {
		System.out.println("Enter player 1 name :");
		String player1Name = scanner.nextLine();
		System.out.println("Enter player 2 name :");
		String player2Name = scanner.nextLine();
		
		Player player1 = new Player(player1Name);
		Player player2 = new Player(player2Name);
		players[0] = player1;
		players[1] = player2;
	}
	
	public void startGame(Scanner scanner)
	{
		Player winner = null;
		boolean gameOver = false;
		for(int i=0; i<9; i++)
		{
			boardObject.printBoard();
			System.out.println("Player "+players[i%2].getPlayerName()+" turn:");
			players[i%2].playTurn(scanner,boardObject);
			gameOver = checkGameOver();
			if(gameOver)
			{
				boardObject.printBoard();
				winner = players[i%2];
				System.out.println(winner.getPlayerName()+" Won!");
				return;
			}
		}
		boardObject.printBoard();
		System.out.println("Game Draw");
	}
//	  0 1 2
//	0
//	1
//	2

	private boolean checkGameOver() {
		Cell[][] board = boardObject.board; 
		if(board[0][0].getMark()!=null && board[0][0].getMark()==board[0][1].getMark() && board[0][0].getMark()==board[0][2].getMark())
			return true;
		if(board[1][0].getMark()!=null && board[1][0].getMark()==board[1][1].getMark() && board[1][0].getMark()==board[1][2].getMark())
			return true;
		if(board[2][0].getMark()!=null && board[2][0].getMark()==board[2][1].getMark() && board[2][0].getMark()==board[2][2].getMark())
			return true;
		if(board[0][0].getMark()!=null && board[0][0].getMark()==board[1][0].getMark() && board[0][0].getMark()==board[2][0].getMark())	
			return true;
		if(board[0][1].getMark()!=null && board[0][1].getMark()==board[1][1].getMark() && board[0][1].getMark()==board[2][1].getMark())
			return true;
		if(board[0][2].getMark()!=null && board[0][2].getMark()==board[1][2].getMark() && board[0][2].getMark()==board[2][2].getMark())
			return true;
		if(board[0][0].getMark()!=null && board[0][0].getMark()==board[1][1].getMark() && board[0][0].getMark()==board[2][2].getMark())
			return true;
		if(board[0][2].getMark()!=null && board[0][2].getMark()==board[1][1].getMark() && board[0][2].getMark()==board[2][0].getMark())
			return true;
		return false;
	}
}
