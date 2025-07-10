package com.aurionpro.model;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {

	public int compare(Book book1, Book book2) {
		return book1.getAuthor().compareToIgnoreCase(book2.getAuthor());
	}

}
