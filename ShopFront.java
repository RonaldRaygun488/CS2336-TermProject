import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

public class ShopFront{
	/*public static void main(String[] args){
		String[] booksTitle = {"Intro to Java", "1984", "Computer Organization and Design", "Make"};
		double[] booksPrice = {29.99, 5.99, 59.99, 3.99};
		String[] dvdTitle = {"The Internship", "ExMachina"};
		double[] dvdPrice = {10.99, 19.99};
		String[] cartItem = new String[5];
		double[] cartPrice = new double[5];
		int itemsInCart = 0; //Keeps track of items added to cart to enforce 5 item limit
		int menuOp;

		do
		{
			displayMenu();
			menuOp = getMenuInput();

			switch(menuOp){
				case 1:
					displayArrays(booksTitle, booksPrice, "Books");
				break;

				case 2:
					//Brows DVDs
					displayArrays(dvdTitle, dvdPrice, "DVDs");
				break;

				case 3:
					//Add book
					//Checks to see if you have reached 5 item limit
					if(itemsInCart < 5){ 
						int itemChoice = getInventoryNumber();
						if(itemChoice != -1){
							cartItem[itemsInCart] = booksTitle[itemChoice];
							cartPrice[itemsInCart] = booksPrice[itemChoice];
							itemsInCart++; 
						}else{
							displayArrays(booksTitle, booksPrice, "Books");
						}
					}else{
						System.out.println("Your cart is full!");
					}
				break;

				case 4:
					//Add DVD
					//Checks to see if you have reached 5 item limit
					if(itemsInCart < 5){
						int itemChoice2 = getInventoryNumber();
						if(itemChoice2 != -1){
							cartItem[itemsInCart] = dvdTitle[itemChoice2];
							cartPrice[itemsInCart] = dvdPrice[itemChoice2];
							itemsInCart++; 
						}else{
							displayArrays(booksTitle, booksPrice, "Books");
						}
					}else{
						System.out.println("Your cart is full!");
					}
				break;

				case 5:
					//View cart
					displayCart(cartItem, cartPrice);
				break;

				case 6:
					//Checkout
					DecimalFormat form = new DecimalFormat("#.##"); //Formats the double to a price
					System.out.println("Your total is: $" + form.format(getTotal(cartPrice)));
				break;

				case 7:
					//Cancel Order
					clearArrays(cartItem, cartPrice);
				break;

				case 8:
					System.out.println("Exiting store. Have a nice day!");
				break;
			}

		}while(menuOp != 8);
	}*/

	public static void displayMenu(){
		System.out.println("**Welcome to the Comets Books and DVDs Store**\n\n" +
							"Choose from the following options:\n" +
							"1 - Browse books inventory (price low to high)\n" + 
							"2 - Browse DVDs inventory (price low to high)\n" + 
							"3 - Add a book to the cart\n" + 
							"4 - Add a DVD to the cart\n" +
							"5 - View cart\n" +
							"6 - Checkout\n" +
							"7 - Cancel Order\n" +
							"8 - Exit store\n\n" +
							"Please select a menu option: ");
	}

	public static int getMenuInput(){
		Scanner usrInput = new Scanner(System.in);
		int inputBuffer;
		try{
			inputBuffer = usrInput.nextInt();
		}catch(InputMismatchException ex){
			inputBuffer = -1;
			System.out.println("You did not enter a whole number menu option!");
		}
		if(0 > inputBuffer || 9 < inputBuffer){
			System.out.println("Your input was not a valid menu option!");
			inputBuffer = -1;
		}

		return inputBuffer;
	}

	public static void displayArrays(String[] item, double[] price, String type){
		int[] indexes = new int[item.length];
		//Needed to keep track of the original indexes for the inventory numbers
		for(int i = 0; i < indexes.length; i++)
			indexes[i] = i;

		//Creates a copy of the original arrays that will be sorted
		String[] itemCop = Arrays.copyOf(item, item.length);
		double[] priceCop = Arrays.copyOf(price, price.length);

		for(int i = 0; i < priceCop.length; i++){
			double lowestNumber = Double.MAX_VALUE;
			int lowestNumberIndex = -1;
			for(int j = i; j < priceCop.length; j++){
				if(priceCop[j] <= lowestNumber){
					lowestNumber = priceCop[j];
					lowestNumberIndex = j;
					//System.out.println(j);
				}
			}

			//I am so sorry for the lines of code you are about to read. It crushed my soul to write this

			double temp = priceCop[i];
			priceCop[i] = priceCop[lowestNumberIndex];
			priceCop[lowestNumberIndex] = temp;
			int tempInt = indexes[i];
			indexes[i] = indexes[lowestNumberIndex];
			indexes[lowestNumberIndex] = tempInt;
			String tempStr = itemCop[i];
			itemCop[i] = itemCop[lowestNumberIndex];
			itemCop[lowestNumberIndex] = tempStr; 
		}
		for(int i = 0; i < itemCop.length; i++){
			System.out.println(++indexes[i] + "---" + itemCop[i] + "---" + priceCop[i]);
		}
	}

	public static void displayCart(String[] cartItem, double[] cartPrice){
		System.out.println("Item\t\t\t\t\t\tPrices");
		System.out.println("-----------------------------------------------------------------------");
		for(int i = 0; i < cartItem.length; i++){
			if(cartPrice[i] != 0.0){
				System.out.println(cartItem[i] + "\t\t\t\t\t\t" + cartPrice[i]);
			}
		}
	}

	public static int getInventoryNumber(){
		Scanner usrInput = new Scanner(System.in);
		System.out.println("Please enter an inventory number: ");
		int invenNum = usrInput.nextInt();
		if(invenNum == -1){
			//displayArrays(booksTitle, booksPrice, "Books");
			return -1;
		}
		return --invenNum;
	}

	public static double getTotal(double[] prices){
		double total = 0;
		for(double i:prices){
			total += i;
		}
		total *= 1.0825;
		return total;
	}

	public static void clearArrays(String[] items, double[] prices){
		for(int i = 0; i < prices.length; i++){
			prices[i] = 0;
			items[i] = null;
		}
	}
}