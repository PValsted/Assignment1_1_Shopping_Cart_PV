
public class ShoppingCart implements ShoppingCartInterface {

	public ResizableArrayBag<Item> newCart= new ResizableArrayBag<Item>();
	public final static double DEFAULT_SHIPPING=3.99;
	public double totalItemCost;
	public double discount=1.0;
	
	/**
	 * Default constructor instantiates a new cart using the ResizableArrayBag object
	 */
	public ShoppingCart () {
		ResizableArrayBag<Item> newCart= new ResizableArrayBag<Item>();
	}//end empty-argument constructor
	
	/**
	 * This constructor accepts discount as a field
	 * @param discount to apply to cart
	 */
	public ShoppingCart (double discount) {
		ResizableArrayBag<Item> newCart= new ResizableArrayBag<Item>();
		this.applyCoupon(discount);
	}//end constructor
	
	/**
	 * Iterates through through an array of all shopping cart items
	 * and adds up the quantity of each one to get a total
	 * @return total number of items taking quantity into account
	 */
	public int displayTotalItems() {
		int tempTotal;  //variable to store quantity of each array item temporarily
		int total=0; //resets total at beginning
		
		Object[] itemArray=newCart.toArray();
		
		for(Object i: itemArray) {
			tempTotal=(((Item) i).getQuantity());
			total=tempTotal+total; //goes through each item and adds the quantity to the combined quantity
		}//end for-each
		
		return total;
	}//end displayTotalItems
	
	/**
	 * Retrieves array size to give number of total items not taking quantity into account
	 * @return number of item objects in cart
	 */
	public int displayTotalUniqueItems() {
		return newCart.getCurrentSize();
	}//end displayTotalUniqueItems

	/**
	 * Adds an item object to the cart
	 * @param item you want to add
	 */
	public void addItem(Item item) {
		newCart.add(item);
	}//end addItem

	/**
	 * Removes an item object from the cart
	 * @param item you want to remove
	 */
	public void removeItem(Item item) {
		newCart.remove(item);
	}//end removeItem

	/**
	 * Removes all items from the cart
	 */
	public void clearCart() {
		newCart.clear();
		System.out.println("You have emptied your cart.");
	}//end clearCart

	/**
	 * Checks to see if there are items in cart; true if empty, false otherwise
	 */
	public boolean checkIfEmpty() {
		return newCart.isEmpty();
	}//end checkIfEmpty
	
	/**
	 * Sets a discount in decimal format, discount to apply at checkout
	 * @param discount between 0 and 1.0
	 */
	public void applyCoupon(double discount) {
		if (discount<1.0 && discount>0) this.discount=discount; //bounds to keep discount between 0 and 1.0
		else System.out.println("Discount amount must be between 0 and 1.0"); //if out of bounds, this message will print to let the user know
	}//end applyCoupon
	
	/**
	 * Displays discount
	 * @return discount
	 */
	public double getDiscount() {
		return discount;
	}//end getDiscount

	/**
	 * Iterates through the cart array and adds up the prices of each item in
	 * the cart, taking quantity, discount, and shipping into account
	 * @return total cost of cart
	 */
	public double displayTotalCost() {
		
		double tempCost; //variable to store price of each array item temporarily
		totalItemCost=0; //total is reset at beginning
		
		Object[] itemArray=newCart.toArray();
		for(Object i: itemArray) {
			tempCost=(((Item) i).getPrice())*(((Item) i).getQuantity()); //for each item in the array, price is multiplied by quantity and added to total price
			totalItemCost=tempCost+totalItemCost;
		}//end for-each
		
		if (discount!=1.0) totalItemCost=totalItemCost*(1-discount); //discount check, if discount isn't set nothing happens here, otherwise it's applied here
		
		return totalItemCost+this.getShipping(); //shipping is applied here, if the total up until now is less than 50, 3.99 is applied; otherwise no shipping
	}//end displayTotalCost

	/**
	 * Displays shipping cost for cart
	 * @return shipping cost
	 */
	@Override
	public double getShipping() {
		
		double tempCost;
		totalItemCost=0;
		
		Object[] itemArray=newCart.toArray();
		for(Object i: itemArray) {
			tempCost=(((Item) i).getPrice())*(((Item) i).getQuantity());
			totalItemCost=tempCost+totalItemCost;
		}//end for-each
		
		if (discount!=1.0) totalItemCost=totalItemCost*(1-discount); //much like above method, calculates total after discount to determine shipping
		
		if (totalItemCost>50.0) return 0;
		else return DEFAULT_SHIPPING;
	}//end getShipping

	/**
	 * Lists the toStrings of every item in the cart by iterating through the
	 * cart array and appending them to a StringBuilder
	 * @return StringBuilder of cart contents
	 */
	public StringBuilder getCartContents() {
		Object[] itemArray=newCart.toArray();
		StringBuilder sb=new StringBuilder();
		sb.append("Cart contents: \n");
		
		for(Object i: itemArray) {
			sb.append(((Item) i)+"\n"); //the toString of each item is added right here
		}//end for-each
		
		return sb;
	}//end getCartContents

	/**
	 * toString lists the total items, total cost, and discount applied of the ShoppingCart object
	 * @return String displaying info about cart
	 */
	@Override
	public String toString() {
		return "ShoppingCart [total items= " + this.displayTotalItems()+ ", total cost= "+this.displayTotalCost() + ", discount= "+ discount + "]";
	}//end toString

}//end class
