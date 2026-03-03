import java.util.Scanner;

public class Main {

public static void slowPrint(String text, int delay) {
    
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {


        
        Scanner input = new Scanner(System.in);
        FinanceManager manager = new FinanceManager();
        
        slowPrint("\n----------------- Welcome to Personal Finance Tracker! -----------------\n", 50);

        System.out.println("Enter your monthly income:");
        double income = input.nextDouble();
        manager.setIncome(income);
        
        System.out.println("How many expenses do you want to enter?");
        int numberOfExpenses = input.nextInt();

        for (int i = 1; i <= numberOfExpenses; i++) {
            System.out.println("Enter expense " + i + ":");
            double expenseAmount = input.nextDouble();
            manager.addExpense(expenseAmount);
        }

        double totalExpenses = manager.calculateTotalExpenses();
        double savings = manager.calculateSavings();
        String evaluation = manager.evaluateFinancialStatus();

        slowPrint("\n----------------- Financial Summary -----------------\n", 50);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + savings);
        System.out.println("Evaluation: " + evaluation + "\n");

        input.close();
    }
}