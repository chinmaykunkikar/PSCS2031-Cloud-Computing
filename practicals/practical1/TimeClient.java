package practicals.practical1;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

class TimeClient{
	public static void main(final String args[]) throws Exception {
		final URL url = new URL("http://localhost:9747/TimeServer?wsdl");

		// Qualified name of the service
		// 1st arg is the service URI
		// 2nd is the service name published in the WSDL
		final QName qname = new QName("http://practical1.practicals/", "TimeServerImplService");

		// Create, in effect, a factory for the service
		final Service service = Service.create(url, qname);

		// Extract the endpoint interface, the service "port"
		final TimeServer eif = service.getPort(TimeServer.class);
		System.out.println(eif.getTimeAsString());
		System.out.println(eif.getTimeAsElapsed());
		
	}
}