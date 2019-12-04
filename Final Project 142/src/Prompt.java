import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Item> groceryList = fillArrayList();
		
		
		
		int choice = menu(s);
		
		switch(choice) {
		case 1: //Create New Item
			Item I = createItem(s);
			groceryList.add(I);
			break;
		case 2: //View Existing Items
			I = selectItem(groceryList, s);
			I.printDetails();
			break;
		case 3: //Edit an Existing Item
			break;
		case 4: //View Item Properties
			break;
		case 5: //Delete Item
			break;
		case 6: //Quit
			return;
		default:
			System.out.println("/n/nINVALID, try again.");
			break;
		}
		//add delete item
		
		
		
		//prompt for units
		//array of unit variables
		//purchase units
		//sale units
		//case versus 1
		
	}
	
	public static Item selectItem(ArrayList<Item> groceryList, Scanner s) {
		int option = -1;
		int i = 1;
		
		while(true) {
			System.out.println("List of Grocery Items");
			for(i = 1; i <= groceryList.size(); ++i) {
				System.out.println("" + i + ". " + groceryList.get(i - 1).getDescription());
			}
			
			option = s.nextInt();
			
			if(option < 1 || option > groceryList.size()) {
				System.out.println("INVALID");
				continue;
			} else {
				break;
			}
		}
		
		return groceryList.get(--option);
		
		
	}
	
	
	public static Item createItem(Scanner s) {	
		String inputStr = "";
		double inputDouble = 0.0;
		
		System.out.print("Description: ");
		inputStr = s.next();
		String description = inputStr;
		
		System.out.print("Cost: ");
		inputDouble = s.nextDouble();
		double cost = inputDouble;
		
		System.out.print("Regular Price: ");
		inputDouble = s.nextDouble();
		double regularPrice = inputDouble;
		
		System.out.print("Sale Price: ");
		inputDouble = s.nextDouble();
		double salePrice = inputDouble;
		
		
		
		Item temp = new Item(description, cost, regularPrice, salePrice);
		
		return temp;
	}
	
	public static ArrayList<Item> fillArrayList() {
		ArrayList<Item> groceryList = new ArrayList<Item>();
		
		String description = "Apple";
		double cost = 0.0;
		double regularPrice = 0.0;
		double salePrice = 0.0;
		double profitMargin = 0.0;
		
		Item Apple = new Item(description, cost, regularPrice, salePrice);
		groceryList.add(Apple);
		
		description = "Rice";
		cost = 0.0;
		regularPrice = 0.0;
		salePrice = 0.0;
		profitMargin = 0.0;
		
		Item Rice = new Item(description, cost, regularPrice, salePrice);
		groceryList.add(Rice);
		
		Item ToiletPaper = new Item("Toilet Paper", 0.55, 0.85, 0.85);
		groceryList.add(ToiletPaper);
		
		Item Cashews = new Item("Cashews", 1.68, 2.95, 2.95);
		groceryList.add(Cashews);
		
		Item Tulip = new Item("Tulip", 0.10, 0.25, 0.25);
		groceryList.add(Tulip);
		
		Item Steak = new Item("Steak", 10.55, 15.45, 15.45);
		groceryList.add(Steak);
		
		Item LightBulbs = new Item("Light Bulbs", 3.65, 6.05, 6.05);
		groceryList.add(LightBulbs);
		
		Item SaladDressing = new Item("Salad Dressing", 4.56, 7.81, 7.81);
		groceryList.add(SaladDressing);
		
		Item Floss = new Item("Floss", 0.35, 0.65, 0.65);
		groceryList.add(Floss);
		
		return groceryList;
			
	}
	
	public static int menu(Scanner s) {
		int choice = 0;
		
		while(true) {
			System.out.println("Welcome to Grocery Pricing Management!");
			System.out.println("What would you like to do?");
			
			System.out.println();
			
			System.out.println("1. Create New Item"); 
			System.out.println("2. View Existing Items");
			System.out.println("3. Edit an Existing Item");
			System.out.println("4. View Properties");
			System.out.println("5. Delete Item");
			System.out.println("6. Quit");
			
			choice = s.nextInt();
			
			if(choice > 6 || choice < 1) {
				System.out.println("/n/nINVALID, try again.");
			} else {
				break;
			}	
		}
		return choice;
	}
}
