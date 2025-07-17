package com.aurionpro.model;

import java.util.Scanner;

public class Player {

	private static int index=0;
	private int playerId;
	private String playerName;
	private MarkType marker;
	
	public Player(String playerName) {
		super();
		this.playerId=index++;
		this.playerName = playerName;
		this.marker = playerId%2==0 ? MarkType.X : MarkType.O;
	}

	public int getPlayerId() {
		return playerId;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public MarkType getMarker() {
		return marker;
	}

	public void setMarker(MarkType marker) {
		this.marker = marker;
	}

	void playTurn(Scanner scanner, Board boardObject)
	{
		System.out.println("Enter row index");
		int row = scanner.nextInt();
		System.out.println("Enter column index");
		int column = scanner.nextInt();
		boolean isMarked = boardObject.board[row][column].isMarked();;
		while(isMarked)
		{
			System.out.println("Position : ["+row+"]["+column+"] already marked");
			System.out.println("Re-enter new indices:");
			System.out.println("Enter row index");
			row = scanner.nextInt();
			System.out.println("Enter column index");
			column = scanner.nextInt();
			isMarked = boardObject.board[row][column].isMarked();
		}
		boardObject.board[row][column].setMark(this.getMarker());
	}
}
