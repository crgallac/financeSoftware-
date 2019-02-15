package Controller;

public class ExpenseView {
    private ExpenseData expenseData;

    public ExpenseView(ExpenseData expenseData){
        this.expenseData=expenseData;
    }

    public void printExpenseView(){
        System.out.println("NOT DONE!");//this is where the data in model will be printed to JTable in UI window, will work on it when table in UI is finished
    }
}
