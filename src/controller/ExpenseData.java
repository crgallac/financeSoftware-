package controller;

import java.util.ArrayList;
import java.util.List;

public class ExpenseData {
    private List<Expense> expenseList;


    public ExpenseData(){
        expenseList = new ArrayList<Expense>();
    }

    public List<Expense> getList() {
        return expenseList;
    }

    public void setList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
//for select button, return full information of the unit of expense selected
    public Expense getByRow(int rowId){
        return this.expenseList.get(rowId);
    }
//for editor button, changing content of a unit of expense by row index
    public void setByRow(int rowId,Expense expense){
        this.expenseList.set(rowId,expense);
    }
//for delete button, remove expense by row index
    public void deleteByRow(int rowId){
        this.expenseList.remove(rowId);
    }
//for add button, add a unit unit of expense
    public void add(Expense expense){
        this.expenseList.add(expense);
    }

    public int getSize(){
        return this.expenseList.size();
    }
}

