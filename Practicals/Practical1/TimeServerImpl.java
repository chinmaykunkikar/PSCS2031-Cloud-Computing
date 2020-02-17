package Practicals.Practical1;

import java.util.Date;
import javax.jws.WebService;

/*
The @WebService property endpointInterface links SIB (this class) to the
SEI (Practicals.Practical1.TimeServer)

Note that these methods in the implementation are not annotated as @WebMethods
*/

@WebService(endpointInterface="Practicals.Practical1.TimeServer")
public class TimeServerImpl implements TimeServer{
	public String getTimeAsString() { return new Date().toString(); }
	public long getTimeAsElapsed(){ return new Date().getTime(); }
}

