
public class Cafe extends Building{
        private int nCoffeeOunces;
        private int nSugarPackets;
        private int nCreams;
        private int nCups;

    /* initializing attributes */
    public Cafe(String name, String address, int nFloor, 
    int coffeeOunces, int sugarPackets, int creams, int cups) {
        super(name, address, nFloor);
        this.nCoffeeOunces = coffeeOunces;
        this.nSugarPackets = sugarPackets;
        this.nCreams = creams;
        this.nCups = cups;
    }

    /*sell coffe if it has enough invertory of ingredients, otherwise restock */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (nCoffeeOunces < size || nSugarPackets < 1 || nCreams < 1 || nCups < 1) {
            System.out.println("Sorry, we don't have enough ingredients. Restocking...");
            restock(size, nSugarPackets, nCreams, 1);
        } else{
            this.nCups--;
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
        }
    }

    /* restock ingredients */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    
    /* overload restock() */
    public void sellCoffee(String size, String nSugarPackets, String nCreams){
        System.out.println("You want to restock" + "size:"+ size + "number of sugar packest:" + nSugarPackets
        + "number of creams:" + nCreams);
    }

    /* this method is only for testing purposes, reviewer could delete it for their convenience */
    public void printInventory() {
        System.out.println("Current Inventory:");
        System.out.println("Coffee (oz): " + this.nCoffeeOunces);
        System.out.println("Sugar Packets: " + this.nSugarPackets);
        System.out.println("Creams: " + this.nCreams);
        System.out.println("Cups: " + this.nCups);
    }

    /*overload printInventory() */
    public void printInventory(String message) {
        System.out.println(message);
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + 
        ":\n + sellCoffee() \n + printInventory() \n + restock()");
    }
    
    

    public static void main(String[] args) {
    Cafe myCafe = new Cafe("Compass Cafe", "Northampton", 1, 
    50, 100, 50, 50);
    
    // Print initial inventory
    myCafe.printInventory();
    System.out.println();
    
    // Sell a few coffees
    System.out.println("Selling coffee...");
    myCafe.sellCoffee(12, 2, 3);
    myCafe.sellCoffee(16, 1, 2);
    myCafe.sellCoffee(8, 0, 1);
    
    // Print updated inventory
    System.out.println("Updated inventory:");
    myCafe.printInventory();
    System.out.println();
    
    // Try to sell a coffee with insufficient inventory
    System.out.println("Selling coffee with insufficient inventory...");
    myCafe.sellCoffee(20, 3, 5);
    
    // Print inventory again
    System.out.println("Inventory after attempted sale with insufficient inventory:");
    myCafe.printInventory();
    System.out.println();
    
    // Restock and try again
    System.out.println("Restocking...");
    myCafe.restock(50, 50, 100, 50);
    System.out.println("Inventory after restocking:");
    myCafe.printInventory();
    System.out.println();
    
    System.out.println("Selling coffee after restocking...");
    myCafe.sellCoffee(20, 3, 5);
    System.out.println("Updated inventory:");
    myCafe.printInventory();
    }
    
}
