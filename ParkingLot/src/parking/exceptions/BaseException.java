package parking.exceptions;

/**
 * @author Tarun Sikka
 *
 */
public class BaseException extends RuntimeException{
	
	String msg;
	BaseException(String msg){
		super(msg);
		this.msg = msg;
	}
	
}
