package model;

public class SingleExpense extends Purchase implements Expenses{
    private ExpenseType expenseType;
    public SingleExpense() {
        this.expenseType = ExpenseType.PURCHASE;
    }

    @Override
    public CompositeExpenses toCompositeExpenses() {
        throw new ClassCastException("Invalid Cast");
    }
}
