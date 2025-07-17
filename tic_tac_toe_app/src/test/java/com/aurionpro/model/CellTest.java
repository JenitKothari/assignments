package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {

	private Cell cell;
	
	@BeforeEach
	void init()
	{
		cell = new Cell(0,0);
	}
	
	@Test
	void testIsMarked() {
		assertEquals(false, cell.isMarked());
	}

	@Test
	void testSetMark() {
		cell.setMark(MarkType.X);
		assertEquals(MarkType.X, cell.getMark());
		assertEquals(true, cell.isMarked());
	}

}
