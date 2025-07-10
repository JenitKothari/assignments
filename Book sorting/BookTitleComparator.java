package com.aurionpro.model;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {

	public int compare(Book book1, Book book2) {
		return book2.getTitle().compareToIgnoreCase(book1.getTitle());
	}

}
