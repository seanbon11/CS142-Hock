import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scraper {

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