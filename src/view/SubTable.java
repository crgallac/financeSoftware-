package view;
import controller.AppController;
import model.CompositeExpenses;
import javax.swing.table.AbstractTableModel;

public class SubTable extends AbstractTableModel {
    private String[] columnNames = { "Name", "Price", "Type", "Paid" };
    private CompositeExpenses expenseTable;
    private AppController data;

    public SubTable(AppController data,int rowID) {
        if (rowID==-1){
            this.expenseTable=null;
        }
        else {
            this.expenseTable = data.getSub(rowID).toCompositeExpenses();
        }
    }
    @Override
    public int getRowCount() {
        int size;
        if (expenseTable==null){
            size=0;
        }
        else {
            size=expenseTable.size();
        }
        return size;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = expenseTable.getByRow(row).getExpenseName();
        }
        else if (col == 1) {
            temp = expenseTable.getByRow(row).getAmount();
        }
        else if (col == 2) {
            temp = expenseTable.getByRow(row).getExpenseType();
        }
        else if (col == 3) {
            temp = expenseTable.getByRow(row).getPaymentStatus();
        }
        return temp;
    }
    public void update(AppController data, int rowID) {
        this.expenseTable = data.getSub(rowID).toCompositeExpenses();
        this.fireTableDataChanged();

    }

    public String getColumnName(int col) {
        return columnNames[col];
    }


}

