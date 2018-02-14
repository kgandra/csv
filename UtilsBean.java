import java.util.Date;


public class UtilsBean implements Comparable<UtilsBean>
{
	private String name;
	private Integer price;
	private String amount;
	private String composition;
	private String colour;
	private String expiryDate;
	private String shade;
	private String brand;
	private String state;
	
	UtilsBean(String name,Integer price,String amount,String composition,String colour,String expiryDate,String shade,String brand,String state)
	{
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.composition = composition;
		this.colour = colour;
		this.expiryDate = expiryDate;
		this.shade = shade;
		this.brand = brand;
		this.state = state;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getShade() {
		return shade;
	}
	public void setShade(String shade) {
		this.shade = shade;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		//s.append("UtilsBean");
		if(name != null && name.trim().length() > 0)
			s.append("product : " + name);
		if(price != null)
			s.append(", price : " + price);
		if(amount != null && amount.trim().length() > 0)
			s.append(", amount : " + amount);
		if(composition != null && composition.trim().length() > 0)
			s.append(", composition : " + composition);
		if(colour != null && colour.trim().length() > 0)
			s.append(", colour : " + colour);
		if(expiryDate != null && expiryDate.trim().length() > 0)
			s.append(", expiryDate : " + expiryDate);
		if(shade != null && shade.trim().length() > 0)
			s.append(", shade : " + shade);
		if(brand != null && brand.trim().length() > 0)
			s.append(", brand : " + brand);
		if(state != null && state.trim().length() > 0)
			s.append(", state : " + state);
		
		return s.toString();
	}
	//Compares bean objects based on price
	public int compareTo(UtilsBean bean)
	{
		return this.price.compareTo(bean.getPrice());
	}
}
