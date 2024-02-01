package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookCatalogTest {

    private BookCatalog bc;
    private Book book1;

    public BookCatalogTest() {
        bc = new BookCatalog();
         book1 = new Book(1, "Learning Java", "", "", "", 0);
        bc.addBook(book1);
    }

    //G
    //Jag la till egna böcker och kataloger i varje testmetod

    @Test
    public void testAddABook() {
        Book book = new Book(1, "An introduction to Java", "Matt Greencroft",
                "12345", "Anytown Branch", 400);

        BookCatalog bookCatalog = new BookCatalog();
        bookCatalog.addBook(book);
        assertEquals(book, bookCatalog.getBookArray()[0]);
    }


    //G
    @Test
    public void testFindBook() {
        Book book = new Book(1, "An introduction to Java", "Matt Greencroft",
                "12345", "Anytown Branch", 400);
        BookCatalog bookCatalog = new BookCatalog();
        bookCatalog.addBook(book);
        try {
            assertEquals(book, bookCatalog.findBook("An introduction to Java"));
        } catch (BookNotFoundException e) {
            System.err.println("Did not find it!");
            fail("Caught a BookNotFoundException!");
        }
    }

    //G
    @Test
    public void testFindBookIgnoringCase() {
        Book book = new Book(1, "An introduction to Java", "Matt Greencroft",
                "12345", "Anytown Branch", 400);
        BookCatalog bookCatalog = new BookCatalog();
        bookCatalog.addBook(book);
        try {
            assertEquals(book, bookCatalog.findBook("AN INTRODUCTION TO JAVA")); //capslock to test ignorecase
        } catch (BookNotFoundException e) {
            System.err.println("Did not find it!");
            fail("Caught a BookNotFoundException!");
        }
    }

    //G
    @Test
    public void testFindBookWithExtraSpaces() {
        Book book = new Book(1, "An introduction to Java", "Matt Greencroft",
                "12345", "Anytown Branch", 400);
        BookCatalog bookCatalog = new BookCatalog();
        bookCatalog.addBook(book);
        try {
            assertEquals(book, bookCatalog.findBook("     An introduction to Java        ")); //extra spaces
            // to test trim()
        } catch (BookNotFoundException e) {
            System.err.println("Did not find it!");
            fail("Caught a BookNotFoundException!");
        }
    }

    //VG
    // This test should throw BookNotFoundException in order to pass.
    @Test
    public void testFindBookThatDoesntExist() throws BookNotFoundException {
        Book testBook = new Book(69, "Kebabboken",
                "David", "133769", "Matlagning", 420);
        BookCatalog bookCatalog = new BookCatalog();
        bookCatalog.addBook(testBook);
        assertThrows(BookNotFoundException.class, () -> bookCatalog.findBook("Bok som ej finns"));
    }
}
