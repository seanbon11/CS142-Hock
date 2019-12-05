import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Item> groceryList = fillArrayList();

		String newValue = "";
		
		System.out.println("Welcome to Grocery Pricing Management!");
		System.out.println();
		
		while (true) {
			int choice = menu(s);

			switch (choice) {
			case 1: // Create New Item
				s.nextLine();
				Item I = createItem(s);
				groceryList.add(I);
				break;
			case 2: // View Existing Items
				s.nextLine();
				I = selectItem(groceryList, s);
				I.printDetails();
				break;
			case 3: // Edit an Existing Item
				s.nextLine();
				I = selectItem(groceryList, s);
				editExistingItem(I, s);
				break;
			case 4: // Delete Item
				s.nextLine();
				groceryList = deleteItem(groceryList, s);
				break;
			case 5: // Quit
				return;
			default:
				System.out.println("/n/nINVALID, try again.");
				break;

			}

		}

	}
	
	public static ArrayList<Item> deleteItem(ArrayList<Item> groceryList, Scanner s) {
		int i = 1;
		int option = 0;
		
		System.out.println("List of Grocery Items");
		for (i = 1; i <= groceryList.size(); ++i) {
			System.out.println("" + i + ". " + groceryList.get(i - 1).getDescription());
		}

		System.out.print("\nEnter Number: ");
		option = s.nextInt();
		
		groceryList.remove(--option);
		
		return groceryList;
	}

	public static void editExistingItem(Item I, Scanner s) {
		String input;
		String newValue;

		I.printDetails();
		System.out.print("\nEnter Property Name To Change: ");
		s.nextLine();
		input = s.nextLine();

		System.out.print("\nReplace It With: ");
		newValue = s.nextLine();
		System.out.println();

		if (input.equalsIgnoreCase("name")) {
			I.setDescription(newValue);
		}

		if (input.equalsIgnoreCase("cost")) {
			I.setCost(Double.parseDouble(newValue));
		}

		if (input.equalsIgnoreCase("regular price")) {
			I.setRegularPrice(Double.parseDouble(newValue));
		}

		if (input.equalsIgnoreCase("sale price")) {
			I.setSalePrice(Double.parseDouble(newValue));
		}

		I.printDetails();
		// FIXME if not numbers, will cause problems, how to fix?

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
		inputStr = s.nextLine();
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
		System.out.println(description+" successfuly added to list!");
		System.out.println();
		return temp;
	}

	public static ArrayList<Item> fillArrayList() {
		ArrayList<Item> groceryList = new ArrayList<Item>();

		Item Apple = new Item("Apple", 0.0, 7.0, 6.0);
		groceryList.add(Apple);

		Item Rice = new Item("Rice", 8.0, 7.0, 5.0);
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
			System.out.println("What would you like to do?");
			System.out.println();
			
			System.out.println("1. Create New Item");
			System.out.println("2. View Existing Items");
			System.out.println("3. Edit an Existing Item");
			System.out.println("4. Delete Item");
			System.out.println("5. Quit");
			System.out.print("\nEnter Number: ");

			choice = s.nextInt();

			if (choice > 5 || choice < 1) {
				System.out.println("\n\nINVALID, try again.");
			} else {
				break;
			}
		}
		return choice;
	}
}
