import java.util.ArrayList;


class BevShop implements BevShopInterface {
    private int numAlcoholDrinks;
    private ArrayList<Order> orders;

    public BevShop() {
        this.numAlcoholDrinks = 0;
        this.orders = new ArrayList<>();
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= 8 && time <= 23;
    }

    @Override
    public int getMaxNumOfFruits() {
        return 5;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return 21;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > 5;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return 3;
    }

    @Override
    public boolean isEligibleForMore() {
        return numAlcoholDrinks < getMaxOrderForAlcohol();
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return numAlcoholDrinks;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= getMinAgeForAlcohol();
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Order order = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(order);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Order order = orders.get(orders.size() - 1);
        order.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        Order order = orders.get(orders.size() - 1);
        order.addNewBeverage(bevName, size);
        numAlcoholDrinks++;
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Order order = orders.get(orders.size() - 1);
        order.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNo) {
                return orders.indexOf(order);
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index == -1) {
            System.out.println("Order not found.");
            return 0.0;
        }

        Order order = orders.get(index);
        double total = 0;

        if (!order.getBeverages().isEmpty()) {
            for (Beverage beverage : order.getBeverages()) {
                total += beverage.calcPrice();
            }
        } else {
            System.out.println("Order contains no beverages.");
        }

        return total;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += totalOrderPrice(order.getOrderNumber());
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return orders.get(orders.size() - 1);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    @Override
    public void sortOrders() {
        orders.sort((o1, o2) -> Integer.compare(o1.getOrderNumber(), o2.getOrderNumber()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        sb.append("Total Monthly Sale: ").append(totalMonthlySale());
        return sb.toString();
    }
}
