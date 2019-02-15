package Controller;
/*
The basic unit of the entire expense data
 */
public class Expense {
    private String name; //name of current expense
    private double price; // price of current expense
    private String type; // type of current expense
    private boolean paid; // if it is paid

    public Expense(String name, double price, String type, boolean paid){
        this.name=name;
        this.price=price;
        this.type=type;
        this.paid=paid;//true is paid, false in unpaid
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String getType(){
        return type;
    }

    public boolean getPaid(){
        return paid;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public void setType(String type){
        this.type=type;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
