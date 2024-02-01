package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(1,"An introduction to Java","Matt Greencroft",
				"12345","Anytown Branch", 400);
		Book book2 = new Book(1,"An introduction to Java",
				"Matt Greencroft","12345","Anytown Branch", 400);
		assertEquals(book1,book2);
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		Book book1 = new Book(1,"An introduction to Java","Matt Greencroft",
				"12345","Anytown Branch", 400);
		Book book2 = new Book(2,"Better Java","Joe Le Blanc",
				"23456","Anytown Branch",150);

		assertNotEquals(book1,book2);
	}

}
