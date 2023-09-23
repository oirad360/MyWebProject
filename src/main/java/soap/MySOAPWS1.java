package soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class MySOAPWS1 {
	@WebMethod
	public int divisione(int a, int b) {
		return a/b;
	}
}
