
package parking;

import java.util.Scanner;

import parking.exceptions.BaseException;
import parking.service.ParkingService;
import parking.service.ParkingServiceImpl;

/**
 * @author Tarun Sikka
 *
 */
public class Main {

	/**
	 * @param args
	 */
	private final static String help = "Commands\n"
	         + "1. create_parking_lot 4 \n"
	         + "2. park KA-01-MH-1234 white \n"
	         + "3. seek 1 \n"
	         + "4. remove 1 \n"
	         + "exit \n"
             + "Please enter commands below : \n";
		
	public static void main(String[] args) {
		System.out.println(help);
		Scanner sc = new Scanner(System.in);
		ParkingService parkService = new ParkingServiceImpl();
		while(true){
			try {
			String input = sc.nextLine().trim();
			if(input.equals("exit"))
				{
					sc.close();
					break;
				}
			else {				
				String ar[]=input.split(" ");
				if(ar[0].equals("create_parking_lot"))
					parkService.createParking(Integer.parseInt(ar[1]));
				else if(ar[0].equals("park")){
					parkService.park(ar[1], ar[2]);
				}			
				else if(ar[0].equals("seek")){
					Car carAtSlot = parkService.seek(Integer.parseInt(ar[1]));
					if(carAtSlot != null)
						System.out.println("Car reg no. " + carAtSlot.getRegNo() + " color: " + carAtSlot.getColor());
					else
						System.out.println("No car parked here");
				}
				else if(ar[0].equals("remove")){
					parkService.remove(Integer.parseInt(ar[1]));
				} 
				else if(ar[0].equals("help")){
					System.out.println(help);
				}
				else {
					System.out.println("Command does not exist");
				}
			}
		} catch(BaseException ex) {
			System.out.println(ex.getMessage());
		} catch(Exception ex) {
			System.out.println("Invalid command format");
		}
			
		}

	}

}
