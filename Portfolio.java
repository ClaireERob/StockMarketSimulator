import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private String portfolioName;
    private Map<Stock, Double> stockAllocations;// This holds all the  respective allocations of stock within a portfolio
    private Map<Stock, Double> stockQuantities; // This holds all the respective quantities of stock within a portfolio
    private Double portfolioValue;

    public Portfolio(String portfolioName) {
        this.portfolioName = portfolioName;
        this.stockAllocations = new HashMap<>();
        this.stockQuantities = new HashMap<>();
        this.portfolioValue = 1000000.0;

    }



    // Decimal formatter

    DecimalFormat df = new DecimalFormat("#,###.00");

    //Get portfolio name

    public String getPortfolioName() {
        return portfolioName;
    }

    // Get portfolio value

    public Double getPortfolioValue() {
        return portfolioValue;
    }


    // Adding stock to a portfolio with given allocation percentage.
    public void addStockToPortfolio(Stock stock, double allocationPercentage) {
        if (allocationPercentage < 0 || allocationPercentage > 1) {
            throw new IllegalArgumentException("Invalid allocation percentage");
        }
        stockAllocations.put(stock, allocationPercentage);
        double quantity = calculateQuantity(stock, allocationPercentage);
        stockQuantities.put(stock, quantity);
    }

    // Method to calculate quantity of a stock in the portfolio

    public Double calculateQuantity(Stock stock, double allocationPercentage) {
        double allocationValue = allocationPercentage * 1000000;
        return allocationValue / stock.getPrice();
    }

    // Method to calculate sector allocation of portfolio
    public double calculateSectorAllocation(String sector){
        double sectorAllocation = 0.0;
        for(Map.Entry<Stock, Double> entry : stockAllocations.entrySet()) {
            Stock stock = entry.getKey();
            String stockSector = stock.getSector();
            double allocationValue = entry.getValue();
            if(stockSector.equals(sector)){
                sectorAllocation += allocationValue;
            }
        }
        System.out.println("The " + sector +" sector makes up " + df.format(sectorAllocation *100) + "% of portfolio");
        return sectorAllocation;
    }

    // Method to calculate total portfolio value
    public double calculatePortfolioValue() {
        this.portfolioValue = 0.0;
        for (Map.Entry<Stock, Double> entry : stockQuantities.entrySet()) {
            Stock stock = entry.getKey();
            double quantity = entry.getValue();
            portfolioValue += stock.getPrice() * quantity;
        }
        System.out.println("Portfolio value: $" + df.format(portfolioValue));
        return portfolioValue;
    }


    // Method to display portfolio allocation (for when a portfolio is selected)
    public void printPortfolio() {

        for (Map.Entry<Stock, Double> entry : stockAllocations.entrySet()) {
            Stock stock = entry.getKey();
            String stockName = stock.getName();
            double allocationPercentage = entry.getValue();
            System.out.println(stockName + " is " + allocationPercentage * 100 + "% of portfolio.");

        }

    }


    // Method to apply event to particular stock
    public void triggerEvent(Event selectedEvent) {

        System.out.println(selectedEvent.getEventDescription());


        for (Map.Entry<Stock, Double> entry : stockAllocations.entrySet()) {

            boolean updateStock = false;
            Stock stock = entry.getKey();


            // Checks that the events affects a company and updates updateStock to be true if so.
            if (selectedEvent.getAffectedCompany() != null && selectedEvent.getAffectedCompany().equals(stock.getName())) {
                updateStock = true;

                // Checks that the event affects the sector of the stock and updates updateStock to be true if so.
            } else if (selectedEvent.getAffectedSector() != null && selectedEvent.getAffectedSector().equals(stock.getSector())) {
                updateStock = true;
            } else {

            }


            if (updateStock) {
                stock.updatePrice(selectedEvent.getPercentageChange());
                if (selectedEvent.getPercentageChange() < 0.0) {
                    System.out.println("\nThe price for " + stock.getName() + " has decreased.");
                } else if (selectedEvent.getPercentageChange() > 0) {
                    System.out.println("\nThe price for " + stock.getName() + " has increased.");
                }
                System.out.println("The price is now $" + df.format(stock.getPrice()));
            } else {
                System.out.println("\nThe price for " + stock.getName() + " is unchanged.");
            }

        }
    }
}

 

 

 


