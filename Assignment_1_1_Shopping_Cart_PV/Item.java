
/**
 * A class designed to be used as an object representing a purchasable item. Provides the functionality of an Item ADT.
 * @author Patrick Valsted
 *
 */

public class Item {
	
	public String name, description;
	public double price;
	public boolean isInStock;
	public int quantity;
	
	
	/**
	 * Empty-argument constructor creates an item with empty String fields, numbers set to 0, and by default set to out of stock.
	 */
	public Item () {
		name= "";
		description= "";
		price=0.0;
		isInStock=false;
		quantity=0;
	}//end empty-argument constructor
	
	/**
	 * Preferred constructor allows user to pass variables in, calls the setPrice and setQuantity methods to ensure the number is 0 or greater.
	 * @param name  What the item is called
	 * @param price  How much item costs
	 * @param description  Description of item
	 * @param isInStock  If the item is in stock, true if so and false if not
	 * @param quantity  How many of the item you are dealing with
	 */
	public Item (String name, double price, String description, boolean isInStock, int quantity) {
		this.name=name;
		this.setPrice(price);
		this.description=description;
		this.isInStock=isInStock;
		this.setQuantity(quantity);
	}//end preferred constructor

	/**
	 * Displays name of item
	 * @return name
	 */
	public String getName() {
		return name;
	}//end getName

	/**
	 * Sets name of item
	 * @param name of item
	 */
	public void setName(String name) {
		this.name = name;
	}//end setName

	/**
	 * Displays description of item
	 * @return description
	 */
	public String getDescription() {
		return description;
	}//end getDescription

	/**
	 * Sets description of item
	 * @param description of item
	 */
	public void setDescription(String description) {
		this.description = description;
	}//end setDescription

	/**
	 * Displays price of item
	 * @return price of item
	 */
	public double getPrice() {
		return price;
	}//end getPrice

	/**
	 * Sets price of item 
	 * @param price of item, can be 0 or more
	 */
	public void setPrice(double price) {
		if (price>=0.0) //bounds check, makes sure quantity is 0 or greater
			this.price = price;
		else System.out.println("Price must be 0 or greater!"); //if out of bounds this message will print
	}//end setPrice

	/**
	 * Displays if item is in stock or not
	 * @return in stock status
	 */
	public boolean isInStock() {
		return isInStock;
	}//end isInStock

	/**
	 * Sets whether an item is in stock or not; intended to be true if so, false if not.
	 * @param isInStock 
	 */
	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}//end setInStock

	/**
	 * Displays quantity of item
	 * @return quantity of item
	 */
	public int getQuantity() {
		return quantity;
	}//end getQuantity

	/**
	 * Sets quantity of item
	 * @param quantity of item, can be 0 or more
	 */
	public void setQuantity(int quantity) {
		if (quantity>=0) //bounds check, makes sure quantity is 0 or greater
			this.quantity = quantity;
		else System.out.println("Quantity must be 0 or greater!"); //if out of bounds this message will print
	}//end setQuantity

	/**
	 * Prints item information in array format
	 */
	@Override
	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", price= $" + price + ", isInStock=" + isInStock
				+ ", quantity=" + quantity + "]";
	}//end toString

}//end class
