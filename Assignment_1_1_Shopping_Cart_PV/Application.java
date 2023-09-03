
public class Application {

	public static void main(String[] args) {
		
		/**
		 * Instantiating 2 item objects to use to test cart, printing output to display item info
		 */
		System.out.println("Output for item toStrings:");
		Item item1=new Item("Shirt",7.5,"Green t-shirt",true,2);
		System.out.println(item1);
		Item item2=new Item("Apple",0.99,"Granny Smith Apple, each",true,3);
		System.out.println(item2);
		
		System.out.println("\nOutput for price bounds test:");
		item2.setPrice(-3.0); //testing bounds for price

		/**
		 * Instantiating a new ShoppingCart object and adding two items
		 * with which to do tests
		 */
		ShoppingCart cart=new ShoppingCart(); //instantiate new cart
		cart.addItem(item1); //add two items
		cart.addItem(item2);
		
		/**
		 * Testing displayTotalItems and displayTotalUniqueItems
		 */
		System.out.println("\nOutput for displayTotalItems and displayTotalUniqueItems:");
		System.out.println(cart.displayTotalItems()); //output is 5, items have combined quantity of 5
		System.out.println(cart.displayTotalUniqueItems()); //output is 2, there are 2 item objects in cart array
		
		/**
		 * Testing checkIfEmpty before and after using clearCart method
		 */
		System.out.println("\nOutput for checkIfEmpty before and after clearCart:");
		System.out.println(cart.checkIfEmpty()); //output is false because cart is not empty
		cart.clearCart();
		System.out.println(cart.checkIfEmpty()); //output is true because cart is empty
		
		cart.addItem(item1); //add two items back for testing
		cart.addItem(item2);
		
		/**
		 * Testing getShipping, displayTotalCost, and applyCoupon methods
		 */
		System.out.println("\nOutput for getShipping and displayTotalCost methods w/ bounds test for item quantity:");
		System.out.println(cart.getShipping()); //shipping correctly outputs as 3.99 because the total cost is less than 50
		System.out.println(cart.displayTotalCost()); //correctly outputs cost + shipping
		
		item1.setQuantity(-2); //correctly outputs bounds message because quantity can't be less than 0
		item1.setQuantity(8); //raising quantity to push total cost over 50
		
		System.out.println("\nOutput for getShipping and displayTotalCost after price increase:");
		System.out.println(cart.getShipping()); //shipping correctly outputs as 0 because the total cost is more than 50
		System.out.println(cart.displayTotalCost()); //correctly outputs just cost with no shipping
		
		System.out.println("\nOutput for getShipping and displayTotalCost after coupon is applied:");
		cart.applyCoupon(0.25); //apply 25% off coupon
		System.out.println(cart.getShipping()); //shipping is still 3.99 because total after coupon is less than 50
		System.out.println(cart.displayTotalCost()); //correctly outputs discounted total + shipping
		
		System.out.println("\nOutput for getDiscount w/ bounds tests:");
		cart.applyCoupon(1.2); //correctly outputs bounds message because discount can't be above 1.0
		cart.applyCoupon(-0.2); //correctly outputs bounds message because discount can't be less than 0
		System.out.println(cart.getDiscount());
		
		/**
		 * Testing removeItem and getCartContents methods
		 */
		System.out.println("\nOutput for getCartContents:");
		System.out.println(cart.getCartContents());
		
		cart.removeItem(item1); //removing 1 item to update cart contents
		System.out.println(cart.getCartContents());
		
		/**
		 * Testing toString method
		 */
		System.out.println("\nOutput for toString:");
		System.out.println(cart);
		
		/**
		 * Instantiating a new cart with the discount as a field
		 */
		System.out.println("\nOutput for toString of new cart:");
		ShoppingCart cart1=new ShoppingCart(0.5);
		cart1.addItem(item1);
		System.out.println(cart1);
		
		/**
		 * Adding and removing more items to the first cart
		 */
		System.out.println("\nOutput for 3 new items added:");
		
		Item item3=new Item("Pack of Pencils",10.99,"Pack of 10 Ticonderoga pencils",true,1);
		System.out.println(item3);
		Item item4=new Item("Snowglobe",24.99,"Souvenir snowglobe from Beijing",true,1);
		System.out.println(item4);
		Item item5=new Item("Ream of Paper",5.99,"Ream of paper",true,2);
		System.out.println(item5);
		
		System.out.println("\nOutput for getCartContents and toString w/ new items added and removed:");
		cart.addItem(item1);
		cart.addItem(item3);
		cart.addItem(item4);
		cart.addItem(item5);
		System.out.println(cart.getCartContents()); //outputs cart with the 5 items added
		System.out.println(cart+"\n");
		
		cart.removeItem(item4);
		cart.removeItem(item2);
		System.out.println(cart.getCartContents()); //2 items removed, cart correctly outputs just 3 items
		System.out.println(cart+"\n");
		
	}//end main

}//end class
