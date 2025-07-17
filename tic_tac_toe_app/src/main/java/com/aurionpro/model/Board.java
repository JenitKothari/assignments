package com.aurionpro.model;

public class Board {

	public Cell board[][] = new Cell[3][3];
	
	public Board() {
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				Cell cell = new Cell(i,j);
				board[i][j] = cell;
			}
		}
	}	
	
	public void printBoard()
	{
		for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            Cell cell = board[i][j];
	            if (cell.isMarked()) {
	                System.out.print(" " + getMarkSymbol(cell.getMark()) + " ");
	            } else {
	                System.out.print("   ");
	            }
	            if (j < 2) {
	                System.out.print("|");
	            }
	        }
	        System.out.println();
	        if (i < 2) {
	            System.out.println("---+---+---");
	        }
	    }
	}

	private char getMarkSymbol(MarkType mark) {
		if (mark == MarkType.X) {
	        return 'X';
	    } else if (mark == MarkType.O) {
	        return 'O';
	    }
	    return ' '; // default in case of null or unexpected value
	}
}
