package edu.neu.csye7374;

public class Nike extends Stock implements Tradeable1 {

    public Nike(String name, Double price, String description) {
        super(name, price, description);
    }

    @Override
    public String getMetric() {
        double metric = this.getPrice() * (Math.random() * 0.5 + 0.75);
        return "Performance Metric of " + this.getName() + " : " + metric;
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidValue = Double.parseDouble(bid);
            this.setPrice(this.getPrice() + (bidValue - this.getPrice()) * 0.5);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid: " + bid);
        }
    }
}
