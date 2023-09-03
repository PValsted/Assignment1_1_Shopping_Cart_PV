/**
 * An interface that provides the methods for a Shopping Cart ADT.
 * @author Patrick Valsted
 */
public interface ShoppingCartInterface {

	/**
	 * Gets current number of items in the cart
	 * @return Integer number of items in cart
	 */
	public int displayTotalItems();
	
	/**
	 * Adds the specified item to the cart
	 * @param item Adds an entry to the cart in the form of an Item object
	 */
	public void addItem(Item item);
	
	/**
	 * Removes the specified item from the cart
	 * @param item Removes an entry from the cart in the form of an Item object
	 */
	public void removeItem(Item item);
	
	/**
	 * Empties out the cart
	 */
	public void clearCart();
	
	/**
	 * Returns a value depending on whether there are any entries in the cart or not
	 * @return boolean, true if empty, false if not
	 */
	public boolean checkIfEmpty();
	
	/**
	 * Adds up the total cost of the cart, including shipping
	 * @return double value in USD of the items in the cart combined + shipping
	 */
	public double displayTotalCost();
	
	/**
	 * Sets discount to be applied at checkout
	 * @param discount in decimal format
	 */
	public void applyCoupon(double discount);
	
	/**
	 * Displays just the cost of shipping for the cart
	 * @return double value in USD of shipping cost
	 */
	public double getShipping();
	
	/**
	 * Lists the contents of the cart
	 * @return cart contents in StringBuilder form
	 */
	public StringBuilder getCartContents();
	
}//end interface
