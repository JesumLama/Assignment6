import java.util.ArrayList;

class Order implements Comparable<Order> {
    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNumber = generateRandomOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer);
        this.beverages = new ArrayList<>();
    }

    private int generateRandomOrderNumber() {
        return (int) (Math.random() * (90000 - 10000 + 1) + 10000);
    }
    public Beverage getBeverage(int index) {
        if (index >= 0 && index < beverages.size()) {
            return beverages.get(index);
        } else {
            return null; 
        }
    }
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }



    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Coffee(bevName, size, false, false));
    }

    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderTime=" + orderTime +
                ", orderDay=" + orderDay +
                ", customer=" + customer +
                ", beverages=" + beverages +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.orderNumber, o.orderNumber);
    }
    public int getTotalItems() {
        return beverages.size();
    }
    public int getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }
    

    public void setBeverages(ArrayList<Beverage> beverages) {
        this.beverages = beverages;
    }
}