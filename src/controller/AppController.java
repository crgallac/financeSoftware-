package controller;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AppController{
    private ExpenseData expenseData;

    public AppController(ExpenseData expenseData){
        this.expenseData=expenseData;
    }
// This will return a JTable, and display all data from model in this JTable
    public void printExpenseView(){
        String[] columnNames = { "Name", "Price", "Type","Paid" };
        String[][] data = {};
        int size=expenseData.getSize();

        for (int i = 0; i < size; i++) {
            Expense current = expenseData.getByRow(i);
            data[i][0]=current.getName();// 1st column reserved for name
            data[i][1]=Double.toString(current.getPrice());// 2st column reserved for Price
            data[i][2]=current.getType();// 3st column reserved for Type
            if (current.getPaid()==true){//4st column reserved for paid
                data[i][3]="Paid";
            }
            else {
                data[i][3]="Unpaid";
            }
        }
        JTable jTable=new JTable(data, columnNames);
        JScrollPane sTable=new JScrollPane(jTable);
        JFrame table= new JFrame();
        table.add(sTable);
        table.setSize(500, 500);//will be changed according to UI configuration
        table.setVisible(true);

        /*

        Here it will call a method from UI, and write the table to the UI
        the table need to be passed is called "table"

         */
    }


    //need row index from UI
    public void markPaid(int rowID) {
        Expense currentExpense = this.expenseData.getByRow(rowID);//get Expense unit from int
        currentExpense.setPaid(true);//set the Paid boolean of that Expense unit to paid
        this.expenseData.setByRow(rowID, currentExpense);//put it back to the data list
        this.printExpenseView();//update to view
    }
    //need row index from UI
    public void unMarkPaid(int rowID) {
        Expense currentExpense = this.expenseData.getByRow(rowID);//get Expense unit from int
        currentExpense.setPaid(false);//set the Paid boolean of that Expense unit to unpaid
        this.expenseData.setByRow(rowID, currentExpense);//put it back to the data list
        this.printExpenseView();//update to view
    }
    //for window 2, put all data together to form a unit of expense, then add it to the list
    public void add(String name,double price,String type,boolean paid){
        Expense expense=new Expense(name,price,type,paid);//create a new expense with all information from  window 2
        this.expenseData.add(expense);
        this.printExpenseView();//update to view
    }
    //need row index from UI
    public void edit(int rowID, String name,double price,String type,boolean paid){
        Expense expense=new Expense(name,price,type,paid);//create a new expense with all information from  window 2
        this.expenseData.setByRow(rowID,expense); //change it according to row index
        this.printExpenseView();//update to view
    }
    //need row index from UI
    public void delete(int rowID){
        this.expenseData.deleteByRow(rowID);
        this.printExpenseView();//update to view
    }
}