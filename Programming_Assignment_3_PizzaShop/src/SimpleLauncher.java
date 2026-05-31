package pizza;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleLauncher implements Observer{
	
	
	public static void main(String[]args){
		
		SimpleLauncher launcher = new SimpleLauncher();
		PizzaShop pizzaShop = PizzaShop.getInstance();
		pizzaShop.getPizzaOven().registerObserver(launcher);
		
		int input; 
		boolean exit = false;
		Scanner keyboard = new Scanner(System.in);
		do{
			//print the menu
			System.out.println("*******Pizzashop Management System*******");
			System.out.println("(1) Order a Pizza: ");
			System.out.println("(2) View Pizzas");
			System.out.println("(3) Exit the program");
			System.out.println("*****************************************");

			//using an Exception control loop
			try{
				input = keyboard.nextInt();
				PizzaOrTopping pizza = null;
				switch(input){

				case 1:
					boolean exit2 = false;
					do{
					System.out.println("*******Pizzashop Management System*******");
					System.out.println("Please choose the type of pizza");
					System.out.println("(1) Original Pizza: ");
					System.out.println("(2) DeepPan Pizza: ");
					System.out.println("(3) Cancel Order");
					System.out.println("*****************************************");
					input = keyboard.nextInt();
					switch(input){
						case 3: 
							exit2 = true;
							break;
						case 1: 
						case 2: 
							if (input == 1)
								pizza = new OriginalPizza(pizzaShop.getOrderCounter());
							else	
								pizza = new DeepPanPizza(pizzaShop.getOrderCounter());
						default:
							boolean exit3 = false;
							do{
								System.out.println("*******Pizzashop Management System*******");
								System.out.println("Please choose a topping");
								System.out.println("(1) Pepperoni");
								System.out.println("(2) Bacon");
								System.out.println("(3) Pineapples");
								System.out.println("(4) Mushrooms");
								System.out.println("(5) Extra Cheese");
								System.out.println("(6) Confirm Order");
								System.out.println("(7) Cancel Order");
								System.out.println("*****************************************");
								input = keyboard.nextInt();
								switch(input){
									case 1: 
										pizza = new Pepperoni(pizza);
										break;		
									case 2: 
										pizza = new Bacon(pizza);
										break;
									case 3: 
										pizza = new Pineapple(pizza);
										break;
									case 4:
										pizza = new Mushroom(pizza);
										break;
									case 5: 
										pizza = new Cheese(pizza);
										break;
									case 6: 
										pizzaShop.placeOrder(pizza);
										System.out.println("Pizza Ordered: "+pizza.getDescription());
										exit3 = true;
										exit2 = true;
										break;
									case 7: 
										exit3 = true;
										exit2 = true;
										break;
								}
							}while (!exit3);
							break;
					}
					}while(!exit2);		
					break;
				case 2:
					System.out.println("Pizzas in the Oven...\n"+pizzaShop.getPizzaOven().toString());
					break;
				case 3:
					exit = true;
					System.out.println("Exiting Program... Goodbye.");
					break;
				default: break;
				}
			}catch(InputMismatchException e){
				keyboard.nextLine();
				System.out.println("Incorrect input, Try Again..\n");
			}
		}while (!exit);

	}

	@Override
	public void update(PizzaOrTopping pizza) {
		System.out.println("Pizza is finished "+pizza.getDescription());
	}



}
