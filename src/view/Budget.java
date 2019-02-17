package view;


import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.JCheckBoxMenuItem;

import controller.ExpenseData;
import controller.Expense;
import controller.AppController;

public class Budget {
	
	private JFrame ExpenseList = new JFrame ("Expense Tracker");
	/**
	 * Create the application.
	 */
	public Budget() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ExpenseList = new JFrame();
		ExpenseList.getContentPane().setBackground(Color.PINK);
		ExpenseList.setBounds(100, 100, 450, 300);
		ExpenseList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ExpenseList.getContentPane().setLayout(null);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(24, 225, 117, 29);
		ExpenseList.getContentPane().add(btnAddItem);
		
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new AddFrame();
			}
		});
		
		JButton btnEditItem = new JButton("Edit Item");
		btnEditItem.setBounds(282, 225, 117, 29);
		ExpenseList.getContentPane().add(btnEditItem);
		
		btnEditItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new EditFrame();
			}
		});
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(153, 225, 117, 29);
		ExpenseList.getContentPane().add(btnDeleteItem);
		
		String[] columnNames = {"Expense", "Amount", "Category"};
		
//		Object[][] data = {
//				{"Cat Food", "1000", "Pets"},
//				{"Socks", "1000000", "Clothing"},
//				{"Coffee", "20", "Food"},
//				{"Rent", "10", "Rent"}
//		};
		
		ExpenseData.data = 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 17, 401, 196);
		ExpenseList.getContentPane().add(scrollPane);
		
		
		
		JTable table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder(new LineBorder(Color.WHITE));	
		table.setBackground(Color.PINK);
		//ExpenseList.getContentPane().add(new JScrollPane(table));
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (table.getSelectedRow() > -1) {
		            // print first column value from selected row
		            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
		        }
		    }
		});
		
		
		};
		
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Budget window = new Budget();
					window.ExpenseList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
	}

