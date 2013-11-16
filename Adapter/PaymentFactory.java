package Adapter;
import Exception.AdapterException;

/**
* Payment Factory Pattern
* @author Bahattin Çiniç <bahattincinic@gmail.com>
*/
public class PaymentFactory {
	
	/**
	* return string key to Payment Object
	* @author Bahattin Çiniç <bahattincinic@gmail.com>
	* @param String PaymentType
	* @return Payment
	* @exception AdapterException
	*/
	public static PaymentInterface getPayment(String PaymentType) throws AdapterException{
		if(PaymentType.equalsIgnoreCase("est")){
			// Return Est Payment Type
			return new Est();
		}else if(PaymentType.equalsIgnoreCase("posnet")){
			// Return Posnet Payment Type
			return new Posnet();
		}else{
			// Undefined Payment Type
			throw new AdapterException("Adapter Not Found");
		}
	}
}
