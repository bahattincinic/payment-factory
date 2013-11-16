package Adapter;

import java.util.Map;
import Library.Request;

/**
* EST Payment Type implementation
* @author Bahattin Çiniç <bahattincinic@gmail.com>
*/
public class Est extends PaymentAbstract implements PaymentInterface {
	
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
