/**
 * 
 */
package parking.service;

import parking.Car;
import parking.exceptions.BaseException;

/**
 * @author Tarun Sikka
 *
 */
public interface ParkingService {
	
	/*
	 * To create parking slot
	 * */
	void createParking(int slots)throws BaseException;
	
	/*
	 * To park a car
	 * */
	void park(String regNo, String color)throws BaseException;
	
	/*
	 * To fetch car details in a slot
	 * */
	Car seek(int slot)throws BaseException;
	
	/*
	 * To remove a car from parking
	 * */
	void remove(int slot)throws BaseException;
	
}
