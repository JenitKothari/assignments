package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.aurionpro.model.Book;
import com.aurionpro.model.BookAuthorComparator;
import com.aurionpro.model.BookTitleComparator;

import java.util.Scanner;

public class BookApplicationTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//List<Book> books = new ArrayList<Book>();
		List<Book> availableBooks = new ArrayList<Book>();
		List<Book> issuedBooks = new ArrayList<Book>();
		int countBook=0;
		int choice = 0;
		while(choice!=7)
		{
			printMenu();
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				countBook++;
				Book book = createBook(scanner,countBook);
				//books.add(book);
				availableBooks.add(book);
				break;
			case 2:
				issueBook(scanner,availableBooks,issuedBooks);
				break;
			case 3:
				System.out.println("Available Books:");
				display(availableBooks);
				break;
			case 4:
				System.out.println("Issued Books:");
				display(issuedBooks);
				break;
			case 5:
				returnBook(scanner,availableBooks,issuedBooks);
				break;
			case 6:
				sortBook(scanner,availableBooks);
				break;
			case 7:
				System.out.println("Exiting.");
				break;
			default:
				System.out.println("Enter valid choice.");
			}
		}

	}

	private static void sortBook(Scanner scanner, List<Book> availableBooks) {
		System.out.println("Enter choice:");
		System.out.println("1=Ascending order of Author");
		System.out.println("2=Descending order of Title");
		int choiceOfSort = scanner.nextInt();
		if(choiceOfSort==1)
		{
			Collections.sort(availableBooks,new BookAuthorComparator());
			return;
		}
		if(choiceOfSort==2)
		{
			Collections.sort(availableBooks,new BookTitleComparator());
			return;
		}
		System.out.println("Enter valid choice.");
		return;
	}

	private static void returnBook(Scanner scanner, List<Book> availableBooks, List<Book> issuedBooks) {
		System.out.println("Enter the Book Id to be returned.");
		int bookId = scanner.nextInt();
		int index = getBookIdIndex(bookId,issuedBooks);
		if(index==-1)
		{
			System.out.println("Book ID: "+bookId+" was not issued");
			return;
		}
		Book book = issuedBooks.get(index);
		book.setIssued(false);
		
		availableBooks.add(book);
		issuedBooks.remove(index);
		System.out.println("Book Id: "+bookId+" successfully returned.");	
	}

	private static void display(List<Book> books) {
		for(Book book:books)
		{
			System.out.println(book.toString());
		}
	}

	private static void issueBook(Scanner scanner, List<Book> availableBooks, List<Book> issuedBooks) {
		System.out.println("Enter the Book Id to be issued.");
		int bookId = scanner.nextInt();
		int index = getBookIdIndex(bookId,availableBooks);
		if(index==-1)
		{
			System.out.println("Book ID: "+bookId+" not available");
			return;
		}
		Book book = availableBooks.get(index);
		book.setIssued(true);
		issuedBooks.add(book);
		availableBooks.remove(index);
		System.out.println("Book Id: "+bookId+" successfully issued.");
	}

	private static int getBookIdIndex(int bookId, List<Book> books) {
		
		for(int i=0; i<books.size(); i++)
		{
			if(books.get(i).getBookId()==bookId)
				return i;
		}
		return -1;
	}

	private static Book createBook(Scanner scanner,int countBook) {
		
		int bookId = countBook;
		System.out.println("Enter book title");
		
		//Here scanner.nextline() doesnt work
		
		String title = scanner.next();
		System.out.println("Enter book author");
		String author = scanner.next();
		
		Book book = new Book(bookId,title,author);
		return book;
	}

	public static void printMenu()
	{
		System.out.println("Menu:");
		System.out.println("1. Add a new book");
		System.out.println("2. Issue a book by ID");
		System.out.println("3. Display all available book");
		System.out.println("4. Display all issued book");
		System.out.println("5. return a book");
		System.out.println("6. Sort Books");
		System.out.println("7. Exit");
	}
}
