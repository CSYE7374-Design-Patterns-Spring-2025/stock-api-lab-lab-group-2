package edu.neu.csye7374;

public class Apple extends Stock implements Tradeable0 {

    public Apple(String name, Double price, String description) {
        super(name, price, description);
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidValue = Double.parseDouble(bid);
            this.setPrice((this.getPrice() * 0.8) + (bidValue * 0.2));
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid: " + bid);
        }
    }

    @Override
    public String getMetric() {
        double metric = this.getPrice() * 1.15;
        return "Performance Metric of " + this.getName() + " : " +  metric;
    }
}
