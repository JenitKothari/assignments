package com.aurionpro.model;

public class Cell {

	private boolean isMarked;
	private MarkType mark;
	private int row;
	private int column;
	public Cell(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		this.isMarked=false;
	}
	public boolean isMarked() {
		return isMarked;
	}
	public MarkType getMark() {
		return mark;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}
	public void setMark(MarkType mark) {
		this.setMarked(true);
		this.mark = mark;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	
}
