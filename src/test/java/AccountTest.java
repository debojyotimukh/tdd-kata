import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"DM_DEFAULT_ENCODING", "DM_DEFAULT_ENCODING"})
public class AccountTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void testEmptyPrintStatement() {
        String expected = "DATE\t\t|\t\tAMOUNT\t\t|\t\tBALANCE\n";
        Account account = new Account();
        account.printStatement();
        Assertions.assertEquals(expected, outStream.toString());
    }

    @Test
    public void testDeposit() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String expected = "DATE\t\t|\t\tAMOUNT\t\t|\t\tBALANCE\n" + //
                date + "\t\t|\t\t100.00\t\t|\t\t100.00\n";
        Account account = new Account();
        account.deposit(100);
        account.printStatement();
        Assertions.assertEquals(expected, outStream.toString());
    }

    @Test
    public void testTwoDeposits() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String expected = "DATE\t\t|\t\tAMOUNT\t\t|\t\tBALANCE\n" + //
                date + "\t\t|\t\t100.00\t\t|\t\t100.00\n" + //
                date + "\t\t|\t\t20.00\t\t|\t\t120.00\n";
        Account account = new Account();
        account.deposit(100);
        account.deposit(20);
        account.printStatement();
        Assertions.assertEquals(expected, outStream.toString());
    }

    @Test
    public void testDepositThenWithdraw() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String expected = "DATE\t\t|\t\tAMOUNT\t\t|\t\tBALANCE\n" + //
                date + "\t\t|\t\t100.00\t\t|\t\t100.00\n" + //
                date + "\t\t|\t\t-20.00\t\t|\t\t80.00\n";
        Account account = new Account();
        account.deposit(100);
        account.withdraw(20);
        account.printStatement();
        Assertions.assertEquals(expected, outStream.toString());
    }

    @AfterEach
    public void tearUp() {
        System.setOut(originalOut);
    }
}
