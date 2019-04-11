package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;


/**
 * The Expense List class stores the relevant data for the finance tracking program. The expense list is observed by the main window view.
 * @version     1
 * @since       1
 */
public class ExpenseList   extends Observable {

    private ArrayList<Expenses> expenseList;

    public ExpenseList() {

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

	 /* Prints the contents of the list  
	 * @return void
	 */
    public void printList(){
        
    	for (Expenses ex : expenseList) {
    		
    		System.out.print(ex.getExpenseType().toString() + ", "); 
    		System.out.print(ex.getExpenseName() + ", ");
    		System.out.print(ex.getAmount() + ", ");
    		System.out.print(ex.getPaymentStatus()+ ", ");
    		System.out.println(ex.size().toString());
    		
    		
    		if(ex.getExpenseType().equals(ExpenseType.COMPOSITE)) {
    			
    			ExpenseList subList = ex.toCompositeExpenses().getSubList(); 
    			for(Expenses subex : subList.getExpenseList()) {
    				
    				System.out.print("\t");
    				System.out.print(ex.getExpenseType().toString() + ", "); 
    	    		System.out.print(subex.getExpenseName() + ", ");
    	    		System.out.print(subex.getAmount() + ", ");
    	    		System.out.print(subex.getPaymentStatus() + ", ");
    	    		System.out.println(subex.size().toString());
    			}
    			
    		}
    		
    		
    	}
    	System.out.println(); 
    
    }

    /* Prints the contents of the list
     * @return void
     */

	 /* Prints the contents of the list  
	 * @return void
	 */
    public void save(String fileName){
    	
    	Path path = Paths.get(fileName);
    	
    	try {
            
            File file = path.toFile(); 
            if (!file.exists()) {
               file.createNewFile();
            } 
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            
         	for (Expenses ex : expenseList) {
        		
         		 bw.write(ex.getExpenseType().toString() + ",");
         		 bw.write(ex.getExpenseName() + ",");
         		 bw.write(ex.getAmount() + ",");
         		 bw.write(ex.getPaymentStatus().toString() + ",");
         		 bw.write(ex.size().toString());
         		 bw.newLine();
         		
        		
        		if(ex.getExpenseType().equals(ExpenseType.COMPOSITE)) {
        			
        			ExpenseList subList = ex.toCompositeExpenses().getSubList(); 
        			for(Expenses subex : subList.getExpenseList()) {
        				
        				 bw.write(subex.getExpenseType().toString() + ",");
        				 bw.write(subex.getExpenseName() + ",");
        				 bw.write(subex.getAmount() + ",");
        				 bw.write(subex.getPaymentStatus().toString()+ ",");
        				 bw.write(subex.size().toString());
        				 bw.newLine();
        			}
        			
        		}
        		
        		
        	}
         	bw.newLine();
            
            
           
            bw.close();
            
          
         } catch (IOException e) {
            e.printStackTrace();
         } 
    	
    	
   
    
    }



    /* Prints the contents of the list
     * @return void
     */

	 /* Prints the contents of the list  
	 * @return void
	 */
    public void read(String fileName){
    	
    	
    	
    	try {
            
    		BufferedReader br = new BufferedReader(new FileReader(fileName)); 
    		  
    		  expenseList = new ArrayList<Expenses>();
    		  
    		  String st; 
    		  
    		  while ((st = br.readLine()) != null) {
//    		    System.out.println(st); 
    		    
    			String[] sa = st.split(",");
    			
    			Expenses exTmp; 
    			
    			switch(sa[0]) {
    			
	    				
	    			case "PURCHASE":
	    				
	    				exTmp = new SingleExpense();  
	    				exTmp.setExpenseName(sa[1]);
	    				exTmp.setAmount(Double.parseDouble(sa[2]));
	    				exTmp.setPaid(Boolean.parseBoolean(sa[3]));
	    				
	    				expenseList.add(exTmp);
	    				
	    				break; 
	    				
	    			case "BILL": 
	    				
	    				exTmp = new PeriodicExpense();  
	    				exTmp.setExpenseName(sa[1]);
	    				exTmp.setAmount(Double.parseDouble(sa[2]));
	    				exTmp.setPaid(Boolean.parseBoolean(sa[3]));
	    				
	    				expenseList.add(exTmp);
	    				
	    				break; 
	    				
	    			case "COMPOSITE":
	    				
	    				exTmp = new CompositeExpenses();  
	    				exTmp.setExpenseName(sa[1]);
	    				
	    				Integer sz = Integer.parseInt(sa[4]);
	    				
	    				
	    					for(int i = 0; i< sz; i++) {
	    						st = br.readLine(); 
	    						
	    						Expenses exTmp1; 
	    						
	    						String[] sa1 = st.split(",");
	    		    			
	    		    			
	    		    			switch(sa1[0]) {
	    		    			
	    			    				
	    			    			case "PURCHASE":
	    			    				
	    			    				exTmp1 = new SingleExpense();  
	    			    				exTmp1.setExpenseName(sa[1]);
	    			    				exTmp1.setAmount(Double.parseDouble(sa[2]));
	    			    				exTmp1.setPaid(Boolean.parseBoolean(sa[3]));
	    			    				
	    			    				exTmp.toCompositeExpenses().add(exTmp1);
	    			    				
	    			    				break; 
	    			    				
	    			    			case "BILL": 
	    			    				
	    			    				exTmp1 = new PeriodicExpense();  
	    			    				exTmp1.setExpenseName(sa[1]);
	    			    				exTmp1.setAmount(Double.parseDouble(sa[2]));
	    			    				exTmp1.setPaid(Boolean.parseBoolean(sa[3]));
	    			    				
	    			    				exTmp.toCompositeExpenses().add(exTmp1);
	    			    				
	    			    				break; 
	    						
	    						
	    		    			}
	    						
	    					}
	    				
	    				
	    				exTmp.setAmount(exTmp.getAmount());
	    				exTmp.setPaid(exTmp.getPaymentStatus());
	    				
	    				expenseList.add(exTmp);
	    				
	    				break;
	    				
	    			default:
    				
    			}
    				
    			
    			
    			
    			
    		  
    		  } 
          
    	        this.setChanged();
    	        this.notifyObservers(this);
    		  
         } catch (IOException e) {
            e.printStackTrace();
         } 
    	
 
    	
    }
    

}
