public class item {

	private double cost;
	private double regularPrice;
	private String brand;
	private String description;
	private int UPC;
	private int itemCode;
	private boolean taxable;
	private String sourceOfSupply;
	private int department;
//	Department codes are as follows: 
//	01: Regular Grocery
//	02: General Merchandise & Taxable Grocery
//	03: Dairy
//	04: Frozen
//	05: Produce
//	06: Deli
//	07: Meat Department
	
	
	/*
	 * The following fields wouldn't be bad for the sub-classes: 
	 * Size
	 * Number per case
	 * 
	 * These might go in their own methods somewhere: 
	 * Discount price
	 * Discount duration
	 * Cost per unit
	 * Profit margin
	 * 
	*/
	
	
	item(double cost, double regularPrice, String brand, String description, int UPC, int itemCode, boolean taxable, boolean liquid, String sourceOfSupply, int department) {
		this.cost = cost;
		this.regularPrice = regularPrice;
		this.brand = brand;
		this.description = description;
		this.UPC = UPC;
		this.itemCode = itemCode;
		this.taxable = taxable;
		this.liquid = liquid;
		this.sourceOfSupply = sourceOfSupply;
		this.department = department;
	}
	
	item() {}
	
	public double getCost() {
		return this.cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getRegularPrice() {
		return this.regularPrice;
	}
	
	public void setRegularPrice(double regularPrice) {
		this.cost = cost;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getUPC() {
		return this.UPC;
	}
	
	public void setUPC(int UPC) {
		this.UPC = UPC;
	}
	
	public int getItemCode() {
		return this.itemCode;
	}
	
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	
	public boolean getTaxable() {
		return this.taxable;
	}
	
	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}
	
	public boolean getLiquid() {
		return this.liquid;
	}
	
	public void setLiquid(boolean liquid) {
		this.liquid = liquid;
	}
	
	public String getSourceOfSupply() {
		return this.sourceOfSupply;
	}
	
	public void setSourceOfSupply() {
		this.sourceOfSupply = sourceOfSupply;
	}
	
	public int getDepartment() {
		return this.department;
	}
	
	public void setDepartment(int department) {
		this.department = department;
	}
	
	public double profitMargin(double cost, double regularPrice) {
		double costRatio = cost / regularPrice;
		double margin = 1-costRatio;
		return margin;
	}
	
	public static void updateByMargin(item I, double desiredMargin) {
		double cost = I.cost;
		double decimalMargin = desiredMargin / 100;
		double retailPrice = cost / (1-decimalMargin);
		I.regularPrice = retailPrice;
	}
	
}