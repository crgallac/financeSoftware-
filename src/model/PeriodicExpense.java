package model;

public class PeriodicExpense extends Bill implements Expenses{
    private ExpenseType expenseType;
    public PeriodicExpense() {
        this.expenseType = ExpenseType.BILL;
    }
    @Override
    public CompositeExpenses toCompositeExpenses() {
        throw new ClassCastException("Invalid Cast");
    }
}
