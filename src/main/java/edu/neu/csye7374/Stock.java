package edu.neu.csye7374;

public abstract class Stock implements Tradeable {

    private String name;

    private Double price;

    private String description;

    public Stock(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[Stock Name: " + this.getName() + " ,\n" +
                "[Price: " + this.getPrice() + " ,\n" +
                "[Description: " + this.getDescription() + " ]";
    }

}
