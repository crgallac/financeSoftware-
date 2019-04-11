package model;

public class SingleExpense  implements AtomicExpense{
	
	private Double amount = 0.0; 
	private String expenseName = ""; 
	private Boolean paymentStatus = false; 	
    private ExpenseType expenseType;
    
   
    
    public SingleExpense() {
        this.expenseType = ExpenseType.PURCHASE;
    }


	@Override
	public void setAmount(Double amount) {
		this.amount = amount; 
		
	}

	@Override
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName; 
		
	}

	@Override
	public void setPaid(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus; 
		
	}

	@Override
	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType; 
		
	}

	@Override
	public Double getAmount() {
		// TODO Auto-generated method stub
		return this.amount;
	}

	@Override
	public String getExpenseName() {
		// TODO Auto-generated method stub
		return this.expenseName;
	}

	@Override
	public ExpenseType getExpenseType() {
		// TODO Auto-generated method stub
		return this.expenseType;
	}

	@Override
	public Boolean getPaymentStatus() {
		// TODO Auto-generated method stub
		return this.paymentStatus;
	}


	@Override
	public CompositeExpenses toCompositeExpenses() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
