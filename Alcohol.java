class Alcohol extends Beverage {
    private boolean weekend;

    public Alcohol(String name, Size size, boolean weekend) {
        super(name, Type.ALCOHOL, size);
        this.weekend = weekend;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE + (getSize().ordinal() * SIZE_PRICE);
        if (weekend) price += 0.6;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " Alcohol{" +
                "weekend=" + weekend +
                ", price=" + calcPrice() +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Alcohol)) return false;
        Alcohol alcohol = (Alcohol) obj;
        return weekend == alcohol.weekend;
    }

    // Getters and Setters
    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }
}