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
	
	
	public static Item loadNewItem(Scanner s) {
			String line = s.nextLine();
			String desc = "desc";
			double cst = 0.0;
			double retail = 0.0;
			double tpr = 0.0;
			// Keep going until we see <ROW> tag to see that item started.
			while (s.hasNextLine() && !line.contains("<ROW>")) line = s.nextLine();
			if (!s.hasNextLine()) return null;
			while (!line.contains("</ROW>")) {
				// Load until we see </ROW> tag to tell us that the item ended.
				if (line.startsWith("	<Description>")) {
					desc = line.substring(line.indexOf(">")+1, line.indexOf("</"));
				}
				if (line.startsWith("	<Cost>")) {
					cst = Double.valueOf(line.substring(line.indexOf(">")+1, line.indexOf("</")));
				}
				if (line.startsWith("	<RegularPrice>")) {
					retail = Double.valueOf(line.substring(line.indexOf(">")+1, line.indexOf("</")));
				}
				if (line.startsWith("	<SalePrice>")) {
					tpr = Double.valueOf(line.substring(line.indexOf(">")+1, line.indexOf("</")));
				}
				line = s.nextLine();
			}
			
			Item temp = new Item(desc, cst, retail, tpr);
			return temp;
		}
		
	
	
	public static void main(String[] args) throws FileNotFoundException {
/*		File items = new File("sampleitems.xml");
		Scanner t = new Scanner(items);
		ArrayList<Item> itemList = new ArrayList<>();
		while(t.hasNextLine()) {
			Item item = loadNewItem(t);
			if (item == null) break; // done with file
			itemList.add(item);
		}
		System.out.println(itemList); */
	}
}