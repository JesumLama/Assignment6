

abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    protected static final double BASE_PRICE = 2.0;
    protected static final double SIZE_PRICE = 1.0;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) && type == beverage.type && size == beverage.size;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}