import java.util.ArrayList;
import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Item> groceryList = fillArrayList();
		
		int choice = menu(s);
		
		switch(choice) {
		case 1: //Create Item
			Item corn = createItem();
			groceryList.add(corn);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			return;
		default:
			break;
		}
		
		
		
		
		//prompt for units
		//array of unit variables
		//purchase units
		//sale units
		//case versus 1
		
	}
	
	public static Item createItem() {	
		double cost = 0;
		double regularPrice = 0;
		String brand = "";
		String description = "";
		int UPC = 0;
		int itemCode = 0;
		boolean taxable = true;
		boolean liquid = true;
		String sourceOfSupply = "";
		int department = 0;
		
		Item temp = new Item(cost, regularPrice, brand, description, UPC, itemCode, taxable, 
				liquid, sourceOfSupply, department);
		
		return temp;
	}
	
	public static ArrayList<Item> fillArrayList() {
		ArrayList<Item> groceryList = new ArrayList<Item>();
		
		double cost = 1.0;
		double regularPrice = 1.0;
		String brand = "";
		String description = "Apple";
		int UPC = 1;
		int itemCode = 1;
		boolean taxable = true;
		boolean liquid = true;
		String sourceOfSupply = "";
		int department = 1;
		
		Item Apple = new Item(cost, regularPrice, brand, description, UPC, itemCode, taxable, 
				liquid, sourceOfSupply, department);
		groceryList.add(Apple);
		
		cost = 2.0;
		regularPrice = 2.0;
		brand = "";
		description = "Rice";
		UPC = 2;
		itemCode = 2;
		taxable = false;
		liquid = true;
		sourceOfSupply = "";
		department = 2;
		
		Item Rice = new Item(cost, regularPrice, brand, description, UPC, itemCode, taxable, 
				liquid, sourceOfSupply, department);
		groceryList.add(Rice);
		
		return groceryList;
			
	}
	
	public static int menu(Scanner s) {
		int choice = 0;
		
		while(true) {
			//description/name, 
			
			System.out.println("Welcome to Grocery Pricing Management!");
			System.out.println("What would you like to do?");
			
			System.out.println();
			
			System.out.println("1. Create New Item"); //FIXME put in item array
			//add into database else input from database
			//DO you want to create new item or use previous item, check using name
			//edit existing item
			
			//remove object from
			
			//ArrayList of objects, Item
			//Clear ArrayList
			
			
			//edit existing
			
			//populate a few items into 
			
			//force enter each value
			
			//print item name plus index, have choose to delete
			
			System.out.println("2. Edit an Existing Item");
				//FIXME check for item existence
				//FIXME jump to other menu with list of things to update
			System.out.println("3. Print Item"); //item name, description
			System.out.println("3. Calculate Profit Margin");
			System.out.println("4. Update by Margin");
				//FIXME prompt for new margin
			System.out.println("5. Total Profit with Items on Sale");
				//FIXME prompt for numItems and sale 
			System.out.println("6. Price per Unit");
				//FIXME prompt for unit size
			System.out.println("7. Read in Batch File");
			System.out.println("8. Quit");
			
			choice = s.nextInt();
			
			if(choice > 8 || choice < 1) {
				System.out.println("/n/nINVALID, try again.");
			} else {
				break;
			}	
		}
		return choice;
	}
}
