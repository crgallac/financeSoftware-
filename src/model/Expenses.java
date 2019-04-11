package model;

public interface Expenses {
    /* Sets the identifying name of the expense
     * @param  expenseName name of the expense
     * @return void
     */
    void setExpenseName(String expenseName);
    /* Gets the name of the expense
     *
     * @return name of the expense
     */
    String getExpenseName();
    /* Sets the payment status
     * @param  paymentStatus true if paid false if unpaid
     * @return void
     */

    void setPaid(Boolean paymentStatus);
    /* Sets the date of the expense
     * @param  dateOfExpense sets the date at which the expense is to be paid
     * @return void
     */
    Double getAmount();

    
    /* Sets the date of the expense
     * @param  dateOfExpense sets the date at which the expense is to be paid
     * @return void
     */
    Integer size();

    /* Gets the Expense Type of the expense
     *
     * @return one time purchase or recurring bill
     */
    void setAmount(Double amount);

    ExpenseType getExpenseType();

    /* Gets the payment status of the expense
     *
     * @return payment status true if paid false if unpaid
     */
    Boolean getPaymentStatus();

    CompositeExpenses toCompositeExpenses();
}
