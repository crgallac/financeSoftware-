package model;

import java.util.ArrayList;
import java.util.Observable;

public class CompositeExpenses  extends Observable implements Expenses{
    private ExpenseList expenseSubList;
    private String expenseName;
    private ExpenseType expenseType;
 

    public CompositeExpenses() {
    	expenseSubList = new ExpenseList();
        this.expenseType = ExpenseType.COMPOSITE;
    }
    public Integer size(){
        return expenseSubList.getSize();
    }
    public void add(Expenses expense){
        this.expenseSubList.add(expense);
        this.setChanged();
        this.notifyObservers(this);
    }

    public void setByRow(int rowId,Expenses expense){
        this.expenseSubList.setByRow(rowId,expense);
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
    public void setPaid(Boolean paymentStatus){
        for (int i = 0; i < expenseSubList.getSize(); i++) {
        	expenseSubList.getByRow(i).setPaid(paymentStatus);
        }
        
        this.setChanged();
        this.notifyObservers(this);
    }
    public ExpenseList getSubList(){
        return this.expenseSubList;
    }

    public Expenses getByRow(int rowId){
        return this.expenseSubList.getByRow(rowId);
    }


    public void deleteByRow(int rowId){
        this.expenseSubList.deleteByRow(rowId);
        this.setChanged();
        this.notifyObservers(this);
    }
    /* Gets the total amount expense
     * from sum up the list of sub items
     * overwrite getAmount method
     * @return the total amount of the expense
     */
    public Double getAmount(){
        double sum=0;
        for (int i = 0; i < expenseSubList.getSize(); i++) {
            sum+=expenseSubList.getByRow(i).getAmount();
        }

            return sum;
    }

    @Override
    public void setAmount(Double amount) {
        //override a useless method, a Composite Expenses can't write total amount.
    }

    /* Gets the total expense PaymentStatus
     * from AND the list of sub items
     * overwrite getPaymentStatus method
     * @return the sum of the PaymentStatus
     * if one is not paid, it is not paid
     */
    public Boolean getPaymentStatus(){
        boolean sumStatus = true;
        for (int i = 0; i < expenseSubList.getSize(); i++) {
            sumStatus&=expenseSubList.getByRow(i).getPaymentStatus();
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
