package Exception;

/**
* Request Custom Exception
* @author Bahattin Çiniç <bahattincinic@gmail.com>
*/
public class RequestException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	/** Exception Message
     * @var string
     */
	public String message;

	/** Exception
     * @param string message
     */
	public RequestException(String message){
		super(message);
		this.message = message;
	}
}