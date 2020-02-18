package parking;

/**
 * @author Tarun Sikka
 *
 */
public class Car {
	private String regNo;
	private String color;
	
	public Car(String regNo, String color){
		this.regNo = regNo;
		this.color = color;
	}

	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}

	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	

}
