package Controller;

public class MarkPaid {
    private int[] rowIDList;
    private ExpenseData expenseData;

    public MarkPaid(int[] rowIDList, ExpenseData expenseData) {
        this.rowIDList = rowIDList;
        this.expenseData = expenseData;
    }

    //will mark all the selected(passed for an array of int) as Paid
    public ExpenseData marked() {
        for (int i = 0; i < rowIDList.length; i++) {
            int current = rowIDList[i];//get index
            Expense currentExpense=expenseData.getByRow(current);//get Expense unit from int
            currentExpense.setPaid(true);//set the Paid boolean of that Expense unit to paid
            expenseData.setByRow(current,currentExpense);//put it back to the data list
        }

        return this.expenseData; //give the data list back to controller
    }

}
