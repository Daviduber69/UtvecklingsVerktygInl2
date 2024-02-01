package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import utilities.GenderType;

import java.time.LocalDate;

public class LoanTest {

    //VG
    @Test
    public void testDueDate() {
        Customer customer = new Customer("Lord", "David", "Henriksson",
                "Gatan 42", "073030330",
                "david@david.com", 1,
                GenderType.MALE);
        Book testBook = new Book(69, "Kebabboken",
                "David", "133769", "Matlagning", 420);
        Loan loan = new Loan(1, customer, testBook);

        assertEquals(loan.getDueDate(),LocalDate.now().plusDays(14));
    }
}