
public class Item {

	private String description;
		// my brain tells me to change this to "name" for better readability? But that's kind of irrelavent...
	private double cost;
	private double regularPrice;
	
		/* I'm thinking we should set multiple price variables in order to switch between onsalePrice and regularPrice.
		 * We can create an onSale boolean and just have two price variables, regularPrice and currentPrice.
		 * This way, the regular price is always saved
		 * when user lists the details of an item, it will also calculate and print the sale percentage
		 */
	private double currentPrice;
	private double salePrice;
	private boolean onSale;
		// One all encompassing unit variable should eliminate the need for liquid boolean and all that confusion
	private String unitType;

	
	
	// All of these variables seem unnecessary for the main purpose of presentation. 
	// Let's get a decent running presentation before implementing these.
	private String brand;
	private int UPC;
	private int itemCode;
	private boolean taxable;
	private boolean liquid;
	private String sourceOfSupply;
	private int department;
		/* Department codes are as follows:
		 * 01: Regular Grocery
		 * 02: General Merchandise & Taxable Grocery
		 * 03: Dairy
		 * 04: Frozen
		 * 05: Produce
		 * 06: Deli
		 * 07: Meat Department
		 */
	
	private static String[] dept = {"Grocery", "GM", "Dairy", "Frozen", "Produce", "Deli", "Meat"};
		/*
		 * The following fields wouldn't be bad for the sub-classes: Size Number per
		 * case

		 * These might go in their own methods somewhere: Discount price Discount
		 * duration Cost per unit Profit margin

		 */
	Item(double cost, double regularPrice, String brand, String description, int UPC, int itemCode, boolean taxable, boolean liquid, String sourceOfSupply, int department) {
		this.cost = cost;
		this.regularPrice = regularPrice;
		this.brand = brand;
		this.description = description;
		this.UPC = UPC;
		this.itemCode = itemCode;
		this.taxable = taxable;
		this.sourceOfSupply = sourceOfSupply;
		this.department = department;
	}
	
	Item() {}
	
	public double getCost() {
		return this.cost;
	}
	
	public void setCost(double cost) {
		System.out.println("Old cost: "+cost);
		this.cost = cost;
		System.out.println("New cost: "+cost);
	}
	
	public double getRegularPrice() {
		return this.regularPrice;
	}
	
	public void setRegularPrice(double regularPrice) {
		System.out.println("Old retail price: "+regularPrice);
		this.regularPrice = regularPrice;
		System.out.println("New retail price: "+regularPrice);
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		System.out.println("Old brand: "+brand);
		this.brand = brand;
		System.out.println("New brand: "+brand);
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		System.out.println("Old description: "+description);
		this.description = description;
		System.out.println("New description: "+description);
	}
	
	public int getUPC() {
		return this.UPC;
	}
	
	public void setUPC(int UPC) {
		System.out.println("Old UPC: "+UPC);
		this.UPC = UPC;
		System.out.println("New UPC: "+UPC);
	}
	
	public int getItemCode() {
		return this.itemCode;
	}
	
	public void setItemCode(int itemCode) {
		System.out.println("Old item code: "+itemCode);
		this.itemCode = itemCode;
		System.out.println("New item code: "+itemCode);
	}
	
	public boolean getTaxable() {
		return this.taxable;
	}
	
	public void setTaxable(boolean taxable) {
		System.out.println("Was taxable: "+taxable);
		this.taxable = taxable;
		System.out.println("Is taxable: "+taxable);
	}
	
	public boolean getLiquid() {
		return this.liquid;
	}
	
	public void setLiquid(boolean liquid) {
		System.out.println("Was liquid: "+liquid);
		this.liquid = liquid;
		System.out.println("Is liquid: "+liquid);
	}
	
	public String getSourceOfSupply() {
		return this.sourceOfSupply;
	}
	
	public void setSourceOfSupply() {
		System.out.println("Old source of supply: "+sourceOfSupply);
		this.sourceOfSupply = sourceOfSupply;
		System.out.println("New source of supply: "+sourceOfSupply);
	}
	
	public String getDepartment() {
		return dept[this.department-1];
	}
	
	public void setDepartment(int department) {
		System.out.println("Old department: "+dept[department-1]);
		this.department = department;
		System.out.println("New department: "+dept[department-1]);
	}
	
	
	
	//FIXME add prompt to interact with user
	//FIXME batch file method
	//FIXME array of objects
	

	public double profitMargin(double cost, double regularPrice) {
		double costRatio = cost / regularPrice;
		double margin = 1 - costRatio;
		System.out.println(Math.round(margin*1000)/10.0+"%");
		return margin;
	}

	public static void updateByMargin(Item I, double desiredMargin) {
		double cost = I.cost;
		double decimalMargin = desiredMargin / 100;

		double retailPrice = cost / (1-decimalMargin);
		I.regularPrice = retailPrice;
	}
	
	public double salesTotalProfit(double sale, int numItems) {
		return numItems * (regularPrice * sale);
	}
	
	//Given retail price and unit size, find price per unit
	
	public double pricePerUnit(double unitSize) {
		return regularPrice / unitSize;
	}
	
	public static void printDetails(Item I) {
		System.out.println("Name"+I.description);
		
	}
	//FIXME On sale
}
		

	

