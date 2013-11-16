import Adapter.PaymentInterface;
import Adapter.PaymentFactory;
import Library.Request;
import Exception.*;

public class FactoryTest {

	public static void main(String[] args) {
		try {
			Request creditCardRequest = new Request();
			creditCardRequest.setCardNumber("5246489643506379")
							 .setAmount(100)
							 .setExpireMonth(10)
							 .setExpireYear(14)
							 .setSecurityCode(111)
							 .setOrderId("ORD00000");
			PaymentInterface payment = PaymentFactory.getPayment("est");
			System.out.println(payment.pay(creditCardRequest));
		} catch (AdapterException e) {
			System.out.println(e.message);
		} catch(RequestException e){
			System.out.println(e.message);
		}
	}

}
