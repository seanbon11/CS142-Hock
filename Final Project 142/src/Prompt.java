import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) throws FileNotFoundException {
		// Load an item file
		ArrayList<Item> groceryList = new ArrayList<>();
		Scanner itemFile = new Scanner(new File("items.txt"));
		itemFile.useDelimiter("[~\n\r]+");
		while (itemFile.hasNext()) {
			groceryList.add(new Item(itemFile.next(), itemFile.nextDouble(), itemFile.nextDouble(), itemFile.nextDouble()));
			itemFile.nextLine(); // Throw away rest of line (ensure a certain level of sanity: one item per line)
		}
		//System.out.println(groceryList);
		itemFile.close();
		if (groceryList.size() == 0) {
			System.out.println("Fill array list...");
			groceryList = fillArrayList(); // Start with default items
		}
		Scanner s = new Scanner(System.in);

		String newValue = "";
		Item I;
		
		System.out.println("Welcome to Grocery Pricing Management!");
		
		while (true) {
			int choice = menu(s);
			

			switch (choice) {
			case 1: // Create New Item
				s.nextLine();
				I = createItem(s);
				groceryList.add(I);
				break;
			case 2: // View Existing Items
				s.nextLine();
				I = selectItem(groceryList, s);
				if(I == null) break;
				I.printDetails();
				break;
			case 3: // Edit an Existing Item
				s.nextLine();
				I = selectItem(groceryList, s);
				if(I == null) break;
				editExistingItem(I, s);
				break;
			case 4: // Delete Item
				s.nextLine();
				groceryList = deleteItem(groceryList, s);
				break;
				
			/*case 4.5 : //Load items by .xml files
			 * s.nextLine();
			 * 
			 * 
			 * 
			 * Item I = createItem(s)
			 * groceryList.add(I);
			 * 
			 * 
			 * 	*/
				
			case 5: // Quit
				// Write the file
				PrintWriter fileWriter = new PrintWriter(new File("items.txt"));
				for (Item item : groceryList) {
					fileWriter.println(item.getDescription() + "~"+ item.getCost()+ "~"+ item.getRegularPrice() + "~"+ item.getSalePrice());
				}
				fileWriter.close();
				System.out.println("Goodbye");
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
		// Why does this method have it's own "list of grocery items" logic? Shouldn't we just use the selectItem method?
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
			System.out.println("\nEnter index from list of grocery items, or enter \"back\" to return to menu.\n");
			for (i = 1; i <= groceryList.size(); ++i) {
				System.out.println("" + i + ". " + groceryList.get(i - 1).getDescription());
			}
			
			if(s.hasNextInt()) {
				option = s.nextInt();
	
				if (option < 0 || option > groceryList.size()) {
					System.out.println("INVALID");
					continue;
				}
	
				return groceryList.get(--option);
			}else {
				s.nextLine();
				return null;
			}

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

		System.out.print("Price: ");
		inputDouble = s.nextDouble();
		double price = inputDouble;

		Item temp = new Item(description, cost, price, price);
		System.out.println(description+" successfuly added to list!");
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
			System.out.println("\nWhat would you like to do?\n");
			
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
