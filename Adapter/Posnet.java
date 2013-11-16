package Adapter;

import Library.Request;

import java.util.Map;

/**
* Posnet Payment Type implementation
* @author Bahattin Çiniç <bahattincinic@gmail.com>
*/
public class Posnet extends PaymentAbstract implements PaymentInterface {

	/**
     * sale Transaction
     * 
     * @param Library.Request creditCardRequest
     * @return bool
    */
	public boolean pay(Request creditCardRequest){
		if(creditCardRequest.validate()){
			Map<String, String> config = this.getConfig("src/config/est.xml");
			System.out.println(config);
			return true;
		}else{
			return false;
		}
	}
}
