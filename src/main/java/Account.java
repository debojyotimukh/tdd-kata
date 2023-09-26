import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {

    private static final String FORMAT = "%s\t\t|\t\t%.2f\t\t|\t\t%.2f%n";
    private final StringBuilder builder;

    private int currentBalance;

    Account() {
        this.builder = new StringBuilder();
        this.currentBalance = 0;
    }

    public void deposit(int amount) {
        this.currentBalance += amount;
        LocalDateTime localDateTime = LocalDateTime.now();
        builder.append(String.format(FORMAT, localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), (float) amount, (float) this.currentBalance));
    }

    public void withdraw(int amount) {
        this.currentBalance -= amount;
        LocalDateTime localDateTime = LocalDateTime.now();
        builder.append(String.format(FORMAT, localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), (float) amount * -1, (float) this.currentBalance));
    }

    public void printStatement() {
        System.out.println("DATE\t\t|\t\tAMOUNT\t\t|\t\tBALANCE");
        System.out.print(builder.toString());
    }
}
