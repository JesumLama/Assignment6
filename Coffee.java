class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE + (getSize().ordinal() * SIZE_PRICE);
        if (extraShot) price += 0.5;
        if (extraSyrup) price += 0.5;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " Coffee{" +
                "extraShot=" + extraShot +
                ", extraSyrup=" + extraSyrup +
                ", price=" + calcPrice() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Coffee coffee = (Coffee) obj;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }

    // Getters and Setters
    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}
