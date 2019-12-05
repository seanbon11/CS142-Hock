import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Item> groceryList = fillArrayList();
		
		String newValue = "";

		int choice = menu(s);

		switch (choice) {
		case 1: // Create New Item
			Item I = createItem(s);
			groceryList.add(I);
			break;
		case 2: // View Existing Items
			I = selectItem(groceryList, s);
			I.printDetails();
			break;
		case 3: // Edit an Existing Item
			I = selectItem(groceryList, s);
			//newValue = selectNewValue(s);
			editExistingItem(I, s);
			break;
		case 4: //
			break;
		case 5: // Delete Item
			break;
		case 6: // Quit
			return;
		default:
			System.out.println("/n/nINVALID, try again.");
			break;

		}

	}
	
	public static String selectNewValue(Scanner s) {
		String newInput;
		System.out.print("What new value would you like to replace X with? ");
		newInput = s.nextLine();
		newInput = s.nextLine();
		return newInput;
		//FIXME not allowing input
	}

	public static void editExistingItem(Item I, Scanner s) {
		String input;
		String newValue;
		
		System.out.println();
		I.printDetails();
		System.out.print("Enter Property Name To Change: ");
		input = s.nextLine();
		input = s.nextLine();
		
		System.out.print("What would you like to replace it with? ");
		newValue = s.nextLine();
		
		if(input.equals("name") || input.equals("Name")) {
			I.setDescription(newValue);
		}
		
		if(input.equals("cost") || input.equals("Cost")) {
			//System.out.println(input);
			I.setCost(Double.parseDouble(newValue));
		}
		
		if(input.equals("regular price") || input.equals("Regular price") || 
				input.equals("regular Price") || input.equals("Regular Price")) {
			I.setRegularPrice(Double.parseDouble(newValue));
		}
		
		if(input.equals("sale price") || input.equals("Sale price") || 
				input.equals("sale Price") || input.equals("Sale Price")) {
			I.setSalePrice(Double.parseDouble(newValue));
		}

		I.printDetails();
		//FIXME if not numbers, will cause problems, how to fix?
		
	}

	public static Item selectItem(ArrayList<Item> groceryList, Scanner s) {
		int option = -1;
		int i = 1;

		while (true) {
			System.out.println("List of Grocery Items");
			for (i = 1; i <= groceryList.size(); ++i) {
				System.out.println("" + i + ". " + groceryList.get(i - 1).getDescription());
			}

			option = s.nextInt();

			if (option < 0 || option > groceryList.size()) {
				System.out.println("INVALID");
				continue;
			}
			
			return groceryList.get(--option);
			
		}

		

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

		while (true) {
			System.out.println("Welcome to Grocery Pricing Management!");
			System.out.println("What would you like to do?");

			System.out.println();

			System.out.println("1. Create New Item");
			System.out.println("2. View Existing Items");
			System.out.println("3. Edit an Existing Item");
			System.out.println("4. Delete Item");
			System.out.println("5. Quit");

			choice = s.nextInt();

			if (choice > 5 || choice < 1) {
				System.out.println("/n/nINVALID, try again.");
			} else {
				break;
			}
		}
		return choice;
	}
}
