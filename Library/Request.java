package Library;
import Exception.RequestException;

import java.lang.reflect.Field;

/**
* Payment Request
* @author Bahattin Çiniç <bahattincinic@gmail.com>
*/
public class Request {

	/** Order Transaction Id
     * @var string
     */
	private String orderId;
	
	/** Credit Card Number
     * @var string
     */
	private String cardNumber;
	
	/** Credit Card Expire Month
     * @var string
     */
	private String expireMonth;
	
	/** Credit Card Expire Year
     * @var string
     */
	private String expireYear;
	
	/** Credit Card security Code
     * @var string
     */
	private String securityCode;
	
	/** Order Total Amount
     * @var string
     */
	private String amount;
	
	/**
     * @param String orderId
     * @return Request
    */
	public Request setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}
	
	/** Credit Card Number Luhn Algoritm Validation
     * @param String cardNumber
     * @return Request
     * @exception RequestException
    */
	public Request setCardNumber(String cardNumber) throws RequestException {
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(cardNumber).reverse().toString();
        for(int i = 0 ;i < reverse.length();i++){
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 == 0){
                s1 += digit;
            }else{
                s2 += 2 * digit;
                if(digit >= 5){
                    s2 -= 9;
                }
            }
        }
         if((s1 + s2) % 10 == 0){
        	 this.cardNumber = cardNumber;
         }else{
        	 throw new RequestException("Card Number Undifined");
         }
         return this;
	}
	
	/** Credit Card SecurityCode Validation
     * @param int securityCode
     * @return Request
     * @exception RequestException
    */
	public Request setSecurityCode(int securityCode) throws RequestException {
		if(Integer.toString(securityCode).matches("^[0-9]{3,4}$")){
			this.securityCode = Integer.toString(securityCode);
		}else{
			throw new RequestException("Security Code Undifined");
		}
		return this;
	}
	
	/** Credit Card ExpireMonth Validation
     * @param int expireMonth
     * @return Request
     * @exception RequestException
    */
	public Request setExpireMonth(int expireMonth) throws RequestException {
		if(expireMonth > 0 && expireMonth < 13){
			this.expireMonth = Integer.toString(expireMonth);
		}else{
			throw new RequestException("Expire Month Undifined");
		}
		return this;
	}
	
	/** Credit Card ExpireYear Validation
     * @param int expireYear
     * @return Request
     * @exception RequestException
    */
	public Request setExpireYear(int expireYear) throws RequestException {
		if(expireYear > 0 && expireYear > 10){
			this.expireYear = Integer.toString(expireYear);
		}else{
			throw new RequestException("Expire Year Undifined");
		}
		return this;
	}
	
	/**
     * @param double amount
     * @return Request
    */
	public Request setAmount(double amount) {
		this.amount = Double.toString(amount);
		return this;
	}
	
	/** Request object attributes Reflection validation
     * @param double amount
     * @return Request
    */
	public boolean validate(){
		// Request class
		Class<?> cls = this.getClass();
		// Class Fields
		Field clsFields[] = cls.getDeclaredFields();
		for(Field f:clsFields){
		    try {
		    	Object value = f.get(this);
		    	if(value == null){
		    		return false;
		    	}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
     * @return String orderId
    */
	public String getOrderId(){
		return this.orderId;
	}
	
	/**
     * @return String cardNumber
    */
	public String getCardNumber(){
		return this.cardNumber;
	}
	
	/**
     * @return int expireMonth
    */
	public String getExpireMonth(){
		return this.expireMonth;
	}
	
	/**
     * @return int securityCode
    */
	public String getSecurityCode(){
		return this.securityCode;
	}
	
	/**
     * @return int expireYear
    */
	public String getExpireYear(){
		return this.expireYear;
	}
	
	/**
     * @return int amount
    */
	public String getAmount(){
		return this.amount;
	}
}
