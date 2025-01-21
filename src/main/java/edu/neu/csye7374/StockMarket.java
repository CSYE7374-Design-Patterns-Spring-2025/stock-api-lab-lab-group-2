package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static StockMarket instance;
    private final List<Stock> stocksList = new ArrayList<>();

    private StockMarket() {
        instance = null;
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocksList.add(stock);
    }

    public void removeStock(Stock stock) {
        stocksList.remove(stock);
    }

    public void tradeStock(String name, String bid) {
        for (Stock stock : stocksList){
            if (stock.getName().equals(name)) {
                stock.setBid(bid);
            }
        }
    }

    public String showTradeDetails() {
        StringBuilder stocksDetail = new StringBuilder();
        for (Stock stock : stocksList) {
            stocksDetail.append(stock.toString()).append("\n");
            stocksDetail.append(stock.getMetric()).append("\n");
        }
        return stocksDetail.toString();
    }

    public static void demo() {

        Stock apple = new Apple("Apple", 35.0, "Apple Stock");
        Stock nike = new Nike("Nike", 29.0, "Nike Stock");

        StockMarket stockMarket = StockMarket.getInstance();
        stockMarket.addStock(apple);
        stockMarket.addStock(nike);

        String[] bids = {"21.0", "25.0", "28.0", "33.0", "37.0", "41.5"};

        for (int i = 0; i < bids.length; i++) {
            stockMarket.tradeStock("Apple", bids[i]);
            stockMarket.tradeStock("Nike", bids[i]);
            System.out.println("Stock Market State after " + (i + 1) + " bid(s): \n");
            System.out.println(stockMarket.showTradeDetails() + "\n");
        }

    }
}
