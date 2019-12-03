
public class RegularItem extends Item {
	
	private boolean liquid;
	private int caseUnits;
	private double oz;
	
	public RegularItem(double cost, double regularPrice, String brand, String description, int UPC, int itemCode, boolean taxable, boolean liquid, String sourceOfSupply, int department, int caseUnits, double oz) {
		super(cost, regularPrice, brand, description, UPC, itemCode, taxable, liquid, sourceOfSupply, department);
		this.liquid = liquid;
		this.caseUnits = caseUnits;
		this.oz = oz;
	}
}
