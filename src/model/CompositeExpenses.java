package model;

import java.util.ArrayList;
import java.util.Observable;

public class CompositeExpenses  extends Observable implements Expenses{
    private MainExpenseList expenseList;
    private String expenseName;
    private ExpenseType expenseType;

    public CompositeExpenses() {
        expenseList = new MainExpenseList();
        this.expenseType = ExpenseType.COMPOSITE;
    }
    public int size(){
        return expenseList.getSize();
    }
    public void add(Expenses expense){
        this.expenseList.add(expense);
        this.setChanged();
        this.notifyObservers(this);
    }

    public void setByRow(int rowId,Expenses expense){
        this.expenseList.setByRow(rowId,expense);
        this.setChanged();
        this.notifyObservers(this);
    }
    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
        this.setChanged();
        this.notifyObservers(this);
    }
    /* Sets the payment status
     * @param  paymentStatus true if paid false if unpaid
     * @return void
     * set row by row
     */
    public void setPaid(boolean paymentStatus){
        for (int i = 0; i < expenseList.getSize(); i++) {
            expenseList.getByRow(i).setPaid(paymentStatus);
        }
        this.setChanged();
        this.notifyObservers(this);
    }
    public MainExpenseList getSubList(){
        return this.expenseList;
    }

    public Expenses getByRow(int rowId){
        return this.expenseList.getByRow(rowId);
    }


    public void deleteByRow(int rowId){
        this.expenseList.deleteByRow(rowId);
        this.setChanged();
        this.notifyObservers(this);
    }
    /* Gets the total amount expense
     * from sum up the list of sub items
     * overwrite getAmount method
     * @return the total amount of the expense
     */
    public double getAmount(){
        double sum=0;
        for (int i = 0; i < expenseList.getSize(); i++) {
            sum+=expenseList.getByRow(i).getAmount();
        }

            return sum;
    }

    @Override
    public void setAmount(double amount) {
        //override a useless method, a Composite Expenses can't write total amount.
    }

    /* Gets the total expense PaymentStatus
     * from AND the list of sub items
     * overwrite getPaymentStatus method
     * @return the sum of the PaymentStatus
     * if one is not paid, it is not paid
     */
    public boolean getPaymentStatus(){
        boolean sumStatus = true;
        for (int i = 0; i < expenseList.getSize(); i++) {
            sumStatus&=expenseList.getByRow(i).getPaymentStatus();
        }
        return sumStatus;
    }

    @Override
    public CompositeExpenses toCompositeExpenses() {
        return this;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }
}
