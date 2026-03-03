import java.util.ArrayList;

public class FinanceManager {

    private ArrayList<Expense> expenses;
    private double income;

    public FinanceManager() {
        expenses = new ArrayList<>();
    }

    public void addExpense(double amount) {
        Expense expense = new Expense(amount);
        expenses.add(expense);
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double calculateTotalExpenses() {
        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount();
        }

        return total;
    }

    public double calculateSavings() {
        return income - calculateTotalExpenses();
    }

    public String evaluateFinancialStatus() {

        double savings = calculateSavings();
        double percentage = (savings / income) * 100;

        if (percentage >= 30) {
            return "Excellent financial management";
        } else if (percentage >= 10) {
            return "Moderate financial situation";
        } else {
            return "Financial risk - Reduce expenses";
        }
    }
}