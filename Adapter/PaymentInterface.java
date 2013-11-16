package Adapter;

import Library.Request;

/**
* Payment Interface
* @author Bahattin Çiniç <bahattincinic@gmail.com>
*/
public interface PaymentInterface {
	
	/**
     * sale Transaction
     * 
     * @param Library.Request creditCardRequest
     * @return bool
    */
	public boolean pay(Request creditCardRequest);
	
}
