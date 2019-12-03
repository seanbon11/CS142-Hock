import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {
		//Menu: jump to other methods
		Scanner s = new Scanner(System.in);
		int choice = menu(s);
		
		//prompt for units
		//array of unit variables
		//purchase units
		//sale units
		//case versus 1
		
	}
	
	public static int menu(Scanner s) {
		int choice = 0;
		
		while(true) {
			System.out.println("Welcome to Grocery Pricing Management!");
			System.out.println("What would you like to do?");
			
			System.out.println();
			
			System.out.println("1. Create Item"); //FIXME put in item array
			System.out.println("2. Update Item Values");
				//FIXME check for item existence
				//FIXME jump to other menu with list of things to update
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
