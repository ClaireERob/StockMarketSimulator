public class Stock {
    private String name;
    private double price;
    private double value; // This is determined by portfolio allocation
    private String sector;


    // Constructor
    public Stock(String name, double price, String sector) {
        this.name = name;
        this.price = price;
        this.sector = sector;
        this.value = 0; //This is set when stock is added to a portfolio. Starts as 0 as nothing has been added to portfolio.
    }

    // Get name method
    public String getName() {
        return name;
    }

    // Get price method
    public double getPrice() {
        return price;
    }

    // Get sector method
    public String getSector() {
        return sector;
    }


    // Update price method which uses percentage change
    public void updatePrice(double percentageChange) {
        price += price * percentageChange;
    }
}
 
