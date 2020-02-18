package parking.service;

import java.util.*;

import parking.Car;
import parking.exceptions.BaseException;
import parking.exceptions.CreationFailureException;
import parking.exceptions.InvalidCarException;
import parking.exceptions.SlotIsMissingException;

/**
 * @author Tarun Sikka
 *
 */

public class ParkingServiceImpl implements ParkingService{
	
	Map<Integer, Car> slotCarMap;
	TreeSet<Integer> freeSlots;
	
	
	/**
	 * @param slots
	 * @throws BaseException
	 */
	@Override
	public void createParking(int slots)throws BaseException {
		slotCarMap = new HashMap<Integer, Car>();
		freeSlots = new TreeSet<Integer>();
		try{
			for(int i=0;i<slots;i++){
				slotCarMap.put(i+1,null);
				freeSlots.add(i+1);
			}		
			System.out.println("Parking lot created with "+slots+" slots");
		}
		catch(RuntimeException ex) {
			throw new CreationFailureException("Failure in Parking Creation");
		}
		
	}

	/**
	 *@param regNo, color
	 *@throws BaseException
	 */
	@Override
	public void park(String regNo, String color)throws BaseException {
		try {
			Car newCar = new Car(regNo, color);	
			if(!freeSlots.isEmpty()){
				int parkSlot = freeSlots.pollFirst();
				slotCarMap.put(parkSlot, newCar);
				System.out.println("Car parked at slot: "+parkSlot );
			} else {
				System.out.println("Parking is full");
			}
		} catch(RuntimeException ex) {
			throw new InvalidCarException("Car properties are Inavlid");
		}
		
		
		
	}

	/**
	 *@param slot
	 *@return Car
	 *@throws BaseException
	 */
	@Override
	public Car seek(int slot)throws BaseException {
		if(slot>slotCarMap.size())
			throw new SlotIsMissingException("Slot is missing"); 
		try {
			return slotCarMap.get(slot);
		} catch(RuntimeException ex) {
			throw new SlotIsMissingException("Slot is missing");
		}
				
	}

	/**
	 *@param slot
	 *@throws BaseException
	 */
	@Override
	public void remove(int slot)throws BaseException {
		try {
		if(slotCarMap.get(slot) == null)
			System.out.println("No car parked here");
		else{
			slotCarMap.put(slot, null);
			freeSlots.add(slot);
			System.out.println("Car removed from slot: "+slot);
		}
		} catch (RuntimeException ex) {
			throw new SlotIsMissingException("Slot is missing");
		}
		
	}

}
