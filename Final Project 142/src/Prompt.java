import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Item> groceryList = fillArrayList();
		
		int choice = menu(s);
		
		switch(choice) {
		case 1: //Create New Item
			Item corn = createItem();
			groceryList.add(corn);
			break;
		case 2: //View Existing Items
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
	
	public static void editExistingItem(ArrayList<Item> groceryList, Scanner s) {
		int option = -1;
		
		while(true) {
			System.out.println("List of Grocery Items");
			for(int i = 1; i <= groceryList.size(); ++i) {
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
		
		//print selected --option
		
	}
	
	public static Item createItem() {	
		String description = "";
		double cost = 0.0;
		double regularPrice = 0.0;
		double salePrice = 0.0;
		double profitMargin = 0.0;
		
		Item temp = new Item(description, cost, regularPrice, salePrice, profitMargin);
		
		return temp;
	}
	
	public static ArrayList<Item> fillArrayList() {
		ArrayList<Item> groceryList = new ArrayList<Item>();
		
		String description = "Apple";
		double cost = 0.0;
		double regularPrice = 0.0;
		double salePrice = 0.0;
		double profitMargin = 0.0;
		
		Item Apple = new Item(description, cost, regularPrice, salePrice, profitMargin);
		groceryList.add(Apple);
		
		description = "Rice";
		cost = 0.0;
		regularPrice = 0.0;
		salePrice = 0.0;
		profitMargin = 0.0;
		
		Item Rice = new Item(description, cost, regularPrice, salePrice, profitMargin);
		groceryList.add(Rice);
		
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
