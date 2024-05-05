class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE + (getSize().ordinal() * SIZE_PRICE);
        price += numOfFruits * 0.5;
        if (addProtein) price += 1.5;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " Smoothie{" +
                "numOfFruits=" + numOfFruits +
                ", addProtein=" + addProtein +
                ", price=" + calcPrice() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Smoothie smoothie = (Smoothie) obj;
        return numOfFruits == smoothie.numOfFruits && addProtein == smoothie.addProtein;
    }

    // Getters and Setters
    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public boolean isAddProtein() {
        return addProtein;
    }

    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }
}