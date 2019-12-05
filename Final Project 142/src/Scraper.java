import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scraper {

	public static void scanWarehouseCodes(Scanner s) {
		ArrayList<String> list = new ArrayList<>();
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (line.startsWith("    <Wh_Item>")) {
				String number = line.substring(line.indexOf(">")+1, line.indexOf("</"));
				list.add(number);
			}
		}
		System.out.println(list);
		System.out.println(list.size());
	}
	
	
	public static void loadNewItems(Scanner s) {
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (line.startsWith("	<Description>")) {
				String desc = line.substring(line.indexOf(">")+1, line.indexOf("</"));
				continue;
			}
			if (line.startsWith("	<Cost>")) {
				double cst = Double.valueOf(line.substring(line.indexOf(">")+1, line.indexOf("</")));
				continue;
			}
			if (line.startsWith("	<RegularPrice>")) {
				double retail = Double.valueOf(line.substring(line.indexOf(">")+1, line.indexOf("</")));
				continue;
			}
			if (line.startsWith("	<SalePrice>")) {
				double tpr = Double.valueOf(line.substring(line.indexOf(">")+1, line.indexOf("</")));
				continue;
			}
			
			//This is where we assemble the above variables into a value of the array.
			//The array is stored in the Prompt class. 
			
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File( "brdatatest.xml" ));
		ArrayList<String> list = new ArrayList<>();
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (line.startsWith("    <Wh_Item>")) {
				String number = line.substring(line.indexOf(">")+1, line.indexOf("</"));
				list.add(number);
			}
		}
		System.out.println(list);
		System.out.println(list.size());
	}

}