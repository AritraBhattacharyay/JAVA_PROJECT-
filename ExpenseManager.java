import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// Main Class
public class ExpenseManager {

    public static void main(String[] args) {

        ArrayList<Expense> expenses = new ArrayList<>();

        Expense e1 = new Expense(500, "Travel",
                LocalDate.now());

        Expense e2 = new FoodExpense(250,
                LocalDate.now());

        expenses.add(e1);
        expenses.add(e2);

        System.out.println("Expense Details:");

        for (Expense e : expenses) {
            e.displayExpense();
        }

        System.out.println("\nObject Details:");
        System.out.println(e1);
        System.out.println(e2);
    }
}

// Base Class
class Expense {

    public static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final double amount;
    private final String category;
    private final LocalDate date;

    public Expense(double amount, String category, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void displayExpense() {
        System.out.println(date + " | " + category + " | " + amount);
    }

    @Override
    public String toString() {
        return "Expense [Amount=" + amount +
                ", Category=" + category +
                ", Date=" + date + "]";
    }
}

// Child Class
class FoodExpense extends Expense {

    public FoodExpense(double amount, LocalDate date) {
        super(amount, "Food", date);
    }

    @Override
    public void displayExpense() {
        System.out.println("Food Expense -> "
                + getDate() + " | "
                + getAmount());
    }
}