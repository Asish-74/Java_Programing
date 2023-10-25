import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double amount;
    String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}

class ExpenseTracker {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private Scanner inputScanner = new Scanner(System.in);

    public void addExpense() {
        System.out.print("Enter expense description: ");
        String description = inputScanner.nextLine();

        double amount = 0;
        boolean validAmount = false;
        while (!validAmount) {
            try {
                System.out.print("Enter expense amount: ");
                amount = Double.parseDouble(inputScanner.nextLine());
                validAmount = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric amount.");
            }
        }

        System.out.print("Enter expense category: ");
        String category = inputScanner.nextLine();

        expenses.add(new Expense(description, amount, category));
        System.out.println("Expense added successfully!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            System.out.println("Expense List:");
            for (Expense expense : expenses) {
                System.out.println("Description: " + expense.description);
                System.out.println("Amount: " + expense.amount);
                System.out.println("Category: " + expense.category);
                System.out.println("---------------");
            }
        }
    }

    public void viewExpenseSummaries() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to summarize.");
        } else {
            // Implement your expense summaries logic here, e.g., total expenses by category
            System.out.println("Expense Summaries:");
            // You can calculate and display total expenses for each category.
            // For simplicity, let's just display the total expenses for now.
            double totalExpenses = 0;
            for (Expense expense : expenses) {
                totalExpenses += expense.amount;
            }
            System.out.println("Total Expenses: " + totalExpenses);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Expense Summaries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = inputScanner.nextInt();
            inputScanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    tracker.addExpense();
                    break;
                case 2:
                    tracker.viewExpenses();
                    break;
                case 3:
                    tracker.viewExpenseSummaries();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
