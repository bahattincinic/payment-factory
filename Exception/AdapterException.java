package Exception;

/**
* Adapter Custom Exception
* @author Bahattin Çiniç <bahattincinic@gmail.com>
*/
public class AdapterException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	/** Exception Message
     * @var string
     */
	public String message;

	/** Exception
     * @param string message
     */
	public AdapterException(String message){
		super(message);
		this.message = message;
	}
}