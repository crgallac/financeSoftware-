package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;


/**
 * The Expense List class stores the relevant data for the finance tracking program. The expense list is observed by the main window view.
 * @version     1
 * @since       1
 */
public class MainExpenseList extends Observable{

    private ArrayList<Expenses> expenseList;

    public MainExpenseList() {

        expenseList = new ArrayList<Expenses>();
    }


    /* Gets the list of expenses
     * @return the list of the expenses
     */
    public ArrayList<Expenses> getExpenseList(){

        return this.expenseList;
    }

    /* Gets an individual expense by the specified row
     * @param rowId the row within the list
     * @return the individual atomic expense located within the list
     */
    public Expenses getByRow(int rowId){
        return expenseList.get(rowId);
    }



    /* Sets an expense into the list at a specified row location
     * @param rowId the row within the list to place the expense
     * @param expense the expense to place within the list
     */
    public void setByRow(int rowId,Expenses expense){
        this.expenseList.set(rowId,expense);
        this.setChanged();
        this.notifyObservers(this);
    }

    /* Deletes an expense from the list
     * @param rowId the row which to delete from the list
     */
    public void deleteByRow(int rowId){
        this.expenseList.remove(rowId);
        this.setChanged();
        this.notifyObservers(this);
    }

    /* Adds an expense to the end of the list
     * @param expense the expense to add to the end of the list
     */
    public void add(Expenses expense){
        this.expenseList.add(expense);
        this.setChanged();
        this.notifyObservers(this);
    }

    /* Gets the size of the expense list
     * @return the size of the expense list
     */
    public int getSize(){
        return this.expenseList.size();
    }
    /* Prints the contents of the list
     * @return void
     */




}
