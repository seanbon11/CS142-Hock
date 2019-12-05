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
	
	public static void loadNewItems(Scanner s, File f) {
		ArrayList<Item> itemList = new ArrayList<>();
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (line.startsWith("	<Description>")) {
				String desc = line.substring(line.indexOf(">")+1, line.indexOf("</"));
				continue;
			}
			if (line.startsWith("	<Cost>")) {
				String cst = line.substring(line.indexOf(">")+1, line.indexOf("</"));
				continue;
			}
			if (line.startsWith("	<RegularPrice>")) {
				String retail = line.substring(line.indexOf(">")+1, line.indexOf("</"));
				continue;
			}
			if (line.startsWith("	<SalePrice>")) {
				String tpr = line.substring(line.indexOf(">")+1, line.indexOf("</"));
				continue;
			}
//			itemList<new Item(desc, cst, retail, tpr)> ;
			
			//This line is not working
			//The goal is to enter the four terms scraped earlier into a new item.
			//I don't know how to format ArrayLists. 
			//Can anyone help with this?
			
		}
		System.out.println(itemList);
		System.out.println(itemList.size());
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