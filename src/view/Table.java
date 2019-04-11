package view;
import controller.AppController;
import model.ExpenseType;
import model.AtomicExpense;
import model.Expenses;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

public class Table extends AbstractTableModel {
    private String[] columnNames = { "Name", "Price", "Type", "Paid" };
    private ArrayList<Expenses> expenseTable;
    private AppController data;


    public Table(AppController data) {
        this.expenseTable = data.getExpenseList().getExpenseList();
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
            temp = expenseTable.get(row).getExpenseName();
        }
        else if (col == 1) {
            temp = expenseTable.get(row).getAmount();
        }
        else if (col == 2) {
            temp = expenseTable.get(row).getExpenseType();
        }
        else if (col == 3) {
            temp = expenseTable.get(row).getPaymentStatus();
        }
        return temp;
    }
    public void update(AppController data) {
        this.expenseTable = data.getExpenseList().getExpenseList();
        this.fireTableDataChanged();

    }

    public Class getColumnClass(int col) {
        if (col == 0) {
            return String.class;
        }
        else if (col == 1) {
            return Double.class;
        }
        else if (col == 2) {
            return ExpenseType.class;
        }
        else {
            return boolean.class;
        }
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }



}

